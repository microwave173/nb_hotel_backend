package com.example.ac_system_backend.controller;


import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.pojo.User;
import com.example.ac_system_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RoomController {
    @Autowired
    IRoomService iRoomService;

    @Autowired
    IUserService iUserService;

    @Autowired
    ILogsService iLogsService;

    @Autowired
    IAcService iAcService;

    @Autowired
    IExcelService iExcelService;

    @Value("${ac_settings.mi_per_du}")
    private float miPerDu;

    /**
     * 初始化所有房间信息。
     * 重置房间状态（电量、温度、模式、费用）并清空所有日志。
     */
    @GetMapping("api/init")
//    @CrossOrigin(origins = "*")
    public void initRooms(){
        List<Room> rooms = iRoomService.getAllRooms();
        for(Room room : rooms){
            room.setDu(0);
            room.setCurTemperature(room.getInitTemperature());
            room.setAcMode(0);
            room.setCost(0);
            iRoomService.updateRoom(room);
        }
        iLogsService.deleteAll();
        System.out.println("---------------------------init---------------------------");
    }

    /**
     * 查询指定房间的账单费用。
     *
     * @param roomId 房间 ID
     * @param token  用户认证的 Cookie
     * @return 返回房间费用，-1 表示查询失败（例如未认证用户或房间不存在）
     */
    @GetMapping("api/get_room_cost")
//    @CrossOrigin(origins = "*")
    public float getRoomCost(String roomId, @CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return -1;
        Room room = iRoomService.getRoomByRoomId(roomId);
        if(room == null) return -1;
        return room.getCost();
    }

    /**
     * 查询当前用户所在房间的账单费用。
     *
     * @param token 用户认证的 Cookie
     * @return 返回房间费用，-1 表示查询失败（例如未认证用户或房间不存在）
     */
    @GetMapping("api/get_my_room_cost")
//    @CrossOrigin(origins = "*")
    public float getMyRoomCost(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return -1;
        User user = iUserService.getUserByToken(token);
        String roomId = user.getRoomId();
        Room room = iRoomService.getRoomByRoomId(roomId);
        if(room == null) return -1;
        return room.getCost();
    }

    /**
     * 获取所有房间的状态信息。
     *
     * @param token 用户认证的 Cookie
     * @return 返回所有房间状态列表，认证失败返回 null
     */
    @GetMapping("api/get_room_status")  // trans ok
//    @CrossOrigin(origins = "*")
    public List<Room> getRoomStatus(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        return iAcService.getRoomStatus();
    }

    /**
     * 查询指定房间的详单（日志）。
     *
     * @param roomId 房间 ID
     * @param token  用户认证的 Cookie
     * @return 返回房间的详单列表，认证失败或房间不存在时返回 null
     */
    @GetMapping("api/get_room_logs")
//    @CrossOrigin(origins = "*")
    public List<LogUnit> getRoomLogs(String roomId, @CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        return iLogsService.listLogByRoomId(roomId);
    }

    /**
     * 查询当前用户所在房间的详单（日志）。
     *
     * @param token 用户认证的 Cookie
     * @return 返回房间的详单列表，认证失败时返回 null
     */
    @GetMapping("api/get_my_room_logs")
//    @CrossOrigin(origins = "*")
    public List<LogUnit> getMyRoomLogs(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        User user = iUserService.getUserByToken(token);
        String roomId = user.getRoomId();
        return iLogsService.listLogByRoomId(roomId);
    }

    /**
     * 查询当前用户所在房间。
     *
     * @param token 用户认证的 Cookie
     * @return 返回房间，认证失败时返回 null
     */
    @GetMapping("api/get_my_room")
    public Room getMyRoom(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        User user = iUserService.getUserByToken(token);
        String roomId = user.getRoomId();
        return iRoomService.getRoomByRoomId(roomId);
    }

    /**
     * 查询当前所有有空房间。
     *
     * @param token 用户认证的 Cookie
     * @return 返回房间列表，认证失败时返回 null
     */
    @GetMapping("api/get_all_empty_rooms")
    public List<String> getAllEmptyRooms(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        return iRoomService.getEmptyRooms();
    }

    /**
     * 退房。
     *
     * @param room 房间
     * @param token 用户认证的 Cookie
     * @return 成功返回"success"，验证失败返回"failed"
     */
    @PostMapping("api/check_out")
    public String checkOut(@RequestBody Room room, @CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return "failed";
        iRoomService.checkOut(room.getRoomId());
        return "success";
    }

    /**
     * 获取详单。
     *
     * @param roomId 房间号
     * @param token 用户认证的 Cookie
     * @return 返回xlsx的二进制流。
     */
    @GetMapping("api/get_log_xlsx")
    public ResponseEntity<byte[]> getLogXlsx(String roomId, @CookieValue("token") String token) throws IOException {
        if(!iUserService.checkUser(token)) return null;
        return iExcelService.getLogXlsx(roomId);
    }

    /**
     * 获取账单。
     *
     * @param roomId 房间号
     * @param token 用户认证的 Cookie
     * @return 返回xlsx的二进制流。
     */
    @GetMapping("api/get_cost_xlsx")
    public ResponseEntity<byte[]> getCostXlsx(String roomId, @CookieValue("token") String token) throws IOException {
        if(!iUserService.checkUser(token)) return null;
        return iExcelService.getCostXlsx(roomId);
    }
}
