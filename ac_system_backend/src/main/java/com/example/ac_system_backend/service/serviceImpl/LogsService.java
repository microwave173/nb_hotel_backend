package com.example.ac_system_backend.service.serviceImpl;

import com.example.ac_system_backend.mapper.LogsMapper;
import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.service.ILogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService implements ILogsService {
    @Autowired
    LogsMapper logsMapper;

    @Override
    public void addLog(LogUnit logUnit) {
        logsMapper.insertLog(logUnit);
    }

    @Override
    public List<LogUnit> listLogByRoomId(String roomId) {
        return logsMapper.selectLogByRoomId(roomId);
    }

    @Override
    public void deleteAll() {
        logsMapper.deleteAll();
    }
}
