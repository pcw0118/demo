package com.example.demo.Entity;

import java.util.List;

public class S18Data {
    private Integer primerDryFirstStatus;//0.0 本地模式 0.1 远程模式 0.2 设备准备就绪信号 0.3 急停指示 0.4 喷漆房总运行指示 0.5 烘干房总运行指示 0.6 烘干房照明指示 0.7 喷漆房照明指示
    private Integer primerDrySecondStatus;//1.0 喷漆房排风运行指示 1.1 喷漆房送风机1运行指示 1.2 喷漆房送风机2运行指示 1.3 烘干房循环风机运行指示 1.4 烘干房燃烧器大火运行指示 1.5 烘干房燃烧器小火运行指示 1.6 烘干房热风幕机1运行指示 1.7 烘干房热风幕机2运行指示
    private Integer primerDryThirdStatus;//2.0 烘干房废气强排运行指示 2.1 备用 2.2 备用 2.3 备用 2.4 备用 2.5 备用 2.6 备用 2.7 备用
    private Integer primerDryFirstAlarm;//3.0 喷漆房排风机故障报警 3.1 喷漆房送风机1故障报警 3.2 喷漆房送风机2故障报警 3.3 喷漆房压差报警 3.4 烘干房循环风机故障报警 3.5 烘干房燃烧器故障报警 3.6 烘干房风幕机1故障报警 3.7 烘干房风幕机2故障报警
    private Integer primerDrySecondAlarm;//4.0 烘干房气体报警 4.1 备用 4.2 备用 4.3 备用 4.4 备用 4.5 备用 4.6 备用 4.7 备用

    private Integer topcoatDryFirstStatus;//0.0 本地模式 0.1 远程模式 0.2 设备准备就绪信号 0.3 急停指示 0.4 喷漆房总运行指示 0.5 烘干房总运行指示 0.6 烘干房照明指示 0.7 喷漆房照明指示
    private Integer topcoatDrySecondStatus;//1.0 喷漆房排风运行指示 1.1 喷漆房送风机1运行指示 1.2 喷漆房送风机2运行指示 1.3 烘干房循环风机运行指示 1.4 烘干房燃烧器大火运行指示 1.5 烘干房燃烧器小火运行指示 1.6 烘干房热风幕机1运行指示 1.7 烘干房热风幕机2运行指示
    private Integer topcoatDryThirdStatus;//2.0 烘干房废气强排运行指示 2.1 备用 2.2 备用 2.3 备用 2.4 备用 2.5 备用 2.6 备用 2.7 备用
    private Integer topcoatDryFirstAlarm;//3.0 喷漆房排风机故障报警 3.1 喷漆房送风机1故障报警 3.2 喷漆房送风机2故障报警 3.3 喷漆房压差报警 3.4 烘干房循环风机故障报警 3.5 烘干房燃烧器故障报警 3.6 烘干房风幕机1故障报警 3.7 烘干房风幕机2故障报警
    private Integer topcoatDrySecondAlarm;//4.0 烘干房气体报警 4.1 备用 4.2 备用 4.3 备用 4.4 备用 4.5 备用 4.6 备用 4.7 备用

    private Double primerDryTemperature1;//烘干房温度值1
    private Double primerDryTemperature2;//烘干房温度值2
    private Double primerDrySetTemperature;//烘干房温度设定值
    private Double primerDrySetAlarmTemperature;//烘干房温度报警设定值

    private Double topcoatDryTemperature1;//烘干房温度值1
    private Double topcoatDryTemperature2;//烘干房温度值2
    private Double topcoatDrySetTemperature;//烘干房温度设定值
    private Double topcoatDrySetAlarmTemperature;//烘干房温度报警设定值

