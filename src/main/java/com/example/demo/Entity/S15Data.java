package com.example.demo.Entity;

import java.util.List;

public class S15Data {
    private Long heartBeat;//生产节拍
    private int sysStatus;//系统状态
    private double length;//材料实际长度
    private double rotateLength;//主轴旋转长度
    private long completeTasks;//已完成任务数
    private long dailyDrillNum;//当日钻孔数量
    private long totalDrillNum;//总钻孔数量
    private String startupTime;//当日开机时间
    private String processTime;//当日加工时间
    private String totalStartupTime;//总开机时间
    private String totalProcessTime;//总加工时间
    private String processTaskName;//当前加工任务名
    private double webWidth;
    private double flangeWidth;
    private double webThick;

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

    private double flangeThick;

    private String failureInfo;//设备故障信息

    public int getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(int sysStatus) {
        this.sysStatus = sysStatus;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRotateLength() {
        return rotateLength;
    }

    public void setRotateLength(double rotateLength) {
        this.rotateLength = rotateLength;
    }

    public long getCompleteTasks() {
        return completeTasks;
    }

    public void setCompleteTasks(long completeTasks) {
        this.completeTasks = completeTasks;
    }

    public long getDailyDrillNum() {
        return dailyDrillNum;
    }

    public void setDailyDrillNum(long dailyDrillNum) {
        this.dailyDrillNum = dailyDrillNum;
    }

    public long getTotalDrillNum() {
        return totalDrillNum;
    }

    public void setTotalDrillNum(long totalDrillNum) {
        this.totalDrillNum = totalDrillNum;
    }

    public String getStartupTime() {
        return startupTime;
    }

    public void setStartupTime(String startupTime) {
        this.startupTime = startupTime;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getTotalStartupTime() {
        return totalStartupTime;
    }

    public void setTotalStartupTime(String totalStartupTime) {
        this.totalStartupTime = totalStartupTime;
    }

    public String getTotalProcessTime() {
        return totalProcessTime;
    }

    public void setTotalProcessTime(String totalProcessTime) {
        this.totalProcessTime = totalProcessTime;
    }

    public String getProcessTaskName() {
        return processTaskName;
    }

    public void setProcessTaskName(String processTaskName) {
        this.processTaskName = processTaskName;
    }

    public String getFailureInfo() {
        return failureInfo;
    }

    public void setFailureInfo(String failureInfo) {
        this.failureInfo = failureInfo;
    }

    public S15Data() {
    }

    public S15Data(int sysStatus, double length, double rotateLength, long completeTasks, long dailyDrillNum, long totalDrillNum, String startupTime, String processTime, String totalStartupTime, String totalProcessTime, String processTaskName, String failureInfo) {
        this.sysStatus = sysStatus;
        this.length = length;
        this.rotateLength = rotateLength;
        this.completeTasks = completeTasks;
        this.dailyDrillNum = dailyDrillNum;
        this.totalDrillNum = totalDrillNum;
        this.startupTime = startupTime;
        this.processTime = processTime;
        this.totalStartupTime = totalStartupTime;
        this.totalProcessTime = totalProcessTime;
        this.processTaskName = processTaskName;
        this.failureInfo = failureInfo;
    }
}
