package com.example.ac_system_backend.service;

import com.example.ac_system_backend.pojo.AcRequest;
import com.example.ac_system_backend.pojo.Room;

import java.util.List;

public interface IAcService {
    public void addAcRequest(AcRequest acRequest);

    public AcRequest getAcRequestByRoomId(String roomId);

    public void updateQueue();

    public void updateAc(AcRequest acRequest, String updateType);

    public void removeAc(AcRequest acRequest);

    public String showQueue();

    public void tic();

    public boolean inServeQ(String roomId);
    public boolean inWaitQ(String roomId);

    public List<Room> getRoomStatus();
}
