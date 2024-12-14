package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.mapper.RoomMapper;
import com.example.ac_system_backend.mapper.UserMapper;
import com.example.ac_system_backend.pojo.Room;
import com.example.ac_system_backend.pojo.User;
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

    @Autowired
    UserMapper userMapper;

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

    @Override
    public List<String> getEmptyRooms() {
        List<User> users = userMapper.listAllUsers();
        List<Room> rooms = roomMapper.listAllRooms();
        for(User user : users){
            for(Room room : new ArrayList<>(rooms)){
                if(room.getRoomId().equals(user.getRoomId())){
                    rooms.remove(room);
                    break;
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for(Room room : rooms) ret.add(room.getRoomId());
        return ret;
    }

    @Override
    public void checkOut(String roomId) {
        List<User> users = userMapper.listAllUsers();
        for(User user : new ArrayList<>(users)){
            if(user.getRoomId().equals(roomId)){
                user.setRoomId("");
                userMapper.deleteUserByName(user.getName());
                userMapper.insertUser(user);
            }
        }
    }
}
