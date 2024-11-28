package com.example.ac_system_backend.pojo;

public class Room {
    private String roomId;
    private float du;
    private float cost;
    private float curTemperature;
    private float initTemperature;
    private float tarTemperature;
    private float tarTemperature1;
    private int acMode;

    public Room() {
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public float getDu() {
        return du;
    }

    public void setDu(float du) {
        this.du = du;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCurTemperature() {
        return curTemperature;
    }

    public void setCurTemperature(float curTemperature) {
        this.curTemperature = curTemperature;
    }

    public float getInitTemperature() {
        return initTemperature;
    }

    public void setInitTemperature(float initTemperature) {
        this.initTemperature = initTemperature;
    }

    public float getTarTemperature() {
        return tarTemperature;
    }

    public void setTarTemperature(float tarTemperature) {
        this.tarTemperature = tarTemperature;
    }

    public int getAcMode() {
        return acMode;
    }

    public void setAcMode(int acMode) {
        this.acMode = acMode;
    }

    public float getTarTemperature1() {
        return tarTemperature1;
    }

    public void setTarTemperature1(float tarTemperature1) {
        this.tarTemperature1 = tarTemperature1;
    }
}
