package com.example.demo.Controller;

import com.example.demo.Entity.data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("/index")
public class baseController {
    //private String path="/home/xuos/socket/data";
    private String path="/home/xios/data";

    @GetMapping("/horizontalStraightStation")
    public String tohorizontalStraightStationOuterPage(HttpServletRequest request) {
        return "horizontalStraightStationOuter";
    }

    @GetMapping("/horizontalStraightStationInner")
    public String tohorizontalStraightStationInnerPage(HttpServletRequest request) {
        return "horizontalStraightStationInner";
    }

    @GetMapping("/steelDrillStation")
    public String toSteelDrillOuter(HttpServletRequest request) {
        return "steelDrillStationOuter";
    }

    @GetMapping("/steelDrillStationInner")
    public String toSteelDrillInner(HttpServletRequest request) {
        return "steelDrillStationInner";
    }

    @GetMapping("/shootPeenStation")
    public String toShootPeen(HttpServletRequest request) {
        return "shootPeenOuter";
    }

    @GetMapping("/shootPeenInner")
    public String toShootPeenInner(HttpServletRequest request) {
        return "shootPeenInner";
    }

    @GetMapping("/gasshieldedweldingInner")
    public String togasshieldedweldingInner(HttpServletRequest request) {
        return "gasshieldedweldingInner";
    }

    @GetMapping("/gasshieldedweldingStation")
    public String togasshieldedwelding(HttpServletRequest request) {
        return "gasshieldedweldingOuter";
    }

    @GetMapping("/gasshieldedweldingInner2")
    public String togasshieldedweldingInner2(HttpServletRequest request) {
        return "gasshieldedweldingInner2";
    }

    @GetMapping("/arcweldingStation")
    public String toArcwelding(HttpServletRequest request) {  return "arcweldingOuter"; }

    @GetMapping("/arcweldingInner")
    public String toArcweldingInner(HttpServletRequest request) { return "arcweldingInner"; }

    @GetMapping("/arcweldingInner2")
    public String toArcweldingInner2(HttpServletRequest request) { return "arcweldingInner2"; }

    @GetMapping("/cacheInner")
    public String toCacheInner(HttpServletRequest request) { return "cacheInner"; }


    @GetMapping("/turnovestation")
    public String toturnovestationOuterPage(HttpServletRequest request) {return "turnovestationOuter";}

    @GetMapping("/turnovestationInner")
    public String toturnovestationInnerPage(HttpServletRequest request) {return "turnovestationInner";}

    @GetMapping("/turnovestationInner2")
    public String toturnovestationInner2Page(HttpServletRequest request) {return "turnovestationInner2";}


    @GetMapping("/loadingstationInner")
    public String toloadingstationInnerPage(HttpServletRequest request) {return "loadingstationInner";}


    @GetMapping("/assemblystation")
    public String toassemblystationOuterPage(HttpServletRequest request) {return "assemblystationOuter";}

    @GetMapping("/assemblystationInner")
    public String toassemblystationInnerPage(HttpServletRequest request) {return "assemblystationInner";}


    @GetMapping("/data")
    @ResponseBody
    public data toData(HttpServletRequest request) {
        data res=new data();
        String strArray[] = new String[10];
        try {
            FileInputStream fis = new FileInputStream(path);
            // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            line = br.readLine();
            strArray=line.split(" ");
        }catch(IOException e){
            e.printStackTrace();
        }
        res.setOutput(Double.parseDouble(strArray[0]));
        res.setTaktTime(Double.parseDouble(strArray[1]));
        res.setRateOfStartup(Double.parseDouble(strArray[2]));
        res.setRateOfUtilization(Double.parseDouble(strArray[3]));
        res.setCurrent(Double.parseDouble(strArray[4]));
        res.setVol(Double.parseDouble(strArray[5]));
        res.setUsefulPower(Double.parseDouble(strArray[6]));
        res.setCurrentElectricEnergy(Double.parseDouble(strArray[7]));
        res.setHeartbeat(Double.parseDouble(strArray[8]));
        res.setStatus(Double.parseDouble(strArray[9]));
        return res;
    }
}
