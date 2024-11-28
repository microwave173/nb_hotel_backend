package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.Room;

import java.util.List;

public interface IRoomService {
    public List<Room> getAllRooms();
    public Room getRoomByRoomId(String roomId);
    public void updateRoom(Room room);

    public List<Room> getRoomStatus();
}