    private Integer primerSprayFirstStatus;//44.0 主控柜手动模式 44.1 主控柜半自动模式 44.2 主控柜自动模式 44.3 运行指示 44.4 主控柜急停 44.5 1#链条电机运行 44.6 2#链条电机运行 44.7 3#链条电机运行
    private Integer primerSpraySecondStatus;//45.0 4#链条电机运行 45.1 1#横移电机运行 45.2 2#横移电机运行 45.3 3#横移电机运行 45.4 左升降伺服运行 45.5 左横移伺服运行 45.6 右升降伺服运行 45.7 右横移伺服运行
    private Integer primerSprayThirdStatus;//46.0 1#喷枪状态 46.1 2#喷枪状态 46.2 3#喷枪状态 46.3 4#喷枪状态 46.4 5#喷枪状态 46.5 6#喷枪状态 46.6 7#喷枪状态 46.7 8#喷枪状态
    private Integer primerSprayFourthStatus;//47.0 9#喷枪状态 47.1 10#喷枪状态 47.2 11#喷枪状态 47.3 12#喷枪状态 47.4 1#链条电机故障 47.5 2#链条电机故障 47.6 3#链条电机故障 47.7 4#链条电机故障
    private Integer primerSprayFifthStatus;//48.0 1#横移电机故障 48.1 2#横移电机故障 48.2 3#横移电机故障 48.3 左升降伺服故障 48.4 左横移伺服故障 48.5 右升降伺服故障 48.6 右横移伺服故障 48.7 横移车#1气缸开
    private Integer primerSpraySixthStatus;//49.0 横移车#2气缸开 49.1 横移车#3气缸开 49.2 横移车#4气缸开 49.3 横移车#5气缸开 49.4 横移车#6气缸开 49.5 横移车#7气缸开 49.6 横移车#8气缸开 49.7 横移车#1气缸报警
    private Integer primerSpraySeventhStatus;//50.0 横移车#2气缸报警 50.1 横移车#3气缸报警 50.2 横移车#4气缸报警 50.3 横移车#5气缸报警 50.4 横移车#6气缸报警 50.5 横移车#7气缸报警 50.6 横移车#8气缸报警 50.7 #1从柜手动模式
    private Integer primerSprayEighthStatus;//51.0 #1从柜半自动模式 51.1 #1从柜自动动模式 51.2 #1从柜急停 51.3 #2从柜手动模式 51.4 #2从柜半自动模式 51.5 #2从柜自动动模式 51.6 #2从柜急停 51.7 #3从柜手动模式
    private Integer primerSprayNinethStatus;//52.0 #3从柜半自动模式 52.1 #3从柜自动动模式 52.2 #3从柜急停 52.3 备用 52.4 备用 52.5 备用 52.6 备用 52.7 备用

    private Integer topcoatSprayFirstStatus;//54.0 主控柜手动模式 54.1 主控柜半自动模式 54.2 主控柜自动模式 54.3 运行指示 54.4 主控柜急停 54.5 左升降伺服运行 54.6 左横移伺服运行 54.7 右升降伺服运行
    private Integer topcoatSpraySecondStatus;//55.0 右横移伺服运行 55.1 1#喷枪状态 55.2 2#喷枪状态 55.3 3#喷枪状态 55.4 4#喷枪状态 55.5 5#喷枪状态 55.6 6#喷枪状态 55.7 7#喷枪状态
    private Integer topcoatSprayThirdStatus;//56.0 8#喷枪状态 56.1 9#喷枪状态 56.2 10#喷枪状态 56.3 11#喷枪状态 56.4 12#喷枪状态 56.5 左升降伺服故障 56.6 左横移伺服故障 56.7 右升降伺服故障
    private Integer topcoatSprayFourthStatus;//57.0 右横移伺服故障 57.1-7 备用

    private Double primerSprayChainSetFreq;//链条设定频率
    private Double primerSprayTraverseSetFreqHSpeed;//横移车设定频率-高速
    private Double primerSprayTraverseSetFreqLSpeed;//横移车设定频率-低速
    private Double primerSprayAutoSetSpeedLiftShaft;//升降轴自动设定速度
    private Double primerSprayAutoSetSpeedTraverse;//横移轴自动设定速度
    private Double primerSprayManualSetSpeedLiftShaft;//升降轴手动设定速度
    private Double primerSprayManualSetSpeedTraverse;//横移轴手动设定速度

