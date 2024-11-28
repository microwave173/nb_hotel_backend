package com.example.ac_system_backend.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AcServer {
    private String roomId;
    private int acTemperature;
    private int acMode;  // low, mid, high
    private boolean acOn;

    private int serveTic;

    private int swapTic = 2;

    public AcServer() {
    }

    public void loadFromRequest(AcRequest acRequest){
        this.roomId = acRequest.getRoomId();
        this.acTemperature = acRequest.getAcTemperature();
        this.acMode = acRequest.getAcMode();
        this.acOn = acRequest.isAcOn();
    }

    public boolean betterThan(AcServer other){
        if(this.acMode != other.acMode){
            return this.acMode > other.acMode;
        }
        else{
            return this.serveTic >= other.serveTic;
        }
    }

    public boolean lessThan(AcServer other){
        if(this.acMode != other.acMode){
            return this.acMode < other.acMode;
        }
        else{
            return this.serveTic > other.serveTic;
        }
    }

    public boolean lessThan(AcRequest other, int swapTic){
        if(this.acMode != other.getAcMode()){
            return this.acMode < other.getAcMode();
        }
        else{
            return other.getWaitTic() >= swapTic;
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

    public int getServeTic() {
        return serveTic;
    }

    public void setServeTic(int serveTic) {
        this.serveTic = serveTic;
    }

    public int getNegAcMode(){
        return -this.acMode;
    }

    public int getNegServeTic(){
        return -this.serveTic;
    }

    public AcRequest toAcRequest(){
        AcRequest acRequest = new AcRequest();
        acRequest.loadFromAcServer(this);
        acRequest.setWaitTic(0);
        return acRequest;
    }

    @Override
    public String toString() {
        return "{" +
                "roomId='" + roomId + '\'' +
                ", acTemperature=" + acTemperature +
                ", acMode=" + acMode +
                '}';
    }
}
