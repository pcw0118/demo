package com.example.demo.Entity;

import java.util.List;

public class S08Data {
    private Boolean commStatus;//通讯情况
    private Boolean isDeviceStart;//设备是否启动
    private Boolean isDeviceStop;//设备是否紧急停止
    private Boolean isDeviceWork;//设备是否工作
    private Boolean isDeviceFault;//设备是否故障
    private Integer runStatus;//设备运行状态
    private Long faultCode1;//错误代码1
    private Long faultCode2;//错误代码2
    private Long faultCode3;//错误代码3
    private Long faultCode4;//错误代码4
    private String deviceCode;//设备型号
    private Double webWidth;//腹板宽度
    private Double webThick;//腹板厚度
    private Double webLength;//腹板长度
    private Double flangWidth;//翼板宽度
    private Double flangThick;//翼板厚度
    private Double flangLength;//翼板长度
    private Double Output;//产量
    private Double tTakt;//理论节拍
    private Double realTakt;//实际节拍
    private Double eleEnergy;//累计电能消耗
    private Long startUpTime;//开机时间
    private Long processingTime;//加工时间
    private List<String> preStatus;//过去20次变化

    public List<String> getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(List<String> preStatus) {
        this.preStatus = preStatus;
    }

    public Long getStartUpTime() {
        return startUpTime;
    }

    public void setStartUpTime(Long startUpTime) {
        this.startUpTime = startUpTime;
    }

    public Long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Long processingTime) {
        this.processingTime = processingTime;
    }

    public Boolean getCommStatus() {
        return commStatus;
    }

    public void setCommStatus(Boolean commStatus) {
        this.commStatus = commStatus;
    }

    public Boolean getDeviceStart() {
        return isDeviceStart;
    }

    public void setDeviceStart(Boolean deviceStart) {
        isDeviceStart = deviceStart;
    }

    public Boolean getDeviceStop() {
        return isDeviceStop;
    }

    public void setDeviceStop(Boolean deviceStop) {
        isDeviceStop = deviceStop;
    }

    public Boolean getDeviceWork() {
        return isDeviceWork;
    }

    public void setDeviceWork(Boolean deviceWork) {
        isDeviceWork = deviceWork;
    }

    public Boolean getDeviceFault() {
        return isDeviceFault;
    }

    public void setDeviceFault(Boolean deviceFault) {
        isDeviceFault = deviceFault;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }

    public Long getFaultCode1() {
        return faultCode1;
    }

    public void setFaultCode1(Long faultCode1) {
        this.faultCode1 = faultCode1;
    }

    public Long getFaultCode2() {
        return faultCode2;
    }

    public void setFaultCode2(Long faultCode2) {
        this.faultCode2 = faultCode2;
    }

    public Long getFaultCode3() {
        return faultCode3;
    }

    public void setFaultCode3(Long faultCode3) {
        this.faultCode3 = faultCode3;
    }

    public Long getFaultCode4() {
        return faultCode4;
    }

    public void setFaultCode4(Long faultCode4) {
        this.faultCode4 = faultCode4;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Double getWebWidth() {
        return webWidth;
    }

    public void setWebWidth(Double webWidth) {
        this.webWidth = webWidth;
    }

    public Double getWebThick() {
        return webThick;
    }

    public void setWebThick(Double webThick) {
        this.webThick = webThick;
    }

    public Double getWebLength() {
        return webLength;
    }

    public void setWebLength(Double webLength) {
        this.webLength = webLength;
    }

    public Double getFlangWidth() {
        return flangWidth;
    }

    public void setFlangWidth(Double flangWidth) {
        this.flangWidth = flangWidth;
    }

    public Double getFlangThick() {
        return flangThick;
    }

    public void setFlangThick(Double flangThick) {
        this.flangThick = flangThick;
    }

    public Double getFlangLength() {
        return flangLength;
    }

    public void setFlangLength(Double flangLength) {
        this.flangLength = flangLength;
    }

    public Double getOutput() {
        return Output;
    }

    public void setOutput(Double output) {
        Output = output;
    }

    public Double gettTakt() {
        return tTakt;
    }

    public void settTakt(Double tTakt) {
        this.tTakt = tTakt;
    }

    public Double getRealTakt() {
        return realTakt;
    }

    public void setRealTakt(Double realTakt) {
        this.realTakt = realTakt;
    }

    public Double getEleEnergy() {
        return eleEnergy;
    }

    public void setEleEnergy(Double eleEnergy) {
        this.eleEnergy = eleEnergy;
    }

    public S08Data() {
    }
}