    private Double topcoatSprayAutoSetSpeedLiftShaft;//升降轴自动设定速度
    private Double topcoatSprayAutoSetSpeedTraverse;//横移轴自动设定速度
    private Double topcoatSprayManualSetSpeedLiftShaft;//升降轴手动设定速度
    private Double topcoatSprayManualSetSpeedTraverse;//横移轴手动设定速度

    private Double heartBeat;//设备心跳标志
    private Double length;//型材长度
    private Double height;//型材高度
    private Double primerSprayElec;//底漆喷涂电量数据
    private Double primerSprayStartupTime;//底漆喷涂设备开机时长数据
    private Double primerSprayMaintainTime;//底漆喷涂设备维护时间
    private Double primerSprayRemainTime;//底漆喷涂设备维护剩余时间
    private Double primerSprayTakt;//底漆喷涂设备加工节拍时间
    private Double primerSprayProcessTimes;//底漆喷涂设备加工次数
    private Double primerSprayUtilize;//利用率

    private Double primerDryElec;//底漆烘干电量数据
    private Double primerDryStartupTime;//底漆烘干设备开机时长数据
    private Double primerDryMaintainTime;//底漆烘干设备维护时间
    private Double primerDryRemainTime;//底漆烘干设备维护剩余时间
    private Double primerDryTakt;//底漆烘干设备加工节拍时间
    private Double primerDryProcessTimes;//底漆烘干设备加工次数
    private Double primerDryUtilize;//利用率

    private Double topcoatSprayElec;//面漆喷涂电量数据
    private Double topcoatSprayStartupTime;//面漆喷涂设备开机时长数据
    private Double topcoatSprayMaintainTime;//面漆喷涂设备维护时间
    private Double topcoatSprayRemainTime;//面漆喷涂设备维护剩余时间
    private Double topcoatSprayTakt;//面漆喷涂设备加工节拍时间

    public Double getPrimerSprayUtilize() {
        return primerSprayUtilize;
    }

    public void setPrimerSprayUtilize(Double primerSprayUtilize) {
        this.primerSprayUtilize = primerSprayUtilize;
    }

    public Double getPrimerDryUtilize() {
        return primerDryUtilize;
    }

    public void setPrimerDryUtilize(Double primerDryUtilize) {
        this.primerDryUtilize = primerDryUtilize;
    }

    public Double getTopcoatSprayUtilize() {
        return topcoatSprayUtilize;
    }

    public void setTopcoatSprayUtilize(Double topcoatSprayUtilize) {
        this.topcoatSprayUtilize = topcoatSprayUtilize;
    }

    public Double getTopcoatDryUtilize() {
        return topcoatDryUtilize;
    }

    public void setTopcoatDryUtilize(Double topcoatDryUtilize) {
        this.topcoatDryUtilize = topcoatDryUtilize;
    }

    private Double topcoatSprayProcessTimes;//面漆喷涂设备加工次数
    private Double topcoatSprayUtilize;//利用率

    private Double topcoatDryElec;//面漆烘干电量数据
    private Double topcoatDryStartupTime;//面漆烘干设备开机时长数据
    private Double topcoatDryMaintainTime;//面漆烘干设备维护时间
    private Double topcoatDryRemainTime;//面漆烘干设备维护剩余时间
    private Double topcoatDryTakt;//面漆烘干设备加工节拍时间
    private Double topcoatDryProcessTimes;//面漆烘干设备加工次数
    private Double topcoatDryUtilize;//利用率

    public List<String> getPrePrimerSprayStatus() {
        return prePrimerSprayStatus;
    }

    public void setPrePrimerSprayStatus(List<String> prePrimerSprayStatus) {
        this.prePrimerSprayStatus = prePrimerSprayStatus;
    }

