package com.example.ac_system_backend.controller;


import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.service.IRoomService;
import com.example.ac_system_backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    IRoomService iRoomService;

    @Autowired
    IUserService iUserService;

    @Value("${ac_settings.mi_per_du}")
    private float miPerDu;

    @GetMapping("api/init")
    public void initRooms(){
        List<Room> rooms = iRoomService.getAllRooms();
        for(Room room : rooms){
            room.setDu(0);
            room.setCurTemperature(room.getInitTemperature());
            room.setAcMode(0);
            iRoomService.updateRoom(room);
        }
    }

    @GetMapping("api/get_room_cost")
    public float getRoomCost(String roomId, @CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return -1;
        Room room = iRoomService.getRoomByRoomId(roomId);
        if(room == null) return -1;
        return room.getDu() * miPerDu;
    }

    @GetMapping("api/get_room_status")
    public List<Room> getRoomStatus(@CookieValue("token") String token){
        if(!iUserService.checkUser(token)) return null;
        return iRoomService.getRoomStatus();
    }
}
