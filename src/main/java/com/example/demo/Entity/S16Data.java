package com.example.demo.Entity;

import java.util.List;

public class S16Data {
    private int cumulateRunTime;//累计运行时间
    private String systemStartDate;//系统启动日期
    private String systemStartTime;//系统启动时间
    private String systemPreCloseDate;//系统上次关闭日期
    private String systemPreCloseTime;//系统上次关闭时间
    private String systemLastCloseDate;//系统末次关闭日期
    private String systemLastCloseTime;//系统末次关闭时间
    private String currentDate;//当日信息的日期
    private double dailyRunTime;//当日设备运行时间
    private double dailyStandbyTime;//当日设备待机时间
    private double dailyFailureTime;//当日设备故障时间
    private int currentStatus;//设备当前状态
    private String failureCode;//设备故障代码
    private String failureInfo;//设备故障信息
    private String alarmInfo;//机器人报警信息
    private String plasmaState;//等离子状态
    private String plasmaAlarmCode;//等离子报警代码
    private String plasmaAlarmTime;//等离子报警时间
    private int todayBaseMetalNum;//本日切割木材数
    private int todayPartNum;//本日零件切割数
    private String runningProgram;//当前执行程序名
    private int currentTaskNum;//当前执行任务总数
    private int currentRunTask;//当前执行任务号
    private String curentProgramSpec;//当前程序规格
    private int monthlyBaseMetalNum;//月切割母材数
    private int monthlyPartNum;//月切割零件数
    private int yearlyBaseMetalNum;//年切割母材数
    private int yearlyPartNum;//年切割零件数
    private String vulnerPartUpDate;//易损件更新日期
    private String vulnerPartUpTime;//易损件更新时间
    private int elecCuttingDis;//电极切割距离
    private int elecPerfTimes;//电极穿孔次数
    private int elecDailyUpdate;//电极当日更换数
    private int elecMonthlyUpdate;//电极本月更换数
    private int elecYearlyUpdate;//电极本年更换数
    private long heartBeat;//心跳信号
    private List<String> preStatus;//过去20次变化

    public long getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(long heartBeat) {
        this.heartBeat = heartBeat;
    }

    public List<String> getPreStatus() {
        return preStatus;
    }

    public String getVulnerPartUpDate() {
        return vulnerPartUpDate;
    }

    public void setVulnerPartUpDate(String vulnerPartUpDate) {
        this.vulnerPartUpDate = vulnerPartUpDate;
    }

    public void setPreStatus(List<String> preStatus) {
        this.preStatus = preStatus;
    }

    public int getCumulateRunTime() {
        return cumulateRunTime;
    }

    public void setCumulateRunTime(int cumulateRunTime) {
        this.cumulateRunTime = cumulateRunTime;
    }

    public String getSystemStartDate() {
        return systemStartDate;
    }

    public void setSystemStartDate(String systemStartDate) {
        this.systemStartDate = systemStartDate;
    }

    public String getSystemStartTime() {
        return systemStartTime;
    }

    public void setSystemStartTime(String systemStartTime) {
        this.systemStartTime = systemStartTime;
    }

    public String getSystemPreCloseDate() {
        return systemPreCloseDate;
    }

    public void setSystemPreCloseDate(String systemPreCloseDate) {
        this.systemPreCloseDate = systemPreCloseDate;
    }

    public String getSystemPreCloseTime() {
        return systemPreCloseTime;
    }

    public void setSystemPreCloseTime(String systemPreCloseTime) {
        this.systemPreCloseTime = systemPreCloseTime;
    }

    public String getSystemLastCloseDate() {
        return systemLastCloseDate;
    }

    public void setSystemLastCloseDate(String systemLastCloseDate) {
        this.systemLastCloseDate = systemLastCloseDate;
    }

    public String getSystemLastCloseTime() {
        return systemLastCloseTime;
    }

