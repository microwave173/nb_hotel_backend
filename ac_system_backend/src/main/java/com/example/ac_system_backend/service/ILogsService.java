package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.pojo.Room;

import java.util.List;

public interface ILogsService {
    public void addLog(LogUnit logUnit);
    public List<LogUnit> listLogByRoomId(String roomId);
    public void deleteAll();
}
