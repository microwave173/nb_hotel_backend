package com.example.ac_system_backend.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AcRequest {
    private String roomId;
    private int acTemperature;
    private int acMode;  // low, mid, high
    private boolean acOn;
    private boolean cool;

    private int waitTic;

    @Value("${ac_settings.swap_tic}")
    private int swapTic;

    public AcRequest(){
        this.roomId = "000";
        this.acTemperature = 22;
        this.acMode = 0;
        this.acOn = false;
        this.waitTic = 0;
    }

    public AcRequest(String roomId, int acTemperature, int acMode, boolean acOn) {
        this.roomId = roomId;
        this.acTemperature = acTemperature;
        this.acMode = acMode;
        this.acOn = acOn;
    }

    public void loadFromAcServer(AcServer acServer){
        this.roomId = acServer.getRoomId();
        this.acTemperature = acServer.getAcTemperature();
        this.acMode = acServer.getAcMode();
        this.acOn = acServer.isAcOn();
    }

    public boolean betterThan(AcRequest other){
        if(this.acMode != other.acMode){
            return this.acMode > other.acMode;
        }
        else{
            return this.waitTic >= other.waitTic;
        }
    }

    public boolean betterThan(AcServer other){
        if(this.acMode != other.getAcMode()){
            return this.acMode > other.getAcMode();
        }
        else{
            return this.waitTic >= this.swapTic;
        }
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getAcTemperature() {
        return acTemperature;
    }

    public void setAcTemperature(int acTemperature) {
        this.acTemperature = acTemperature;
    }

    public int getAcMode() {
        return acMode;
    }

    public void setAcMode(int acMode) {
        this.acMode = acMode;
    }

    public boolean isAcOn() {
        return acOn;
    }

    public void setAcOn(boolean acOn) {
        this.acOn = acOn;
    }

    public int getWaitTic() {
        return waitTic;
    }

    public void setWaitTic(int waitTic) {
        this.waitTic = waitTic;
    }

    public int getNegAcMode(){
        return -this.acMode;
    }

    public int getNegWaitTic(){
        return -this.waitTic;
    }

    public AcServer toAcServer(){
        AcServer acServer = new AcServer();
        acServer.loadFromRequest(this);
        acServer.setServeTic(0);
        return acServer;
    }

    public boolean isCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
    }

    //    @Override
//    public String toString() {
//        return "{" +
//                "roomId='" + roomId + '\'' +
//                ", acTemperature=" + acTemperature +
//                ", acMode=" + acMode +
//                '}';
//    }


    @Override
    public String toString() {
        return roomId;
    }
}
