package com.example.demo.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.CurrentBridge;
import com.example.demo.Entity.S14Data;
import com.example.demo.Service.RedisService;
import com.example.demo.help.TimeSecondConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.help.Response;

@Controller
@RequestMapping("/apidata")
public class RealTimeDataController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/current_webdrill")
    @ResponseBody
    public Object toWebDrillData(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        CurrentBridge res=new CurrentBridge();
        String str=redisService.lindex("S15",0);
        JSONObject jsonOfState = new JSONObject();
        JSONObject jsonOfArtifact = new JSONObject();
        JSONObject jsonOfDrill = new JSONObject();
        JSONObject jsonOfElectricty = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();


        //System.out.println(str);
        String[] array = str.split("\\|");
        //state
        map.put("runState",array[0]);
        map.put("warnState",array[14]);
        map.put("communicaState","");
        map.put("workingDuration", array[7]);
        map.put("bootDuration",array[6]);
        jsonOfState.putAll(map);
        res.setState(jsonOfState);
        //Artifacts
        //String[] arti = array[10].split("\\\\")[2].split("x");
        map.clear();
        map.put("artifactsCode","");
        map.put("artifactsFWide",array[10]);
        map.put("artifactsYWide",array[11]);
        map.put("artifactsFThick",array[12]);
        map.put("artifactsYThick",array[13]);
        map.put("artifactsLong",array[1]);
        jsonOfArtifact.clear();
        jsonOfArtifact.putAll(map);
        res.setArtifacts(jsonOfArtifact);
        //Process
        map.clear();
        map.put("drillNum",array[4]);
        map.put("drillSum",array[5]);
        map.put("drillHeadR","");
        map.put("drillHeadNum","");
        map.put("drillHeadSum","");
        map.put("millR","");
        map.put("millLength","");
        map.put("millDept","");
        map.put("millNum","");
        map.put("millSum","");
        map.put("machineParam","");
        jsonOfDrill.clear();
        jsonOfDrill.putAll(map);
        res.setProcess(jsonOfDrill);
        //Consumption
        map.clear();
        map.put("electricity","");
        jsonOfElectricty.clear();
        jsonOfElectricty.putAll(map);
        res.setConsumption(jsonOfElectricty);


        return Response.successMsg(res,"OK");

    }


    @GetMapping("/current_bridge")
    @ResponseBody
    public Object toBridgeData(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        CurrentBridge res=new CurrentBridge();
        String str=redisService.lindex("S14",0);
        JSONObject jsonOfState = new JSONObject();
        JSONObject jsonOfArtifact = new JSONObject();
        JSONObject jsonOfDrill = new JSONObject();
        JSONObject jsonOfElectricty = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();


        //System.out.println(str);
        String[] array = str.split("\\|");
        //state
        map.put("runState",array[10]);
        map.put("warnState",array[12]);
        map.put("communicaState","");
        map.put("workingDuration", "");
        map.put("bootDuration",TimeSecondConverter.Second2Time(Long.parseLong(array[9])));
        jsonOfState.putAll(map);
        res.setState(jsonOfState);
        //Artifacts
        //String[] arti = array[10].split("\\\\")[2].split("x");
        map.clear();
        map.put("artifactsCode","");
        map.put("artifactsFWide",array[4]);
        map.put("artifactsYWide",array[5]);
        map.put("artifactsFThick",array[6]);
        map.put("artifactsYThick",array[7]);
        map.put("artifactsLong",array[8]);
        jsonOfArtifact.clear();
        jsonOfArtifact.putAll(map);
        res.setArtifacts(jsonOfArtifact);
        //Process
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0");
        map.clear();
        map.put("processingNum",array[4]);
        map.put("productCount",array[5]);
        map.put("processingBeat",array[2]);
        map.put("processingTime","");
        map.put("lastQualified","");
        map.put("machineParam","");
        jsonOfDrill.clear();
        jsonOfDrill.putAll(map);
        res.setProcess(jsonOfDrill);
        //Consumption
        map.clear();
        map.put("electricity","");
        jsonOfElectricty.clear();
        jsonOfElectricty.putAll(map);
        res.setConsumption(jsonOfElectricty);


        return Response.successMsg(res,"OK");

    }

    @GetMapping("/current_blast")
    @ResponseBody
    public Object toBlastData(HttpServletRequest request) {
        //long l=redisService.llen("S14");
        CurrentBridge res=new CurrentBridge();
        String str=redisService.lindex("S17",0);
        JSONObject jsonOfState = new JSONObject();
        JSONObject jsonOfArtifact = new JSONObject();
        JSONObject jsonOfDrill = new JSONObject();
        JSONObject jsonOfElectricty = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();


        //System.out.println(str);
        String[] array = str.split("\\|");
        //state
        map.put("runState",array[18]);
        map.put("warnState",array[20]);
        map.put("communicaState","");
        map.put("workingDuration", "");
        map.put("bootDuration",TimeSecondConverter.Second2Time(Long.parseLong(array[17])));
        jsonOfState.putAll(map);
        res.setState(jsonOfState);
        //Artifacts
        //String[] arti = array[10].split("\\\\")[2].split("x");
        map.clear();
        map.put("artifactsCode","");
        jsonOfArtifact.clear();
        jsonOfArtifact.putAll(map);
        res.setArtifacts(jsonOfArtifact);
        //Process
        map.clear();
        map.put("fanState","");
        map.put("separationsumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[2])));
        map.put("ascensionsumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[3])));
        map.put("transversesumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[4])));
        map.put("longitudinalsumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[5])));
        map.put("recyclesumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[6])));
        map.put("reversesumtime",TimeSecondConverter.Second2Time(Long.parseLong(array[7])));
        map.put("runsumtime","");
        map.put("blastState","");
        map.put("machineParam","");
        jsonOfDrill.clear();
        jsonOfDrill.putAll(map);
        res.setProcess(jsonOfDrill);
        //Consumption
        map.clear();
        map.put("electricity","");
        jsonOfElectricty.clear();
        jsonOfElectricty.putAll(map);
        res.setConsumption(jsonOfElectricty);


        return Response.successMsg(res,"OK");

    }
}
