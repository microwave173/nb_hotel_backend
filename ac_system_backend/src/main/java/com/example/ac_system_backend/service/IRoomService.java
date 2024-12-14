package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.Room;

import java.util.List;

/**
 * IRoomService 接口定义了与房间管理相关的核心业务逻辑。
 * 提供房间信息的查询和更新操作，支持获取所有房间状态、按房间编号查询，以及更新房间信息。
 */
public interface IRoomService {

    /**
     * 获取所有房间的状态信息。
     * 通常用于初始化或系统管理时，获取系统中所有房间的当前状态。
     *
     * @return 返回包含所有房间信息的列表
     */
    public List<Room> getAllRooms();

    /**
     * 根据房间编号获取房间的详细信息。
     * 用于查询特定房间的状态和属性，例如温度、模式和费用。
     *
     * @param roomId 房间编号
     * @return 返回与该编号对应的房间对象，如果房间不存在则返回 null
     */
    public Room getRoomByRoomId(String roomId);

    /**
     * 更新房间的状态信息。
     * 用于修改房间的属性，如温度、模式、费用等，提交更新到系统。
     *
     * @param room 房间对象，包含需要更新的属性
     */
    public void updateRoom(Room room);

    /**
     * 获取所有空房间的房间号。
     *
     * @return 返回空房间的房间号列表
     */
    public List<String> getEmptyRooms();

    public void checkOut(String roomId);
}
