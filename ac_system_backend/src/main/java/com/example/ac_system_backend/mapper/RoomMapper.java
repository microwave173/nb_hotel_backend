package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * RoomMapper 接口用于操作与房间相关的数据库表。
 * 提供查询所有房间、按房间编号查询和更新房间信息的功能。
 */
@Mapper
public interface RoomMapper {

    /**
     * 查询所有房间的状态信息。
     * 用于获取系统中所有房间的完整状态列表，例如在初始化或管理页面展示时。
     *
     * @return 返回所有房间的状态信息列表
     */
    @Select("SELECT * FROM room")
    public List<Room> listAllRooms();

    /**
     * 根据房间编号查询房间的详细信息。
     * 用于获取指定房间的当前状态，包括温度、模式和费用等。
     *
     * @param roomId 房间编号
     * @return 返回与该房间编号对应的房间对象，如果不存在则返回 null
     */
    @Select("SELECT * FROM room WHERE room_id=#{roomId}")
    public Room selectRoomByRoomId(String roomId);

    /**
     * 更新房间的状态信息。
     * 用于修改房间的属性，如电量、当前温度、目标温度、空调模式和累计费用。
     *
     * @param room 包含需要更新的房间属性的 Room 对象
     */
    @Update("UPDATE room SET du=#{du}, cur_temperature=#{curTemperature}, init_temperature=#{initTemperature}, tar_temperature=#{tarTemperature}, ac_mode=#{acMode}, cost=#{cost} WHERE room_id=#{roomId}")
    public void updateRoom(Room room);
}
