package com.example.demo.Entity;

import java.util.List;

public class S17Data {
    private Long fan1TotalTime;//风机1累计时间
    private Long fan2TotalTime;//风机2累计时间
    private Long separateTotalTime;//分离累计时间
    private Long increaseTotalTime;//提升累计时间
    private Long transverseTotalTime;//横向累计时间
    private Long verticalTotalTime;//纵向累计时间
    private Long recoveryTotalTime;//回收累计时间
    private Long blowback1TotalTime;//反吹1累计时间
    private Long blowback2TotalTime;//反吹2累计时间
    private Long throw1TotalTime;//抛1累计时间
    private Long throw2TotalTime;//抛2累计时间
    private Long throw3TotalTime;//抛3累计时间
    private Long throw4TotalTime;//抛4累计时间
    private Long throw5TotalTime;//抛5累计时间
    private Long throw6TotalTime;//抛6累计时间
    private Long throw7TotalTime;//抛7累计时间
    private Long throw8TotalTime;//抛8累计时间
    private Long startupTime;//设备开机时间
    private Long runStatus;//设备运行状态
    private Long output;//设备产量
    private Long statusAlarm;//设备状态报警
    private Long maintenanceTime;//设备维护时间
    private Long maintenanceRemainDay;//设备维护剩余天数
    private Long heartbeatFlag;//设备心跳标志
    private Long heartBeat;//生产节拍
    private List<String> preStatus;//过去20次变化

    public List<String> getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(List<String> preStatus) {
        this.preStatus = preStatus;
    }

    public Long getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Long heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Long getFan1TotalTime() {
        return fan1TotalTime;
    }

    public void setFan1TotalTime(Long fan1TotalTime) {
        this.fan1TotalTime = fan1TotalTime;
    }

    public Long getFan2TotalTime() {
        return fan2TotalTime;
    }

    public void setFan2TotalTime(Long fan2TotalTime) {
        this.fan2TotalTime = fan2TotalTime;
    }

    public Long getSeparateTotalTime() {
        return separateTotalTime;
    }

    public void setSeparateTotalTime(Long separateTotalTime) {
        this.separateTotalTime = separateTotalTime;
    }

    public Long getIncreaseTotalTime() {
        return increaseTotalTime;
    }

    public void setIncreaseTotalTime(Long increaseTotalTime) {
        this.increaseTotalTime = increaseTotalTime;
    }

    public Long getTransverseTotalTime() {
        return transverseTotalTime;
    }

    public void setTransverseTotalTime(Long transverseTotalTime) {
        this.transverseTotalTime = transverseTotalTime;
    }

    public Long getVerticalTotalTime() {
        return verticalTotalTime;
    }

    public void setVerticalTotalTime(Long verticalTotalTime) {
        this.verticalTotalTime = verticalTotalTime;
    }

    public Long getRecoveryTotalTime() {
        return recoveryTotalTime;
    }

    public void setRecoveryTotalTime(Long recoveryTotalTime) {
        this.recoveryTotalTime = recoveryTotalTime;
    }

    public Long getBlowback1TotalTime() {
        return blowback1TotalTime;
    }

    public void setBlowback1TotalTime(Long blowback1TotalTime) {
        this.blowback1TotalTime = blowback1TotalTime;
    }

    public Long getBlowback2TotalTime() {
        return blowback2TotalTime;
    }

    public void setBlowback2TotalTime(Long blowback2TotalTime) {
        this.blowback2TotalTime = blowback2TotalTime;
    }

    public Long getThrow1TotalTime() {
        return throw1TotalTime;
    }

    public void setThrow1TotalTime(Long throw1TotalTime) {
        this.throw1TotalTime = throw1TotalTime;
    }

    public Long getThrow2TotalTime() {
        return throw2TotalTime;
    }

    public void setThrow2TotalTime(Long throw2TotalTime) {
        this.throw2TotalTime = throw2TotalTime;
    }

    public Long getThrow3TotalTime() {
        return throw3TotalTime;
    }

    public void setThrow3TotalTime(Long throw3TotalTime) {
        this.throw3TotalTime = throw3TotalTime;
    }

    public Long getThrow4TotalTime() {
        return throw4TotalTime;
    }

    public void setThrow4TotalTime(Long throw4TotalTime) {
        this.throw4TotalTime = throw4TotalTime;
    }

    public Long getThrow5TotalTime() {
        return throw5TotalTime;
    }

    public void setThrow5TotalTime(Long throw5TotalTime) {
        this.throw5TotalTime = throw5TotalTime;
    }

    public Long getThrow6TotalTime() {
        return throw6TotalTime;
    }

    public void setThrow6TotalTime(Long throw6TotalTime) {
        this.throw6TotalTime = throw6TotalTime;
    }

    public Long getThrow7TotalTime() {
        return throw7TotalTime;
    }

    public void setThrow7TotalTime(Long throw7TotalTime) {
        this.throw7TotalTime = throw7TotalTime;
    }

    public Long getThrow8TotalTime() {
        return throw8TotalTime;
    }

    public void setThrow8TotalTime(Long throw8TotalTime) {
        this.throw8TotalTime = throw8TotalTime;
    }

    public Long getStartupTime() {
        return startupTime;
    }

    public void setStartupTime(Long startupTime) {
        this.startupTime = startupTime;
    }

    public Long getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Long runStatus) {
        this.runStatus = runStatus;
    }

    public Long getOutput() {
        return output;
    }

    public void setOutput(Long output) {
        this.output = output;
    }

    public Long getStatusAlarm() {
        return statusAlarm;
    }

    public void setStatusAlarm(Long statusAlarm) {
        this.statusAlarm = statusAlarm;
    }

    public Long getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Long maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public Long getMaintenanceRemainDay() {
        return maintenanceRemainDay;
    }

    public void setMaintenanceRemainDay(Long maintenanceRemainDay) {
        this.maintenanceRemainDay = maintenanceRemainDay;
    }

    public Long getHeartbeatFlag() {
        return heartbeatFlag;
    }

    public void setHeartbeatFlag(Long heartbeatFlag) {
        this.heartbeatFlag = heartbeatFlag;
    }

    public S17Data() {
    }

}
