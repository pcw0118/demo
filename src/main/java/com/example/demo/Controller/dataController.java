package com.example.demo.Controller;

import com.example.demo.Entity.S07Data;
import com.example.demo.Entity.S14Data;
import com.example.demo.Entity.S15Data;
import com.example.demo.Entity.S17Data;
import com.example.demo.Service.RedisService;
import javafx.beans.binding.DoubleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/data")
public class dataController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/S14Data")
    @ResponseBody
    public S14Data toS14Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        S14Data res=new S14Data();
        String str=redisService.lindex("S14",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S14PreStatus",0,19);
        res.setPreStatus(ret);

        res.setActualBeat(Long.parseLong(array[2]));
        res.setWebWidth(Double.parseDouble(array[4]));
        res.setFlangeWidth(Double.parseDouble(array[5]));
        res.setWebThick(Double.parseDouble(array[6]));
        res.setFlangeThick(Double.parseDouble(array[7]));
        res.setLength(Double.parseDouble(array[8]));
        res.setStartTime(Long.parseLong(array[9]));
        res.setRuntimeStatus(Long.parseLong(array[10]));
        res.setProcessingTimes(Long.parseLong(array[11]));
        res.setAlarmStatus(Long.parseLong(array[12]));
        res.setMaintainTime(Long.parseLong(array[13]));
        res.setRemainDays(Long.parseLong(array[14]));
        res.setHeartBeat(Long.parseLong(array[15]));

        return res;

    }


    @GetMapping("/S15Data")
    @ResponseBody
    public S15Data toS15Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        S15Data res=new S15Data();
        String str=redisService.lindex("S15",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        String HeartBeat = redisService.get("S15HeartBeat");
        res.setHeartBeat(Long.parseLong(HeartBeat));

        List<String> ret = redisService.lrange("S15PreStatus",0,19);
        res.setPreStatus(ret);

        res.setSysStatus(Integer.parseInt(array[0]));
        res.setLength(Double.parseDouble(array[1]));
        res.setRotateLength(Double.parseDouble(array[2]));
        res.setCompleteTasks(Long.parseLong(array[3]));
        res.setDailyDrillNum(Long.parseLong(array[4]));
        res.setTotalDrillNum(Long.parseLong(array[5]));
        res.setStartupTime(array[6]);
        res.setProcessTime(array[7]);
        res.setTotalStartupTime(array[8]);
        res.setTotalProcessTime(array[9]);
        res.setWebWidth(Double.parseDouble(array[10]));
        res.setFlangeWidth(Double.parseDouble(array[11]));
        res.setWebThick(Double.parseDouble(array[12]));
        res.setFlangeThick(Double.parseDouble(array[13]));

        return res;

    }

    @GetMapping("/S17Data")
    @ResponseBody
    public S17Data toS17Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S17Data res=new S17Data();
        String str=redisService.lindex("S17",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        String HeartBeat = redisService.get("S17HeartBeat");
        res.setHeartBeat(Long.parseLong(HeartBeat));

        List<String> ret = redisService.lrange("S17PreStatus",0,19);
        res.setPreStatus(ret);

        res.setFan1TotalTime(Long.parseLong(array[0]));
        res.setFan2TotalTime(Long.parseLong(array[1]));
        res.setSeparateTotalTime(Long.parseLong(array[2]));
        res.setIncreaseTotalTime(Long.parseLong(array[3]));
        res.setTransverseTotalTime(Long.parseLong(array[4]));
        res.setVerticalTotalTime(Long.parseLong(array[5]));
        res.setRecoveryTotalTime(Long.parseLong(array[6]));
        res.setBlowback1TotalTime(Long.parseLong(array[7]));
        res.setBlowback2TotalTime(Long.parseLong(array[8]));
        res.setThrow1TotalTime(Long.parseLong(array[9]));
        res.setThrow2TotalTime(Long.parseLong(array[10]));
        res.setThrow3TotalTime(Long.parseLong(array[11]));
        res.setThrow4TotalTime(Long.parseLong(array[12]));
        res.setThrow5TotalTime(Long.parseLong(array[13]));
        res.setThrow6TotalTime(Long.parseLong(array[14]));
        res.setThrow7TotalTime(Long.parseLong(array[15]));
        res.setThrow8TotalTime(Long.parseLong(array[16]));
        res.setStartupTime(Long.parseLong(array[17]));
        res.setRunStatus(Long.parseLong(array[18]));
        res.setOutput(Long.parseLong(array[19]));
        res.setStatusAlarm(Long.parseLong(array[20]));
        res.setMaintenanceTime(Long.parseLong(array[21]));
        res.setMaintenanceRemainDay(Long.parseLong(array[22]));
        res.setHeartbeatFlag(Long.parseLong(array[23]));



        //System.out.println("S17 end");
        return res;

    }

    @GetMapping("/S07Data")
    @ResponseBody
    public S07Data toS07Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S07Data res=new S07Data();
        String str=redisService.lindex("S07",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S07HourWireData",0,23);
        res.setHourlyWireData(ret);

        ret = redisService.lrange("S07HourGasData",0,23);
        res.setHourlyGasData(ret);

        ret = redisService.lrange("S07PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S07StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S07ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

        String weldGas = redisService.get("S07WeldGas");
        res.setWeldGas(Double.parseDouble(weldGas));

        String weldWire = redisService.get("S07WeldWire");
        res.setWeldWire(Double.parseDouble(weldWire));

        res.setCommStatus(Boolean.parseBoolean((array[0]=="0"?"true":"false")));
        res.setDeviceStart(Boolean.parseBoolean((array[1]=="0"?"true":"false")));
        res.setDeviceStop(Boolean.parseBoolean((array[2]=="0"?"true":"false")));
        res.setDeviceWork(Boolean.parseBoolean((array[3]=="0"?"true":"false")));
        res.setDeviceFault(Boolean.parseBoolean((array[4]=="0"?"true":"false")));
        res.setRunStatus(Integer.parseInt(array[5]));
        res.setFaultCode1(Long.parseLong(array[6]));
        res.setFaultCode2(Long.parseLong(array[7]));
        res.setFaultCode3(Long.parseLong(array[8]));
        res.setFaultCode4(Long.parseLong(array[9]));
        res.setDeviceCode(array[10]);
        res.setWebWidth(Double.parseDouble(array[11]));
        res.setWebThick(Double.parseDouble(array[12]));
        res.setWebLength(Double.parseDouble(array[13]));
        res.setFlangWidth(Double.parseDouble(array[14]));
        res.setFlangThick(Double.parseDouble(array[15]));
        res.setFlangLength(Double.parseDouble(array[16]));
        res.setOutput(Double.parseDouble(array[17]));
        res.settTakt(Double.parseDouble(array[18]));
        res.setRealTakt(Double.parseDouble(array[19]));
        res.setEleEnergy(Double.parseDouble(array[20]));




        //System.out.println("S17 end");
        return res;

    }

}
