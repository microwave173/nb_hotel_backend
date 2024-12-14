package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.AcRequest;
import com.example.ac_system_backend.pojo.Room;

import java.util.List;

/**
 * IAcService 接口定义了空调系统的核心业务逻辑。
 * 主要功能包括空调请求管理、队列更新、服务状态展示和时间步更新等。
 */
public interface IAcService {

    /**
     * 添加新的空调请求。
     * 当用户希望对某个房间的空调设置进行调整时，调用此方法添加请求。
     *
     * @param acRequest 空调请求对象，包含房间号、目标温度、风速模式等信息
     */
    public void addAcRequest(AcRequest acRequest);

    /**
     * 根据房间号获取对应的空调请求信息。
     *
     * @param roomId 房间编号
     * @return 返回与该房间对应的空调请求对象
     */
    public AcRequest getAcRequestByRoomId(String roomId);

    /**
     * 更新空调服务队列。
     * 用于调度队列中的空调请求，根据优先级或策略调整服务顺序。
     */
    public void updateQueue();

    /**
     * 更新空调设置。
     * 可用于更改房间空调的温度、风速模式等设置。
     *
     * @param acRequest 空调请求对象，包含需要更新的目标值
     * @param updateType 更新类型描述，例如 "update temperature" 或 "update mode"
     */
    public void updateAc(AcRequest acRequest, String updateType);

    /**
     * 移除空调请求。
     * 当用户关闭空调时，从队列中移除对应的请求。
     *
     * @param acRequest 要移除的空调请求对象
     */
    public void removeAc(AcRequest acRequest);

    /**
     * 展示当前服务队列和等待队列的状态（调试用）。
     *
     * @return 返回描述服务队列和等待队列状态的字符串信息
     */
    public String showQueue();

    /**
     * 模拟时间步更新。
     * 每调用一次，推进时间步，用于更新空调系统的运行状态（例如服务时间增加、队列更新等）。
     */
    public void tic();

    /**
     * 获取所有房间的状态信息。
     * 返回所有房间当前的空调服务状态，用于前端展示或状态监控。
     *
     * @return 返回房间状态的列表
     */
    public List<Room> getRoomStatus();
}
