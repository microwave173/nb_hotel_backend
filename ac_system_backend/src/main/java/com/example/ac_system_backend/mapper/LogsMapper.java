package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.LogUnit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * LogsMapper 接口用于操作与详单相关的数据库表。
 * 详单记录房间的空调使用明细，包括操作类型、费用信息和操作时间。
 * 本接口提供插入详单、按房间编号查询详单，以及删除所有详单记录的功能。
 */
@Mapper
public interface LogsMapper {

    /**
     * 插入一条新的详单记录到数据库中。
     * 详单记录内容包括房间编号、操作类型（详单类型）、当前费用速率、累计费用和操作时间。
     *
     * @param logUnit 详单单元对象，包含需要插入的数据字段
     */
    @Insert("INSERT INTO logs (room_id, log_type, cost_rate, cost_sum, log_time) VALUES (#{roomId}, #{logType}, #{costRate}, #{costSum}, #{logTime})")
    public void insertLog(LogUnit logUnit);

    /**
     * 根据房间编号查询对应的详单记录。
     * 用于获取指定房间的空调使用历史，返回按房间编号过滤的详单列表。
     *
     * @param roomId 房间编号
     * @return 返回与房间编号相关的详单列表
     */
    @Select("SELECT * FROM logs WHERE room_id=#{roomId}")
    public List<LogUnit> selectLogByRoomId(String roomId);

    /**
     * 删除所有详单记录。
     * 通常用于系统初始化或测试，清空详单表中的所有数据。
     */
    @Delete("DELETE FROM logs")
    public void deleteAll();
}