    public List<String> getPreTopCoatSprayStatus() {
        return preTopCoatSprayStatus;
    }

    public void setPreTopCoatSprayStatus(List<String> preTopCoatSprayStatus) {
        this.preTopCoatSprayStatus = preTopCoatSprayStatus;
    }

    public List<String> getPrePrimerDryStatus() {
        return prePrimerDryStatus;
    }

    public void setPrePrimerDryStatus(List<String> prePrimerDryStatus) {
        this.prePrimerDryStatus = prePrimerDryStatus;
    }

    public List<String> getPreTopCoatDryStatus() {
        return preTopCoatDryStatus;
    }

    public void setPreTopCoatDryStatus(List<String> preTopCoatDryStatus) {
        this.preTopCoatDryStatus = preTopCoatDryStatus;
    }

    private List<String> prePrimerSprayStatus;//底漆喷涂过去20次变化
    private List<String> preTopCoatSprayStatus;//面漆喷涂过去20次变化
    private List<String> prePrimerDryStatus;//底漆烘干过去20次变化
    private List<String> preTopCoatDryStatus;//面漆烘干过去20次变化

    public Integer getPrimerDryFirstStatus() {
        return primerDryFirstStatus;
    }

    public void setPrimerDryFirstStatus(Integer primerDryFirstStatus) {
        this.primerDryFirstStatus = primerDryFirstStatus;
    }

    public Integer getPrimerDrySecondStatus() {
        return primerDrySecondStatus;
    }

    public void setPrimerDrySecondStatus(Integer primerDrySecondStatus) {
        this.primerDrySecondStatus = primerDrySecondStatus;
    }

    public Integer getPrimerDryThirdStatus() {
        return primerDryThirdStatus;
    }

    public void setPrimerDryThirdStatus(Integer primerDryThirdStatus) {
        this.primerDryThirdStatus = primerDryThirdStatus;
    }

    public Integer getPrimerDryFirstAlarm() {
        return primerDryFirstAlarm;
    }

    public void setPrimerDryFirstAlarm(Integer primerDryFirstAlarm) {
        this.primerDryFirstAlarm = primerDryFirstAlarm;
    }

    public Integer getPrimerDrySecondAlarm() {
        return primerDrySecondAlarm;
    }

    public void setPrimerDrySecondAlarm(Integer primerDrySecondAlarm) {
        this.primerDrySecondAlarm = primerDrySecondAlarm;
    }

    public Integer getTopcoatDryFirstStatus() {
        return topcoatDryFirstStatus;
    }

    public void setTopcoatDryFirstStatus(Integer topcoatDryFirstStatus) {
        this.topcoatDryFirstStatus = topcoatDryFirstStatus;
    }

    public Integer getTopcoatDrySecondStatus() {
        return topcoatDrySecondStatus;
    }

    public void setTopcoatDrySecondStatus(Integer topcoatDrySecondStatus) {
        this.topcoatDrySecondStatus = topcoatDrySecondStatus;
    }

    public Integer getTopcoatDryThirdStatus() {
        return topcoatDryThirdStatus;
    }

    public void setTopcoatDryThirdStatus(Integer topcoatDryThirdStatus) {
        this.topcoatDryThirdStatus = topcoatDryThirdStatus;
    }

    public Integer getTopcoatDryFirstAlarm() {
        return topcoatDryFirstAlarm;
    }

    public void setTopcoatDryFirstAlarm(Integer topcoatDryFirstAlarm) {
        this.topcoatDryFirstAlarm = topcoatDryFirstAlarm;
    }

    public Integer getTopcoatDrySecondAlarm() {
        return topcoatDrySecondAlarm;
    }

    public void setTopcoatDrySecondAlarm(Integer topcoatDrySecondAlarm) {
        this.topcoatDrySecondAlarm = topcoatDrySecondAlarm;
    }

    public Double getPrimerDryTemperature1() {
        return primerDryTemperature1;
    }

