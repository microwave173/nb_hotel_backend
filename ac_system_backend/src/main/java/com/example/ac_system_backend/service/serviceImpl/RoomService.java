package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.mapper.RoomMapper;
import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.service.IAcService;
import com.example.ac_system_backend.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<Room> getAllRooms(){
        return roomMapper.listAllRooms();
    }

    @Override
    public Room getRoomByRoomId(String roomId) {
        return roomMapper.selectRoomByRoomId(roomId);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }
}
