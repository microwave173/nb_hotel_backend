package com.example.ac_system_backend.pojo;

public class LogUnit {
    private String logType;
    private String roomId;
    private float costRate;
    private float costSum;
    private String logTime;

    public LogUnit() {}

    public LogUnit(String logType, String roomId, float costRate, float costSum, String logTime) {
        this.logType = logType;
        this.roomId = roomId;
        this.costRate = costRate;
        this.costSum = costSum;
        this.logTime = logTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public float getCostRate() {
        return costRate;
    }

    public void setCostRate(float costRate) {
        this.costRate = costRate;
    }

    public float getCostSum() {
        return costSum;
    }

    public void setCostSum(float costSum) {
        this.costSum = costSum;
    }

    @Override
    public String toString() {
        return "{" +
                "logType='" + logType + '\'' +
                ", roomId='" + roomId + '\'' +
                ", costRate=" + costRate +
                ", costSum=" + costSum +
                ", logTime='" + logTime + '\'' +
                '}';
    }
}
