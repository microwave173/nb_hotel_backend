package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.pojo.AcRequest;
import com.example.ac_system_backend.pojo.AcServer;
import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.service.IAcService;
import com.example.ac_system_backend.service.ILogsService;
import com.example.ac_system_backend.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class AcService implements IAcService {
    @Value("${ac_settings.du_per_min_low}")
    private float duLow;

    @Value("${ac_settings.du_per_min_mid}")
    private float duMid;

    @Value("${ac_settings.du_per_min_high}")
    private float duHigh;

    @Value("${ac_settings.max_ac_server_num}")
    private int maxAcServerNum;

    @Value("${ac_settings.swap_tic}")
    private int swapTic;

    @Value("${ac_settings.mi_per_du}")
    private float miPerDu;

    @Value("${room_prices}")
    private List<Float> roomPriceList;

    @Autowired
    private IRoomService iRoomService;

    @Autowired
    private ILogsService iLogsService;

    // 服务队列：使用优先队列存储当前正在服务的空调请求
    // 优先级规则：按空调模式（风速）优先级排序，相同模式下按服务时间倒序排序
    private final PriorityQueue<AcServer> serveQueue = new PriorityQueue<>(
            Comparator.comparingInt(AcServer::getAcMode).thenComparingInt(AcServer::getNegServeTic)
    );

    // 等待队列：使用优先队列存储尚未分配服务的空调请求
    // 优先级规则：按空调模式（风速）优先级排序（取反以支持倒序），相同模式下按等待时间倒序排序
    private final PriorityQueue<AcRequest> waitQueue = new PriorityQueue<>(
            Comparator.comparingInt(AcRequest::getNegAcMode).thenComparingInt(AcRequest::getNegWaitTic)
    );

    /**
     * 检查指定房间是否已经存在于服务队列或等待队列中。
     *
     * @param roomId 房间编号
     * @return 如果房间已存在于任一队列中返回 true，否则返回 false
     */
    private synchronized boolean checkExist(String roomId) {
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) {
                return true;
            }
        }
        for (AcRequest acRequest : new ArrayList<>(waitQueue)) {
            if (acRequest.getRoomId().equals(roomId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查指定房间是否在服务队列中。
     *
     * @param roomId 房间编号
     * @return 如果房间在服务队列中返回 true，否则返回 false
     */
    synchronized boolean inServeQ(String roomId){
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查指定房间是否在等待队列中。
     *
     * @param roomId 房间编号
     * @return 如果房间在等待队列中返回 true，否则返回 false
     */
    synchronized boolean inWaitQ(String roomId){
        for (AcRequest acRequest : new ArrayList<>(waitQueue)) {
            if (acRequest.getRoomId().equals(roomId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void addAcRequest(AcRequest acRequest) {
        float roomInitTemp = iRoomService.getRoomByRoomId(acRequest.getRoomId()).getInitTemperature();
        float tarTemp;
//        if(acRequest.isCool()){
//            tarTemp = Float.min(roomInitTemp, acRequest.getAcTemperature());
//        }
//        else{
//            tarTemp = Float.max(roomInitTemp, acRequest.getAcTemperature());
//        }
        tarTemp = acRequest.getAcTemperature();
        acRequest.setAcTemperature((int) tarTemp);
        if (checkExist(acRequest.getRoomId())) return;
        addLog(acRequest.getRoomId(), "turn on");

        if (serveQueue.size() < maxAcServerNum) {
            serveQueue.offer(acRequest.toAcServer());
        } else {
            waitQueue.offer(acRequest);
        }
        updateQueue();
    }

    @Override
    public synchronized void updateQueue() {
        if (waitQueue.isEmpty()) return;

        if (serveQueue.size() < maxAcServerNum) {
            while (!waitQueue.isEmpty() && serveQueue.size() < maxAcServerNum) {
                AcRequest acRequest = waitQueue.poll();
                if (acRequest != null) {
                    serveQueue.offer(acRequest.toAcServer());
                }
            }
            return;
        }

        int max_loop = 1000;
        while (!serveQueue.isEmpty() && !waitQueue.isEmpty() && max_loop > 0) {
            AcServer serveHead = serveQueue.peek();
            AcRequest waitHead = waitQueue.peek();

            if (serveHead == null || waitHead == null || !serveHead.lessThan(waitHead, swapTic)) break;

            serveQueue.poll();
            waitQueue.poll();
            serveQueue.offer(waitHead.toAcServer());
            waitQueue.offer(serveHead.toAcRequest());
            addLog(serveHead.getRoomId(), "removed from serve queue");
            addLog(waitHead.getRoomId(), "add to serve queue");
            max_loop -= 1;
        }
    }

    @Override
    public synchronized void updateAc(AcRequest acRequest, String updateType) {
        float roomInitTemp = iRoomService.getRoomByRoomId(acRequest.getRoomId()).getInitTemperature();
        float tarTemp;
//        if(acRequest.isCool()){
//            tarTemp = Float.min(roomInitTemp, acRequest.getAcTemperature());
//        }
//        else{
//            tarTemp = Float.max(roomInitTemp, acRequest.getAcTemperature());
//        }
        tarTemp = acRequest.getAcTemperature();
        acRequest.setAcTemperature((int) tarTemp);
        addLog(acRequest.getRoomId(), updateType);
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(acRequest.getRoomId())) {
                serveQueue.remove(acServer);
                AcServer updatedServer = acRequest.toAcServer();
                updatedServer.setServeTic(acServer.getServeTic());
                serveQueue.offer(updatedServer);
                updateQueue();
                return;
            }
        }
        for (AcRequest acRequest1 : new ArrayList<>(waitQueue)) {
            if (acRequest1.getRoomId().equals(acRequest.getRoomId())) {
                waitQueue.remove(acRequest1);
                waitQueue.offer(acRequest);
                updateQueue();
                return;
            }
        }
    }

    @Override
    public synchronized void removeAc(AcRequest acRequest) {
        if(!checkExist(acRequest.getRoomId())) return;

        String roomId = acRequest.getRoomId();
        addLog(roomId, "turn off");
        Room room = iRoomService.getRoomByRoomId(roomId);
        room.setCost(room.getCost() + roomPriceList.get(Integer.parseInt(roomId) - 1));
        iRoomService.updateRoom(room);

        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) {
                serveQueue.remove(acServer);
                updateQueue();
                return;
            }
        }
        for (AcRequest acRequest1 : new ArrayList<>(waitQueue)) {
            if (acRequest1.getRoomId().equals(roomId)) {
                waitQueue.remove(acRequest1);
                updateQueue();
                return;
            }
        }
    }

    @Override
    public synchronized String showQueue() {
        List<AcServer> serveQueueCopy = new ArrayList<>(serveQueue);
        List<AcRequest> waitQueueCopy = new ArrayList<>(waitQueue);

        System.out.println("serve queue: " + serveQueueCopy + "\n" + "wait queue: " + waitQueueCopy + "\n");
        return "{\"serve_queue\": " + serveQueueCopy + ", " + "\"wait_queue\": " + waitQueueCopy + "}";
    }

    @Override
    public synchronized void tic() {
        List<AcServer> serveQueueCopy = new ArrayList<>(serveQueue);
        for (AcServer acServer : serveQueueCopy) {
            serveQueue.remove(acServer);
            acServer.setServeTic(acServer.getServeTic() + 1);
            serveQueue.offer(acServer);
        }

        List<AcRequest> waitQueueCopy = new ArrayList<>(waitQueue);
        for (AcRequest acRequest : waitQueueCopy) {
            Room room = iRoomService.getRoomByRoomId(acRequest.getRoomId());
            room.setCool(acRequest.isCool());
            iRoomService.updateRoom(room);

            waitQueue.remove(acRequest);
            acRequest.setWaitTic(acRequest.getWaitTic() + 1);
            waitQueue.offer(acRequest);
        }
        updateQueue();

        List<Room> rooms = iRoomService.getAllRooms();
        for (Room value : rooms) value.setTarTemperature1(value.getInitTemperature());
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            for (Room room : rooms) {
                if (acServer.getRoomId().equals(room.getRoomId())) {
                    float tarTemp;
                    if(acServer.isCool()){
                        tarTemp = Float.min(room.getInitTemperature(), acServer.getAcTemperature());
                    }
                    else{
                        tarTemp = Float.max(room.getInitTemperature(), acServer.getAcTemperature());
                    }
                    room.setTarTemperature1(tarTemp);
                    room.setTarTemperature(acServer.getAcTemperature());
                    room.setAcMode(acServer.getAcMode());
                    break;
                }
            }
        }
        for (AcRequest acRequest : new ArrayList<>(waitQueue)) {
            for (Room room : rooms) {
                if (acRequest.getRoomId().equals(room.getRoomId())) {
                    room.setTarTemperature(acRequest.getAcTemperature());
                    room.setAcMode(acRequest.getAcMode());
                    break;
                }
            }
        }
        for (Room room : rooms) {
            float d = 0;
            if (room.getCurTemperature() < room.getTarTemperature1()) d = 1f;
            if (room.getCurTemperature() == room.getTarTemperature1()){
                d = 0f;
                AcRequest acRequest = new AcRequest();
                acRequest.setRoomId(room.getRoomId());
//                addLog(room.getRoomId(), "meet target temperature");
//                removeAc(acRequest);
            }
            if (room.getCurTemperature() > room.getTarTemperature1()) d = -1f;
            if(room.getAcMode() == 0) d *= 0.3333;
            if(room.getAcMode() == 1) d *= 0.5;
            if(room.getAcMode() == 2) d *= 1;
            room.setCurTemperature(room.getCurTemperature() + d);
            iRoomService.updateRoom(room);
        }

        serveQueueCopy = new ArrayList<>(serveQueue);
        for (AcServer acServer : serveQueueCopy){
            Room room = iRoomService.getRoomByRoomId(acServer.getRoomId());

            float tempDu = 0;
            if(room.getAcMode() == 0) tempDu = duLow;
            if(room.getAcMode() == 1) tempDu = duMid;
            if(room.getAcMode() == 2) tempDu = duHigh;

            room.setDu(room.getDu() + tempDu);
            room.setCost(room.getCost() + tempDu * miPerDu);
            room.setCool(acServer.isCool());
            iRoomService.updateRoom(room);
        }
    }

    @Override
    public synchronized AcRequest getAcRequestByRoomId(String roomId) {
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) {
                return acServer.toAcRequest();
            }
        }
        for (AcRequest acRequest : new ArrayList<>(waitQueue)) {
            if (acRequest.getRoomId().equals(roomId)) {
                return acRequest;
            }
        }
        return null;
    }

    @Override
    public synchronized List<Room> getRoomStatus(){
        List<Room> rooms = iRoomService.getAllRooms();
        for(Room room : rooms){
            if(inServeQ(room.getRoomId())){
                room.setStatus(0);
            }
            else if(inWaitQ(room.getRoomId())){
                room.setStatus(1);
            }
            else{
                room.setStatus(2);
            }
        }
        return rooms;
    }

    /**
     * 获取当前系统时间，并格式化为指定的日期时间格式。
     *
     * @return 返回格式化后的当前时间字符串，格式为 "yyyy-MM-dd HH:mm:ss"
     */
    String getNowTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    /**
     * 添加房间的空调操作日志（详单）。
     *
     * @param roomId  房间编号
     * @param logType 日志类型，表示操作类型（如开机、关机、调温等）
     */
    void addLog(String roomId, String logType){
        Room room = iRoomService.getRoomByRoomId(roomId);
        if(room == null) return;
        float costRate = duLow * miPerDu;
        if(room.getAcMode() == 1) costRate = duMid * miPerDu;
        if(room.getAcMode() == 2) costRate = duHigh * miPerDu;
        boolean flag = false;
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) flag = true;
        }
        if(!flag) costRate = 0;
        LogUnit log = new LogUnit(logType, roomId, costRate, room.getCost(), getNowTime());
        System.out.println(log);
        iLogsService.addLog(log);
    }

    void updateAcOn(){
        List<Room> rooms = iRoomService.getAllRooms();
        for(Room room : new ArrayList<>(rooms)) {
            boolean flag = false;
            for (AcServer acServer : new ArrayList<>(serveQueue)) {
                if (acServer.getRoomId().equals(room.getRoomId())) flag = true;
            }
            // TODO: 修改房间空调开关状态
        }
    }
}