    public void setPrimerDryTemperature1(Double primerDryTemperature1) {
        this.primerDryTemperature1 = primerDryTemperature1;
    }

    public Double getPrimerDryTemperature2() {
        return primerDryTemperature2;
    }

    public void setPrimerDryTemperature2(Double primerDryTemperature2) {
        this.primerDryTemperature2 = primerDryTemperature2;
    }

    public Double getPrimerDrySetTemperature() {
        return primerDrySetTemperature;
    }

    public void setPrimerDrySetTemperature(Double primerDrySetTemperature) {
        this.primerDrySetTemperature = primerDrySetTemperature;
    }

    public Double getPrimerDrySetAlarmTemperature() {
        return primerDrySetAlarmTemperature;
    }

    public void setPrimerDrySetAlarmTemperature(Double primerDrySetAlarmTemperature) {
        this.primerDrySetAlarmTemperature = primerDrySetAlarmTemperature;
    }

    public Double getTopcoatDryTemperature1() {
        return topcoatDryTemperature1;
    }

    public void setTopcoatDryTemperature1(Double topcoatDryTemperature1) {
        this.topcoatDryTemperature1 = topcoatDryTemperature1;
    }

    public Double getTopcoatDryTemperature2() {
        return topcoatDryTemperature2;
    }

    public void setTopcoatDryTemperature2(Double topcoatDryTemperature2) {
        this.topcoatDryTemperature2 = topcoatDryTemperature2;
    }

    public Double getTopcoatDrySetTemperature() {
        return topcoatDrySetTemperature;
    }

    public void setTopcoatDrySetTemperature(Double topcoatDrySetTemperature) {
        this.topcoatDrySetTemperature = topcoatDrySetTemperature;
    }

    public Double getTopcoatDrySetAlarmTemperature() {
        return topcoatDrySetAlarmTemperature;
    }

    public void setTopcoatDrySetAlarmTemperature(Double topcoatDrySetAlarmTemperature) {
        this.topcoatDrySetAlarmTemperature = topcoatDrySetAlarmTemperature;
    }

    public Integer getPrimerSprayFirstStatus() {
        return primerSprayFirstStatus;
    }

    public void setPrimerSprayFirstStatus(Integer primerSprayFirstStatus) {
        this.primerSprayFirstStatus = primerSprayFirstStatus;
    }

    public Integer getPrimerSpraySecondStatus() {
        return primerSpraySecondStatus;
    }

    public void setPrimerSpraySecondStatus(Integer primerSpraySecondStatus) {
        this.primerSpraySecondStatus = primerSpraySecondStatus;
    }

    public Integer getPrimerSprayThirdStatus() {
        return primerSprayThirdStatus;
    }

    public void setPrimerSprayThirdStatus(Integer primerSprayThirdStatus) {
        this.primerSprayThirdStatus = primerSprayThirdStatus;
    }

    public Integer getPrimerSprayFourthStatus() {
        return primerSprayFourthStatus;
    }

    public void setPrimerSprayFourthStatus(Integer primerSprayFourthStatus) {
        this.primerSprayFourthStatus = primerSprayFourthStatus;
    }

    public Integer getPrimerSprayFifthStatus() {
        return primerSprayFifthStatus;
    }

    public void setPrimerSprayFifthStatus(Integer primerSprayFifthStatus) {
        this.primerSprayFifthStatus = primerSprayFifthStatus;
    }

    public Integer getPrimerSpraySixthStatus() {
        return primerSpraySixthStatus;
    }

    public void setPrimerSpraySixthStatus(Integer primerSpraySixthStatus) {
        this.primerSpraySixthStatus = primerSpraySixthStatus;
    }

    public Integer getPrimerSpraySeventhStatus() {
        return primerSpraySeventhStatus;
    }

    public void setPrimerSpraySeventhStatus(Integer primerSpraySeventhStatus) {
        this.primerSpraySeventhStatus = primerSpraySeventhStatus;
    }

