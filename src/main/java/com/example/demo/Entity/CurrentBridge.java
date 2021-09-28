package com.example.demo.Entity;

import com.alibaba.fastjson.JSONObject;

public class CurrentBridge {
   /* private String id;//设备序号，id=1代表第一台上料设备
    private String runState;//设备运行状态
    private String warnState;//设备报警状态
    private String communicateState;//设备通讯状态
    private String workingDuration;//当前加工时长 hh:mm:ss格式
    private String bootDuration;//当前开机时长 hh:mm:ss格式
    private String artifactsCode;//当前构件编号
    private Long artifactsFWide;//构件腹板宽度 单位: mm
    private Long artifactsYWide;//构件翼板宽度      mm
    private Long artifactsFThick;//构件腹板厚度     mm
    private Long artifactsYThick;//构件翼板厚度     mm
    private Long artifactsLong;//构件型材长度       mm
    private Long drillNum;//当前钻孔数量       pcs
    private Long drillSum;//总钻孔数量          pcs
    private Long drillHeadR;//钻头半径数据      mm
    private Long drillHeadNum;//当前钻头钻孔数量  pcs
    private Long drillHeadSum;//钻头总钻孔数量   pcs
    private Long millR;//铣刀半径数据     mm
    private Long millLength;//铣刀铣孔长度     mm
    private Long millDept;//铣刀铣孔深度     mm
    private Long millNum;//当前铣刀铣孔数量    pcs
    private Long millSum;//铣刀总铣孔数量        pcs
    private String machineParam;//本次加工参数         没有则空
    private Long electricity;//当日累计耗电            kw·h*/

    private JSONObject State;
    private JSONObject Artifacts;
    private JSONObject Process;
    private JSONObject Consumption;

    public CurrentBridge() {
    }

    public JSONObject getState() {
        return State;
    }

    public void setState(JSONObject state) {
        State = state;
    }

    public JSONObject getArtifacts() {
        return Artifacts;
    }

    public void setArtifacts(JSONObject artifacts) {
        Artifacts = artifacts;
    }

    public JSONObject getProcess() {
        return Process;
    }

    public void setProcess(JSONObject process) {
        Process = process;
    }

    public JSONObject getConsumption() {
        return Consumption;
    }

    public void setConsumption(JSONObject consumption) {
        Consumption = consumption;
    }
}
