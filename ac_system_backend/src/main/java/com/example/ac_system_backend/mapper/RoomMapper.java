package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("SELECT * FROM room")
    public List<Room> listAllRooms();
    @Select("SELECT * FROM room WHERE room_id=#{roomId}")
    public Room selectRoomByRoomId(String roomId);

    @Update("UPDATE room SET du=#{du}, cur_temperature=#{curTemperature}, init_temperature=#{initTemperature}, tar_temperature=#{tarTemperature}, ac_mode=#{acMode}, cost=#{cost} WHERE room_id=#{roomId}")
    public void updateRoom(Room room);
}
