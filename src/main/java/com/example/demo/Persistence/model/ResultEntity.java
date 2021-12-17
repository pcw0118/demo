package com.example.demo.Persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class ResultEntity {
    private static final long serialVersionUID = -3078562261446050978L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String company;//公司名称
    private Date stime;//时间
    private String deviceCode;//设备型号
    private String floatNum;//浮点数据组
    private String intNum;//整型数据组
    private String boolNum;//布尔数据组

    public ResultEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getTime() {
        return stime;
    }

    public void setTime(Date stime) {
        this.stime = stime;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getFloatNum() {
        return floatNum;
    }

    public void setFloatNum(String floatNum) {
        this.floatNum = floatNum;
    }

    public String getIntNum() {
        return intNum;
    }

    public void setIntNum(String intNum) {
        this.intNum = intNum;
    }

    public String getBoolNum() {
        return boolNum;
    }

    public void setBoolNum(String boolNum) {
        this.boolNum = boolNum;
    }
}
