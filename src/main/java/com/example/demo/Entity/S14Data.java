package com.example.demo.Entity;

import java.util.List;

public class S14Data {
    long actualBeat;//
    double webWidth;
    double flangeWidth;
    double webThick;
    double flangeThick;
    double length;
    long startTime;
    long runtimeStatus;
    long processingTimes;
    long alarmStatus;
    long maintainTime;
    long remainDays;
    long heartBeat;
    private List<String> preStatus;//过去20次变化

    public List<String> getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(List<String> preStatus) {
        this.preStatus = preStatus;
    }

    public long getActualBeat() {
        return actualBeat;
    }

    public void setActualBeat(long actualBeat) {
        this.actualBeat = actualBeat;
    }

    public double getWebWidth() {
        return webWidth;
    }

    public void setWebWidth(double webWidth) {
        this.webWidth = webWidth;
    }

    public double getFlangeWidth() {
        return flangeWidth;
    }

    public void setFlangeWidth(double flangeWidth) {
        this.flangeWidth = flangeWidth;
    }

    public double getWebThick() {
        return webThick;
    }

    public void setWebThick(double webThick) {
        this.webThick = webThick;
    }

    public double getFlangeThick() {
        return flangeThick;
    }

    public void setFlangeThick(double flangeThick) {
        this.flangeThick = flangeThick;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getRuntimeStatus() {
        return runtimeStatus;
    }

    public void setRuntimeStatus(long runtimeStatus) {
        this.runtimeStatus = runtimeStatus;
    }

    public long getProcessingTimes() {
        return processingTimes;
    }

    public void setProcessingTimes(long processingTimes) {
        this.processingTimes = processingTimes;
    }

    public long getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(long alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public long getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(long maintainTime) {
        this.maintainTime = maintainTime;
    }

    public long getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(long remainDays) {
        this.remainDays = remainDays;
    }

    public long getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(long heartBeat) {
        this.heartBeat = heartBeat;
    }

    public S14Data() {
    }


}