    public Integer getPrimerSprayEighthStatus() {
        return primerSprayEighthStatus;
    }

    public void setPrimerSprayEighthStatus(Integer primerSprayEighthStatus) {
        this.primerSprayEighthStatus = primerSprayEighthStatus;
    }

    public Integer getPrimerSprayNinethStatus() {
        return primerSprayNinethStatus;
    }

    public void setPrimerSprayNinethStatus(Integer primerSprayNinethStatus) {
        this.primerSprayNinethStatus = primerSprayNinethStatus;
    }

    public Integer getTopcoatSprayFirstStatus() {
        return topcoatSprayFirstStatus;
    }

    public void setTopcoatSprayFirstStatus(Integer topcoatSprayFirstStatus) {
        this.topcoatSprayFirstStatus = topcoatSprayFirstStatus;
    }

    public Integer getTopcoatSpraySecondStatus() {
        return topcoatSpraySecondStatus;
    }

    public void setTopcoatSpraySecondStatus(Integer topcoatSpraySecondStatus) {
        this.topcoatSpraySecondStatus = topcoatSpraySecondStatus;
    }

    public Integer getTopcoatSprayThirdStatus() {
        return topcoatSprayThirdStatus;
    }

    public void setTopcoatSprayThirdStatus(Integer topcoatSprayThirdStatus) {
        this.topcoatSprayThirdStatus = topcoatSprayThirdStatus;
    }

    public Integer getTopcoatSprayFourthStatus() {
        return topcoatSprayFourthStatus;
    }

    public void setTopcoatSprayFourthStatus(Integer topcoatSprayFourthStatus) {
        this.topcoatSprayFourthStatus = topcoatSprayFourthStatus;
    }

    public Double getPrimerSprayChainSetFreq() {
        return primerSprayChainSetFreq;
    }

    public void setPrimerSprayChainSetFreq(Double primerSprayChainSetFreq) {
        this.primerSprayChainSetFreq = primerSprayChainSetFreq;
    }

    public Double getPrimerSprayTraverseSetFreqHSpeed() {
        return primerSprayTraverseSetFreqHSpeed;
    }

    public void setPrimerSprayTraverseSetFreqHSpeed(Double primerSprayTraverseSetFreqHSpeed) {
        this.primerSprayTraverseSetFreqHSpeed = primerSprayTraverseSetFreqHSpeed;
    }

    public Double getPrimerSprayTraverseSetFreqLSpeed() {
        return primerSprayTraverseSetFreqLSpeed;
    }

    public void setPrimerSprayTraverseSetFreqLSpeed(Double primerSprayTraverseSetFreqLSpeed) {
        this.primerSprayTraverseSetFreqLSpeed = primerSprayTraverseSetFreqLSpeed;
    }

    public Double getPrimerSprayAutoSetSpeedLiftShaft() {
        return primerSprayAutoSetSpeedLiftShaft;
    }

    public void setPrimerSprayAutoSetSpeedLiftShaft(Double primerSprayAutoSetSpeedLiftShaft) {
        this.primerSprayAutoSetSpeedLiftShaft = primerSprayAutoSetSpeedLiftShaft;
    }

    public Double getPrimerSprayAutoSetSpeedTraverse() {
        return primerSprayAutoSetSpeedTraverse;
    }

    public void setPrimerSprayAutoSetSpeedTraverse(Double primerSprayAutoSetSpeedTraverse) {
        this.primerSprayAutoSetSpeedTraverse = primerSprayAutoSetSpeedTraverse;
    }

    public Double getPrimerSprayManualSetSpeedLiftShaft() {
        return primerSprayManualSetSpeedLiftShaft;
    }

    public void setPrimerSprayManualSetSpeedLiftShaft(Double primerSprayManualSetSpeedLiftShaft) {
        this.primerSprayManualSetSpeedLiftShaft = primerSprayManualSetSpeedLiftShaft;
    }

