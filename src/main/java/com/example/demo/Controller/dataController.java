package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.RedisService;
import javafx.beans.binding.DoubleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

@Controller
@RequestMapping("/data")
public class dataController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/demoData")
    @ResponseBody
    public List<DemoData> toDemoData(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        List<DemoData> res=new LinkedList<>();
        int i = 10;
        while(i-->=0){
            DemoData tmp = new DemoData();
            tmp.setId(i);
            tmp.setSex(1);
            tmp.setUsername("Bob");
            tmp.setCity("New York");
            res.add(tmp);
        }

        //System.out.println("S17 end");
        return res;

    }

    @GetMapping("/S04Data")
    @ResponseBody
    public S04Data toS04Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S04Data res=new S04Data();
        String str=redisService.lindex("S04",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S04PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S04StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S04ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

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


    @GetMapping("/S05Data")
    @ResponseBody
    public S05Data toS05Data(HttpServletRequest request) {
        S05Data res=new S05Data();
        String str=redisService.lindex("S05",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S05HourGasData",0,23);
        res.setHourlyGasData(ret);

        ret = redisService.lrange("S05PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S05StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S05ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

        String weldGas = redisService.get("S05WeldGas");
        res.setWeldGas(Double.parseDouble(weldGas));

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


    @GetMapping("/S06Data")
    @ResponseBody
    public S06Data toS06Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S06Data res=new S06Data();
        String str=redisService.lindex("S06",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S06PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S06StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S06ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

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


    @GetMapping("/S08Data")
    @ResponseBody
    public S08Data toS08Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S08Data res=new S08Data();
        String str=redisService.lindex("S08",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S08PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S08StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S08ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

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

    @GetMapping("/S09Data")
    @ResponseBody
    public S09Data toS09Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S09Data res=new S09Data();
        String str=redisService.lindex("S09",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S09HourWireData",0,23);
        res.setHourlyWireData(ret);

        ret = redisService.lrange("S09HourGasData",0,23);
        res.setHourlyGasData(ret);

        ret = redisService.lrange("S09PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S09StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S09ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

        String weldGas = redisService.get("S09WeldGas");
        res.setWeldGas(Double.parseDouble(weldGas));

        String weldWire = redisService.get("S09WeldWire");
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



    @GetMapping("/S10Data")
    @ResponseBody
    public S10Data toS10Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S10Data res=new S10Data();
        String str=redisService.lindex("S10",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S10HourWireData",0,23);
        res.setHourlyWireData(ret);

        ret = redisService.lrange("S10PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S10StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S10ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

        String weldWire = redisService.get("S10WeldWire");
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


    @GetMapping("/S11Data")
    @ResponseBody
    public S11Data toS11Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S11Data res=new S11Data();
        String str=redisService.lindex("S11",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S11PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S11StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S11ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

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

    @GetMapping("/S12Data")
    @ResponseBody
    public S12Data toS12Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S12Data res=new S12Data();
        String str=redisService.lindex("S12",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S12HourWireData",0,23);
        res.setHourlyWireData(ret);

        ret = redisService.lrange("S12PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S12StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S12ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

        String weldWire = redisService.get("S12WeldWire");
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


    @GetMapping("/S13Data")
    @ResponseBody
    public S13Data toS13Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        //System.out.println("S17 start");
        S13Data res=new S13Data();
        String str=redisService.lindex("S13",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        List<String> ret = redisService.lrange("S13PreStatus",0,19);
        res.setPreStatus(ret);

        String startTime = redisService.get("S13StartUpTime");
        res.setStartUpTime(Long.parseLong(startTime));

        String processingTime = redisService.get("S13ProcessingTime");
        res.setProcessingTime(Long.parseLong(processingTime));

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


    @GetMapping("/S16Data")
    @ResponseBody
    public S16Data toS16Data(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        S16Data res=new S16Data();
        String str=redisService.lindex("S16",0);
        //System.out.println(str);
        String[] array = str.split("\\|");


        String HeartBeat = redisService.get("S16HeartBeat");
        res.setHeartBeat(Long.parseLong(HeartBeat));


        List<String> ret = redisService.lrange("S16PreStatus",0,19);
        res.setPreStatus(ret);

        res.setCumulateRunTime(Integer.parseInt(array[0]));
        res.setSystemStartDate(array[1]);
        res.setSystemStartTime(array[2]);
        res.setSystemPreCloseDate(array[3]);
        res.setSystemPreCloseTime(array[4]);
        res.setSystemLastCloseDate(array[5]);
        res.setSystemLastCloseTime(array[6]);
        res.setCurrentDate(array[7]);
        res.setDailyRunTime(Double.parseDouble(array[8]));
        res.setDailyStandbyTime(Double.parseDouble(array[9]));
        res.setDailyFailureTime(Double.parseDouble(array[10]));
        res.setCurrentStatus(Integer.parseInt(array[11]));
        res.setFailureCode(array[12]);
        res.setFailureInfo(array[13]);
        res.setAlarmInfo(array[14]);
        res.setPlasmaState(array[15]);
        res.setPlasmaAlarmCode(array[16]);
        res.setPlasmaAlarmTime(array[17]);
        res.setTodayBaseMetalNum(Integer.parseInt(array[18]));
        res.setTodayPartNum(Integer.parseInt(array[19]));
        res.setRunningProgram(array[20]);
        res.setCurrentRunTask(Integer.parseInt(array[21]));
        res.setCurrentTaskNum(Integer.parseInt(array[22]));
        res.setCurentProgramSpec(array[23]);
        res.setMonthlyBaseMetalNum(Integer.parseInt(array[24]));
        res.setMonthlyPartNum(Integer.parseInt(array[25]));
        res.setYearlyBaseMetalNum(Integer.parseInt(array[26]));
        res.setYearlyPartNum(Integer.parseInt(array[27]));
        String[] array1 = array[28].split("_");
        res.setVulnerPartUpDate(array1[0]);
        res.setVulnerPartUpTime(array1[1]);
        res.setElecCuttingDis(Integer.parseInt(array[29]));
        res.setElecPerfTimes(Integer.parseInt(array[30]));
        res.setElecDailyUpdate(Integer.parseInt(array[31]));
        res.setElecMonthlyUpdate(Integer.parseInt(array[32]));
        res.setElecYearlyUpdate(Integer.parseInt(array[33]));


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

    @GetMapping("/S18Data")
    @ResponseBody
    public S18Data toS18Data(HttpServletRequest request) {
        S18Data res=new S18Data();
        String str=redisService.lindex("S18",0);
        String temp;
        //System.out.println(str);
        String[] array = str.split("\\|");

        //String HeartBeat = redisService.get("S18HeartBeat");
        //res.setHeartBeat(Long.parseLong(HeartBeat));

        List<String> ret = redisService.lrange("S18PrePrimerSprayStatus",0,19);//底漆喷涂
        res.setPrePrimerSprayStatus(ret);

        ret = redisService.lrange("S18PreTopcoatSprayStatus",0,19);//面漆喷涂
        res.setPreTopCoatSprayStatus(ret);

        ret = redisService.lrange("S18PrePrimerDryStatus",0,19);//底漆烘干
        res.setPrePrimerDryStatus(ret);

        ret = redisService.lrange("S18PreTopcoatDryStatus",0,19);//面漆烘干
        res.setPreTopCoatDryStatus(ret);

        temp = redisService.get("S18PrimerSprayUtilize");
        res.setPrimerSprayUtilize(Double.parseDouble(temp));

        temp = redisService.get("S18TopcoatSprayUtilize");
        res.setTopcoatSprayUtilize(Double.parseDouble(temp));

        temp = redisService.get("S18PrimerDryUtilize");
        res.setPrimerDryUtilize(Double.parseDouble(temp));

        temp = redisService.get("S18TopcoatDryUtilize");
        res.setTopcoatDryUtilize(Double.parseDouble(temp));
        //参照S18Data以及喷涂线redis内数据
        res.setPrimerDryFirstStatus(Integer.parseInt(array[0],2));
        res.setPrimerDrySecondStatus(Integer.parseInt(array[1],2));
        res.setPrimerDryThirdStatus(Integer.parseInt(array[2],2));
        res.setPrimerDryFirstAlarm(Integer.parseInt(array[3],2));
        res.setPrimerDrySecondAlarm(Integer.parseInt(array[4],2));

        res.setTopcoatDryFirstStatus(Integer.parseInt(array[6],2));
        res.setTopcoatDrySecondStatus(Integer.parseInt(array[7],2));
        res.setTopcoatDryThirdStatus(Integer.parseInt(array[8],2));
        res.setTopcoatDryFirstAlarm(Integer.parseInt(array[9],2));
        res.setTopcoatDrySecondAlarm(Integer.parseInt(array[10],2));

        res.setPrimerDryTemperature1(Double.parseDouble(array[12]));
        res.setPrimerDryTemperature2(Double.parseDouble(array[13]));
        res.setPrimerDrySetTemperature(Double.parseDouble(array[14]));
        res.setPrimerDrySetAlarmTemperature(Double.parseDouble(array[15]));

        res.setTopcoatDryTemperature1(Double.parseDouble(array[16]));
        res.setTopcoatDryTemperature2(Double.parseDouble(array[17]));
        res.setTopcoatDrySetTemperature(Double.parseDouble(array[18]));
        res.setTopcoatDrySetAlarmTemperature(Double.parseDouble(array[19]));

        res.setPrimerSprayFirstStatus(Integer.parseInt(array[20],2));
        res.setPrimerSpraySecondStatus(Integer.parseInt(array[21],2));
        res.setPrimerSprayThirdStatus(Integer.parseInt(array[22],2));
        res.setPrimerSprayFourthStatus(Integer.parseInt(array[23],2));
        res.setPrimerSprayFifthStatus(Integer.parseInt(array[24],2));
        res.setPrimerSpraySixthStatus(Integer.parseInt(array[25],2));
        res.setPrimerSpraySeventhStatus(Integer.parseInt(array[26],2));
        res.setPrimerSprayEighthStatus(Integer.parseInt(array[27],2));
        res.setPrimerSprayNinethStatus(Integer.parseInt(array[28],2));

        res.setTopcoatSprayFirstStatus(Integer.parseInt(array[30],2));
        res.setTopcoatSpraySecondStatus(Integer.parseInt(array[31],2));
        res.setTopcoatSprayThirdStatus(Integer.parseInt(array[32],2));
        res.setTopcoatSprayFourthStatus(Integer.parseInt(array[33],2));

        res.setPrimerSprayChainSetFreq(Double.parseDouble(array[34]));
        res.setPrimerSprayTraverseSetFreqHSpeed(Double.parseDouble(array[35]));
        res.setPrimerSprayTraverseSetFreqLSpeed(Double.parseDouble(array[36]));
        res.setPrimerSprayAutoSetSpeedLiftShaft(Double.parseDouble(array[37]));
        res.setPrimerSprayAutoSetSpeedTraverse(Double.parseDouble(array[38]));
        res.setPrimerSprayManualSetSpeedLiftShaft(Double.parseDouble(array[39]));
        res.setPrimerSprayManualSetSpeedTraverse(Double.parseDouble(array[40]));

        res.setTopcoatSprayAutoSetSpeedLiftShaft(Double.parseDouble(array[41]));
        res.setTopcoatSprayAutoSetSpeedTraverse(Double.parseDouble(array[42]));
        res.setTopcoatSprayManualSetSpeedLiftShaft(Double.parseDouble(array[43]));
        res.setTopcoatSprayManualSetSpeedTraverse(Double.parseDouble(array[44]));

        res.setLength(Double.parseDouble(array[45]));
        res.setHeight(Double.parseDouble(array[46]));
        res.setPrimerSprayElec(Double.parseDouble(array[47]));
        res.setPrimerSprayStartupTime(Double.parseDouble(array[48]));
        res.setPrimerSprayMaintainTime(Double.parseDouble(array[49]));
        res.setPrimerSprayRemainTime(Double.parseDouble(array[50]));
        res.setPrimerSprayTakt(Double.parseDouble(array[51]));
        res.setPrimerSprayProcessTimes(Double.parseDouble(array[52]));

        res.setPrimerDryElec(Double.parseDouble(array[53]));
        res.setPrimerDryStartupTime(Double.parseDouble(array[54]));
        res.setPrimerDryMaintainTime(Double.parseDouble(array[55]));
        res.setPrimerDryRemainTime(Double.parseDouble(array[56]));
        res.setPrimerDryTakt(Double.parseDouble(array[57]));
        res.setPrimerDryProcessTimes(Double.parseDouble(array[58]));

        res.setTopcoatSprayElec(Double.parseDouble(array[59]));
        res.setTopcoatSprayStartupTime(Double.parseDouble(array[60]));
        res.setTopcoatSprayMaintainTime(Double.parseDouble(array[61]));
        res.setTopcoatSprayRemainTime(Double.parseDouble(array[62]));
        res.setTopcoatSprayTakt(Double.parseDouble(array[63]));
        res.setTopcoatSprayProcessTimes(Double.parseDouble(array[64]));

        res.setTopcoatDryElec(Double.parseDouble(array[65]));
        res.setTopcoatDryStartupTime(Double.parseDouble(array[66]));
        res.setTopcoatDryMaintainTime(Double.parseDouble(array[67]));
        res.setTopcoatDryRemainTime(Double.parseDouble(array[68]));
        res.setTopcoatDryTakt(Double.parseDouble(array[69]));
        res.setTopcoatDryProcessTimes(Double.parseDouble(array[70]));


        return res;

    }



}
