package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.LogUnit;
import com.example.ac_system_backend.pojo.Room;

import java.util.List;

/**
 * ILogsService 接口定义了与空调系统详单管理相关的核心业务逻辑。
 * 详单记录每个房间的空调操作明细，支持添加、查询和清空操作。
 */
public interface ILogsService {

    /**
     * 添加一条新的详单记录。
     * 详单记录房间空调的具体操作信息，如操作时间、温度变化、模式切换等。
     *
     * @param logUnit 详单记录对象，记录单次操作的详细信息
     */
    public void addLog(LogUnit logUnit);

    /**
     * 根据房间编号查询该房间的所有详单记录。
     * 用于查看房间的空调使用历史，例如生成账单或分析使用情况。
     *
     * @param roomId 房间编号
     * @return 返回与该房间相关的详单记录列表
     */
    public List<LogUnit> listLogByRoomId(String roomId);

    /**
     * 删除所有详单记录。
     * 通常用于系统初始化或测试，清空所有房间的操作历史。
     */
    public void deleteAll();
}