    public Double getPrimerSprayManualSetSpeedTraverse() {
        return primerSprayManualSetSpeedTraverse;
    }

    public void setPrimerSprayManualSetSpeedTraverse(Double primerSprayManualSetSpeedTraverse) {
        this.primerSprayManualSetSpeedTraverse = primerSprayManualSetSpeedTraverse;
    }

    public Double getTopcoatSprayAutoSetSpeedLiftShaft() {
        return topcoatSprayAutoSetSpeedLiftShaft;
    }

    public void setTopcoatSprayAutoSetSpeedLiftShaft(Double topcoatSprayAutoSetSpeedLiftShaft) {
        this.topcoatSprayAutoSetSpeedLiftShaft = topcoatSprayAutoSetSpeedLiftShaft;
    }

    public Double getTopcoatSprayAutoSetSpeedTraverse() {
        return topcoatSprayAutoSetSpeedTraverse;
    }

    public void setTopcoatSprayAutoSetSpeedTraverse(Double topcoatSprayAutoSetSpeedTraverse) {
        this.topcoatSprayAutoSetSpeedTraverse = topcoatSprayAutoSetSpeedTraverse;
    }

    public Double getTopcoatSprayManualSetSpeedLiftShaft() {
        return topcoatSprayManualSetSpeedLiftShaft;
    }

    public void setTopcoatSprayManualSetSpeedLiftShaft(Double topcoatSprayManualSetSpeedLiftShaft) {
        this.topcoatSprayManualSetSpeedLiftShaft = topcoatSprayManualSetSpeedLiftShaft;
    }

    public Double getTopcoatSprayManualSetSpeedTraverse() {
        return topcoatSprayManualSetSpeedTraverse;
    }

    public void setTopcoatSprayManualSetSpeedTraverse(Double topcoatSprayManualSetSpeedTraverse) {
        this.topcoatSprayManualSetSpeedTraverse = topcoatSprayManualSetSpeedTraverse;
    }

    public Double getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Double heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getPrimerSprayElec() {
        return primerSprayElec;
    }

    public void setPrimerSprayElec(Double primerSprayElec) {
        this.primerSprayElec = primerSprayElec;
    }

    public Double getPrimerSprayStartupTime() {
        return primerSprayStartupTime;
    }

    public void setPrimerSprayStartupTime(Double primerSprayStartupTime) {
        this.primerSprayStartupTime = primerSprayStartupTime;
    }

    public Double getPrimerSprayMaintainTime() {
        return primerSprayMaintainTime;
    }

    public void setPrimerSprayMaintainTime(Double primerSprayMaintainTime) {
        this.primerSprayMaintainTime = primerSprayMaintainTime;
    }

    public Double getPrimerSprayRemainTime() {
        return primerSprayRemainTime;
    }

    public void setPrimerSprayRemainTime(Double primerSprayRemainTime) {
        this.primerSprayRemainTime = primerSprayRemainTime;
    }

    public Double getPrimerSprayTakt() {
        return primerSprayTakt;
    }

    public void setPrimerSprayTakt(Double primerSprayTakt) {
        this.primerSprayTakt = primerSprayTakt;
    }

    public Double getPrimerSprayProcessTimes() {
        return primerSprayProcessTimes;
    }

    public void setPrimerSprayProcessTimes(Double primerSprayProcessTimes) {
        this.primerSprayProcessTimes = primerSprayProcessTimes;
    }

    public Double getPrimerDryElec() {
        return primerDryElec;
    }

    public void setPrimerDryElec(Double primerDryElec) {
        this.primerDryElec = primerDryElec;
    }

    public Double getPrimerDryStartupTime() {
        return primerDryStartupTime;
    }

    public void setPrimerDryStartupTime(Double primerDryStartupTime) {
        this.primerDryStartupTime = primerDryStartupTime;
    }

    public Double getPrimerDryMaintainTime() {
        return primerDryMaintainTime;
    }