    public void setSystemLastCloseTime(String systemLastCloseTime) {
        this.systemLastCloseTime = systemLastCloseTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public double getDailyRunTime() {
        return dailyRunTime;
    }

    public void setDailyRunTime(double dailyRunTime) {
        this.dailyRunTime = dailyRunTime;
    }

    public double getDailyStandbyTime() {
        return dailyStandbyTime;
    }

    public void setDailyStandbyTime(double dailyStandbyTime) {
        this.dailyStandbyTime = dailyStandbyTime;
    }

    public double getDailyFailureTime() {
        return dailyFailureTime;
    }

    public void setDailyFailureTime(double dailyFailureTime) {
        this.dailyFailureTime = dailyFailureTime;
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureInfo() {
        return failureInfo;
    }

    public void setFailureInfo(String failureInfo) {
        this.failureInfo = failureInfo;
    }

    public String getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(String alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public String getPlasmaState() {
        return plasmaState;
    }

    public void setPlasmaState(String plasmaState) {
        this.plasmaState = plasmaState;
    }

    public String getPlasmaAlarmCode() {
        return plasmaAlarmCode;
    }

    public void setPlasmaAlarmCode(String plasmaAlarmCode) {
        this.plasmaAlarmCode = plasmaAlarmCode;
    }

    public String getPlasmaAlarmTime() {
        return plasmaAlarmTime;
    }

    public void setPlasmaAlarmTime(String plasmaAlarmTime) {
        this.plasmaAlarmTime = plasmaAlarmTime;
    }

    public int getTodayBaseMetalNum() {
        return todayBaseMetalNum;
    }

    public void setTodayBaseMetalNum(int todayBaseMetalNum) {
        this.todayBaseMetalNum = todayBaseMetalNum;
    }

    public int getTodayPartNum() {
        return todayPartNum;
    }

    public void setTodayPartNum(int todayPartNum) {
        this.todayPartNum = todayPartNum;
    }

    public String getRunningProgram() {
        return runningProgram;
    }

    public void setRunningProgram(String runningProgram) {
        this.runningProgram = runningProgram;
    }

    public int getCurrentTaskNum() {
        return currentTaskNum;
    }

    public void setCurrentTaskNum(int currentTaskNum) {
        this.currentTaskNum = currentTaskNum;
    }

    public int getCurrentRunTask() {
        return currentRunTask;
    }

    public void setCurrentRunTask(int currentRunTask) {
        this.currentRunTask = currentRunTask;
    }

    public String getCurentProgramSpec() {
        return curentProgramSpec;
    }

    public void setCurentProgramSpec(String curentProgramSpec) {
        this.curentProgramSpec = curentProgramSpec;
    }

    public int getMonthlyBaseMetalNum() {
        return monthlyBaseMetalNum;
    }

    public void setMonthlyBaseMetalNum(int monthlyBaseMetalNum) {
        this.monthlyBaseMetalNum = monthlyBaseMetalNum;
    }

    public int getMonthlyPartNum() {
        return monthlyPartNum;
    }

    public void setMonthlyPartNum(int monthlyPartNum) {
        this.monthlyPartNum = monthlyPartNum;
    }

    public int getYearlyBaseMetalNum() {
        return yearlyBaseMetalNum;
    }

    public void setYearlyBaseMetalNum(int yearlyBaseMetalNum) {
        this.yearlyBaseMetalNum = yearlyBaseMetalNum;
    }

    public int getYearlyPartNum() {
        return yearlyPartNum;
    }

    public void setYearlyPartNum(int yearlyPartNum) {
        this.yearlyPartNum = yearlyPartNum;
    }

    public String getVulnerPartUpTime() {
        return vulnerPartUpTime;
    }

    public void setVulnerPartUpTime(String vulnerPartUpTime) {
        this.vulnerPartUpTime = vulnerPartUpTime;
    }

    public int getElecCuttingDis() {
        return elecCuttingDis;
    }

    public void setElecCuttingDis(int elecCuttingDis) {
        this.elecCuttingDis = elecCuttingDis;
    }

    public int getElecPerfTimes() {
        return elecPerfTimes;
    }

    public void setElecPerfTimes(int elecPerfTimes) {
        this.elecPerfTimes = elecPerfTimes;
    }

    public int getElecDailyUpdate() {
        return elecDailyUpdate;
    }

    public void setElecDailyUpdate(int elecDailyUpdate) {
        this.elecDailyUpdate = elecDailyUpdate;
    }

    public int getElecMonthlyUpdate() {
        return elecMonthlyUpdate;
    }

    public void setElecMonthlyUpdate(int elecMonthlyUpdate) {
        this.elecMonthlyUpdate = elecMonthlyUpdate;
    }

    public int getElecYearlyUpdate() {
        return elecYearlyUpdate;
    }

    public void setElecYearlyUpdate(int elecYearlyUpdate) {
        this.elecYearlyUpdate = elecYearlyUpdate;
    }

    public S16Data() {
    }
}
