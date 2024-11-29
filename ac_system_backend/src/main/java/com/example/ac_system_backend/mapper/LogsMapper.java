package com.example.ac_system_backend.mapper;

import com.example.ac_system_backend.pojo.LogUnit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogsMapper {
    @Insert("INSERT INTO logs (room_id, log_type, cost_rate, cost_sum, log_time) VALUES (#{roomId}, #{logType}, #{costRate}, #{costSum}, #{logTime})")
    public void insertLog(LogUnit logUnit);

    @Select("SELECT * FROM logs WHERE room_id=#{roomId}")
    public List<LogUnit> selectLogByRoomId(String roomId);

    @Delete("DELETE FROM logs")
    public void deleteAll();
}
