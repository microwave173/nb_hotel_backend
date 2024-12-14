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
    private int status;  // 0在服务队列， 1在等待队列， 2关

    private boolean cool = true;



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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", du=" + du +
                ", cost=" + cost +
                ", curTemperature=" + curTemperature +
                ", initTemperature=" + initTemperature +
                ", tarTemperature=" + tarTemperature +
                ", tarTemperature1=" + tarTemperature1 +
                ", acMode=" + acMode +
                ", status=" + status +
                ", cool=" + cool +
                '}';
    }
}
