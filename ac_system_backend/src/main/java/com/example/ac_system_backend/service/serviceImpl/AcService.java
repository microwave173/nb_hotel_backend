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

    private final PriorityQueue<AcServer> serveQueue = new PriorityQueue<>(
            Comparator.comparingInt(AcServer::getAcMode).thenComparingInt(AcServer::getNegServeTic)
    );
    private final PriorityQueue<AcRequest> waitQueue = new PriorityQueue<>(
            Comparator.comparingInt(AcRequest::getNegAcMode).thenComparingInt(AcRequest::getNegWaitTic)
    );

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

    @Override
    public synchronized boolean inServeQ(String roomId){
        for (AcServer acServer : new ArrayList<>(serveQueue)) {
            if (acServer.getRoomId().equals(roomId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized boolean inWaitQ(String roomId){
        for (AcRequest acRequest : new ArrayList<>(waitQueue)) {
            if (acRequest.getRoomId().equals(roomId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void addAcRequest(AcRequest acRequest) {
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

        if (serveQueue.isEmpty()) {
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
            Room room = iRoomService.getRoomByRoomId(acServer.getRoomId());

            float tempDu = 0;
            if(room.getAcMode() == 0) tempDu = duLow;
            if(room.getAcMode() == 1) tempDu = duMid;
            if(room.getAcMode() == 2) tempDu = duHigh;

            room.setDu(room.getDu() + tempDu);
            room.setCost(room.getCost() + tempDu * miPerDu);
            iRoomService.updateRoom(room);

            serveQueue.remove(acServer);
            acServer.setServeTic(acServer.getServeTic() + 1);
            serveQueue.offer(acServer);
        }

        List<AcRequest> waitQueueCopy = new ArrayList<>(waitQueue);
        for (AcRequest acRequest : waitQueueCopy) {
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
                    room.setTarTemperature1(acServer.getAcTemperature());
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
            if (room.getCurTemperature() < room.getTarTemperature1()) d = 0.5f;
            if (room.getCurTemperature() == room.getTarTemperature1()){
                d = 0f;
                AcRequest acRequest = new AcRequest();
                acRequest.setRoomId(room.getRoomId());
//                addLog(room.getRoomId(), "meet target temperature");
//                removeAc(acRequest);
            }
            if (room.getCurTemperature() > room.getTarTemperature1()) d = -0.5f;
            room.setCurTemperature(room.getCurTemperature() + d);
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

    String getNowTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

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