    public void setPrimerDryMaintainTime(Double primerDryMaintainTime) {
        this.primerDryMaintainTime = primerDryMaintainTime;
    }

    public Double getPrimerDryRemainTime() {
        return primerDryRemainTime;
    }

    public void setPrimerDryRemainTime(Double primerDryRemainTime) {
        this.primerDryRemainTime = primerDryRemainTime;
    }

    public Double getPrimerDryTakt() {
        return primerDryTakt;
    }

    public void setPrimerDryTakt(Double primerDryTakt) {
        this.primerDryTakt = primerDryTakt;
    }

    public Double getPrimerDryProcessTimes() {
        return primerDryProcessTimes;
    }

    public void setPrimerDryProcessTimes(Double primerDryProcessTimes) {
        this.primerDryProcessTimes = primerDryProcessTimes;
    }

    public Double getTopcoatSprayElec() {
        return topcoatSprayElec;
    }

    public void setTopcoatSprayElec(Double topcoatSprayElec) {
        this.topcoatSprayElec = topcoatSprayElec;
    }

    public Double getTopcoatSprayStartupTime() {
        return topcoatSprayStartupTime;
    }

    public void setTopcoatSprayStartupTime(Double topcoatSprayStartupTime) {
        this.topcoatSprayStartupTime = topcoatSprayStartupTime;
    }

    public Double getTopcoatSprayMaintainTime() {
        return topcoatSprayMaintainTime;
    }

    public void setTopcoatSprayMaintainTime(Double topcoatSprayMaintainTime) {
        this.topcoatSprayMaintainTime = topcoatSprayMaintainTime;
    }

    public Double getTopcoatSprayRemainTime() {
        return topcoatSprayRemainTime;
    }

    public void setTopcoatSprayRemainTime(Double topcoatSprayRemainTime) {
        this.topcoatSprayRemainTime = topcoatSprayRemainTime;
    }

    public Double getTopcoatSprayTakt() {
        return topcoatSprayTakt;
    }

    public void setTopcoatSprayTakt(Double topcoatSprayTakt) {
        this.topcoatSprayTakt = topcoatSprayTakt;
    }

    public Double getTopcoatSprayProcessTimes() {
        return topcoatSprayProcessTimes;
    }

    public void setTopcoatSprayProcessTimes(Double topcoatSprayProcessTimes) {
        this.topcoatSprayProcessTimes = topcoatSprayProcessTimes;
    }

    public Double getTopcoatDryElec() {
        return topcoatDryElec;
    }

    public void setTopcoatDryElec(Double topcoatDryElec) {
        this.topcoatDryElec = topcoatDryElec;
    }

    public Double getTopcoatDryStartupTime() {
        return topcoatDryStartupTime;
    }

    public void setTopcoatDryStartupTime(Double topcoatDryStartupTime) {
        this.topcoatDryStartupTime = topcoatDryStartupTime;
    }

    public Double getTopcoatDryMaintainTime() {
        return topcoatDryMaintainTime;
    }

    public void setTopcoatDryMaintainTime(Double topcoatDryMaintainTime) {
        this.topcoatDryMaintainTime = topcoatDryMaintainTime;
    }

    public Double getTopcoatDryRemainTime() {
        return topcoatDryRemainTime;
    }

    public void setTopcoatDryRemainTime(Double topcoatDryRemainTime) {
        this.topcoatDryRemainTime = topcoatDryRemainTime;
    }

    public Double getTopcoatDryTakt() {
        return topcoatDryTakt;
    }

    public void setTopcoatDryTakt(Double topcoatDryTakt) {
        this.topcoatDryTakt = topcoatDryTakt;
    }

    public Double getTopcoatDryProcessTimes() {
        return topcoatDryProcessTimes;
    }

    public void setTopcoatDryProcessTimes(Double topcoatDryProcessTimes) {
        this.topcoatDryProcessTimes = topcoatDryProcessTimes;
    }

    public S18Data() {
    }
}