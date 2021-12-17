package com.example.demo.Scheduled;

import com.example.demo.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.demo.help.Constant.*;

@EnableScheduling
@Component
@EnableAsync
public class scheduleWork {
    @Autowired
    private RedisService redisService;

    String timeFormat="yyyy-MM-dd HH:mm:ss";
    String parseTimeFormat = "yyyy-MM-dd HH:mm";
    SimpleDateFormat formatter=new SimpleDateFormat(timeFormat);
    SimpleDateFormat timeFormatter = new SimpleDateFormat(parseTimeFormat);

    private static Long S04StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S04ProcessingTime = 0L;//当日加工时间
    private static Long S04PreHeartBeat = 0L;
    private static Integer S04preStatus = -1;


    private static Long S05StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S05ProcessingTime = 0L;//当日加工时间
    private static Double S05weldGasPreDay = 0.0;//焊接气体
    private static Double S05weldGas = 0.0;//焊接气体
    private static Long S05PreHeartBeat = 0L;
    private static Integer S05preStatus = -1;

    private static Long S06StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S06ProcessingTime = 0L;//当日加工时间
    private static Long S06PreHeartBeat = 0L;
    private static Integer S06preStatus = -1;


    private static Long S07StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S07ProcessingTime = 0L;//当日加工时间
    private static Double S07weldGasPreDay = 0.0;//焊接气体
    private static Double S07weldWirePreDay = 0.0;//焊丝
    private static Double S07weldGas = 0.0;//焊接气体
    private static Double S07weldWire = 0.0;//焊丝
    private static Long S07PreHeartBeat = 0L;
    private static Integer S07preStatus = -1;

    private static Long S08StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S08ProcessingTime = 0L;//当日加工时间
    private static Long S08PreHeartBeat = 0L;
    private static Integer S08preStatus = -1;

    private static Long S09StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S09ProcessingTime = 0L;//当日加工时间
    private static Double S09weldGasPreDay = 0.0;//焊接气体
    private static Double S09weldWirePreDay = 0.0;//焊丝
    private static Double S09weldGas = 0.0;//焊接气体
    private static Double S09weldWire = 0.0;//焊丝
    private static Long S09PreHeartBeat = 0L;
    private static Integer S09preStatus = -1;

    private static Long S10StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S10ProcessingTime = 0L;//当日加工时间
    private static Double S10weldWirePreDay = 0.0;//焊丝
    private static Double S10weldWire = 0.0;//焊丝
    private static Long S10PreHeartBeat = 0L;
    private static Integer S10preStatus = -1;

    private static Long S11StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S11ProcessingTime = 0L;//当日加工时间
    private static Long S11PreHeartBeat = 0L;
    private static Integer S11preStatus = -1;

    private static Long S12StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S12ProcessingTime = 0L;//当日加工时间
    private static Double S12weldWirePreDay = 0.0;//焊丝
    private static Double S12weldWire = 0.0;//焊丝
    private static Long S12PreHeartBeat = 0L;
    private static Integer S12preStatus = -1;

    private static Long S13StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S13ProcessingTime = 0L;//当日加工时间
    private static Long S13PreHeartBeat = 0L;
    private static Integer S13preStatus = -1;

    private static Integer S14preStatus = -1;

    private static Long S15HeartBeat = 0L;
    private static Long S15PreHeartBeat = 0L;
    private static Integer S15preStatus = -1;

    private static Long S16HeartBeat = 0L;
    private static Integer S16preStatus = -1;
    Date dateStart,dateLastCLose;

    private static Long S17HeartBeat = 0L;
    private static Long S17PreHeartBeat = 0L;
    private static Integer S17preStatus = -1;

    private static String S18PrePrimerSprayStatus = "";
    private static String S18PreTopcoatSprayStatus = "";
    private static String S18PrePrimerDryStatus = "";
    private static String S18PreTopcoatDryStatus = "";
    private static Integer S18PrePrimerSprayProcessingTimes = 0;
    private static Integer S18PrePrimerDryProcessingTimes = 0;
    private static Integer S18PreTopcoatSprayProcessingTimes = 0;
    private static Integer S18PreTopcoatDryProcessingTimes = 0;
    private static Double S18PrimerSprayTotalTakt = 0.0;
    private static Double S18TopcoatSprayTotalTakt = 0.0;
    private static Double S18PrimerDryTotalTakt = 0.0;
    private static Double S18TopcoatDryTotalTakt = 0.0;



    @Scheduled(cron = "0 0 0 * * ?")//每晚12点
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void dailyDataReset(){//清零任务
        // System.out.println("S15");
        //S04-----------------------------------------------
        String str=redisService.lindex("S04",0);
        //System.out.println(str);
        String[] array = str.split("\\|");
        S04StartUpTime = 0L;
        S04ProcessingTime = 0L;
        //--------------------------------------------------
        //S05---------------------------------------------------
        str=redisService.lindex("S05",0);
        //System.out.println(str);
        array = str.split("\\|");
        S05StartUpTime = 0L;
        S05ProcessingTime = 0L;
        S05weldGasPreDay = Double.parseDouble(array[21]);
        long len = redisService.llen("S05HourGasData");
        while((len--)>0){
            redisService.rpop("S05HourGasData");
        }
        //------------------------------------------------------
        //S06-----------------------------------------------
        str=redisService.lindex("S06",0);
        //System.out.println(str);
        array = str.split("\\|");
        S06StartUpTime = 0L;
        S06ProcessingTime = 0L;
        //--------------------------------------------------
        //S08-----------------------------------------------
        str=redisService.lindex("S08",0);
        //System.out.println(str);
        array = str.split("\\|");
        S08StartUpTime = 0L;
        S08ProcessingTime = 0L;
        //--------------------------------------------------
        //S07-----------------------------------------------
        str=redisService.lindex("S07",0);
        //System.out.println(str);
        array = str.split("\\|");
        S07StartUpTime = 0L;
        S07ProcessingTime = 0L;
        S07weldGasPreDay = Double.parseDouble(array[21]);
        S07weldWirePreDay = Double.parseDouble(array[22]);
        len = redisService.llen("S07HourWireData");
        while((len--)>0){
            redisService.rpop("S07HourWireData");
        }
        len = redisService.llen("S07HourGasData");
        while((len--)>0){
            redisService.rpop("S07HourGasData");
        }
        //--------------------------------------------------------
        //S09----------------------------------------------------
        str=redisService.lindex("S09",0);
        //System.out.println(str);
        array = str.split("\\|");
        S09StartUpTime = 0L;
        S09ProcessingTime = 0L;
        S09weldGasPreDay = Double.parseDouble(array[21]);
        S09weldWirePreDay = Double.parseDouble(array[22]);
        len = redisService.llen("S09HourWireData");
        while((len--)>0){
            redisService.rpop("S09HourWireData");
        }
        len = redisService.llen("S09HourGasData");
        while((len--)>0){
            redisService.rpop("S09HourGasData");
        }
        //------------------------------------------------------
        //S10---------------------------------------------------
        str=redisService.lindex("S10",0);
        //System.out.println(str);
        array = str.split("\\|");
        S10StartUpTime = 0L;
        S10ProcessingTime = 0L;
        S10weldWirePreDay = Double.parseDouble(array[21]);
        len = redisService.llen("S10HourWireData");
        while((len--)>0){
            redisService.rpop("S10HourWireData");
        }
        //------------------------------------------------------
        //S11-----------------------------------------------
        str=redisService.lindex("S11",0);
        //System.out.println(str);
        array = str.split("\\|");
        S11StartUpTime = 0L;
        S11ProcessingTime = 0L;
        //--------------------------------------------------
        //S12---------------------------------------------------
        str=redisService.lindex("S12",0);
        //System.out.println(str);
        array = str.split("\\|");
        S12StartUpTime = 0L;
        S12ProcessingTime = 0L;
        S12weldWirePreDay = Double.parseDouble(array[21]);
        len = redisService.llen("S12HourWireData");
        while((len--)>0){
            redisService.rpop("S12HourWireData");
        }
        //------------------------------------------------------
        //S13-----------------------------------------------
        str=redisService.lindex("S13",0);
        //System.out.println(str);
        array = str.split("\\|");
        S13StartUpTime = 0L;
        S13ProcessingTime = 0L;
        //--------------------------------------------------
    }

    @Scheduled(cron = "0 0 */1 * * ?")//每小时
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void hourlyDataSet(){//
        //S05------------------------------------------------------------------
        String str=redisService.lindex("S05",0);
        String[] array = str.split("\\|");
        S05weldGas = Double.parseDouble(array[21]) - S05weldGasPreDay;
        redisService.rpush("S05HourGasData",S05weldGas.toString());
        //---------------------------------------------------------------------
        //S07-------------------------------------------------------------
        str=redisService.lindex("S07",0);
        array = str.split("\\|");
        //S07StartUpTime = 0L;
        //S07ProcessingTime = 0L;
        //weldGasPreDay = Double.parseDouble(array[21]);
        //weldWirePreDay = Double.parseDouble(array[22]);
        S07weldGas = Double.parseDouble(array[21]) - S07weldGasPreDay;
        S07weldWire = Double.parseDouble(array[22]) - S07weldWirePreDay;
        redisService.rpush("S07HourWireData",S07weldWire.toString());
        redisService.rpush("S07HourGasData",S07weldGas.toString());
        //-----------------------------------------------------------------
        //S09--------------------------------------------------------------
        str=redisService.lindex("S09",0);
        array = str.split("\\|");
        S09weldGas = Double.parseDouble(array[21]) - S09weldGasPreDay;
        S09weldWire = Double.parseDouble(array[22]) - S09weldWirePreDay;
        redisService.rpush("S09HourWireData",S09weldWire.toString());
        redisService.rpush("S09HourGasData",S09weldGas.toString());
        //-------------------------------------------------------------------
        //S10----------------------------------------------------------------
        str=redisService.lindex("S10",0);
        array = str.split("\\|");
        S10weldWire = Double.parseDouble(array[21]) - S10weldWirePreDay;
        redisService.rpush("S10HourWireData",S10weldWire.toString());
        //-------------------------------------------------------------------
        //S12------------------------------------------------------------------
        str=redisService.lindex("S12",0);
        array = str.split("\\|");
        S12weldWire = Double.parseDouble(array[21]) - S12weldWirePreDay;
        redisService.rpush("S12HourWireData",S12weldWire.toString());
        //---------------------------------------------------------------------
    }


    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS04Data(){
        String str=redisService.lindex("S04",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S04PreStatus");
        if(!S04preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S04PreStatus");
                len--;
            }

            redisService.lpush("S04PreStatus", array[5] + "|" + formatter.format(new Date()));
            S04preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S04StartUpTime = S04StartUpTime + 1;
            redisService.set("S04StartUpTime",S04StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S04ProcessingTime = S04ProcessingTime + 1;
            redisService.set("S04ProcessingTime",S04ProcessingTime.toString());
        }
    }


    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS05Data(){
        String str=redisService.lindex("S05",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S05PreStatus");
        if(!S05preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S05PreStatus");
                len--;
            }

            redisService.lpush("S05PreStatus", array[5] + "|" + formatter.format(new Date()));
            S05preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S05StartUpTime = S05StartUpTime + 1;
            redisService.set("S05StartUpTime",S05StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S05ProcessingTime = S05ProcessingTime + 1;
            redisService.set("S05ProcessingTime",S05ProcessingTime.toString());
        }
        S05weldGas = Double.parseDouble(array[21]) - S05weldGasPreDay;
        //System.out.println(weldWire);
        redisService.set("S05WeldGas",S05weldGas.toString());
    }


    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS06Data(){
        String str=redisService.lindex("S06",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S06PreStatus");
        if(!S06preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S06PreStatus");
                len--;
            }

            redisService.lpush("S06PreStatus", array[5] + "|" + formatter.format(new Date()));
            S06preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S06StartUpTime = S06StartUpTime + 1;
            redisService.set("S06StartUpTime",S06StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S06ProcessingTime = S06ProcessingTime + 1;
            redisService.set("S06ProcessingTime",S06ProcessingTime.toString());
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS07Data(){
        //System.out.println("S07");
        String str=redisService.lindex("S07",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S07PreStatus");
        if(!S07preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S07PreStatus");
                len--;
            }

            redisService.lpush("S07PreStatus", array[5] + "|" + formatter.format(new Date()));
            S07preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S07StartUpTime = S07StartUpTime + 1;
            redisService.set("S07StartUpTime",S07StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S07ProcessingTime = S07ProcessingTime + 1;
            redisService.set("S07ProcessingTime",S07ProcessingTime.toString());
        }
        S07weldGas = Double.parseDouble(array[21]) - S07weldGasPreDay;
        S07weldWire = Double.parseDouble(array[22]) - S07weldWirePreDay;
        redisService.set("S07WeldGas",S07weldGas.toString());
        //System.out.println(weldWire);
        redisService.set("S07WeldWire",S07weldWire.toString());
    }

    @Scheduled(cron = "*/1 * * * * ?")
    // @Async
    public void ComputeS08Data(){
        String str=redisService.lindex("S08",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S08PreStatus");
        if(!S08preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S08PreStatus");
                len--;
            }

            redisService.lpush("S08PreStatus", array[5] + "|" + formatter.format(new Date()));
            S08preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S08StartUpTime = S08StartUpTime + 1;
            redisService.set("S08StartUpTime",S08StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S08ProcessingTime = S08ProcessingTime + 1;
            redisService.set("S08ProcessingTime",S08ProcessingTime.toString());
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS09Data(){
        //System.out.println("S07");
        String str=redisService.lindex("S09",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S09PreStatus");
        if(!S09preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S09PreStatus");
                len--;
            }

            redisService.lpush("S09PreStatus", array[5] + "|" + formatter.format(new Date()));
            S09preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S09StartUpTime = S09StartUpTime + 1;
            redisService.set("S09StartUpTime",S09StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S09ProcessingTime = S09ProcessingTime + 1;
            redisService.set("S09ProcessingTime",S09ProcessingTime.toString());
        }
        S09weldGas = Double.parseDouble(array[21]) - S09weldGasPreDay;
        S09weldWire = Double.parseDouble(array[22]) - S09weldWirePreDay;
        redisService.set("S09WeldGas",S09weldGas.toString());
        //System.out.println(weldWire);
        redisService.set("S09WeldWire",S09weldWire.toString());
    }

    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS10Data(){
        //System.out.println("S07");
        String str=redisService.lindex("S10",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S10PreStatus");
        if(!S10preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S10PreStatus");
                len--;
            }

            redisService.lpush("S10PreStatus", array[5] + "|" + formatter.format(new Date()));
            S10preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S10StartUpTime = S10StartUpTime + 1;
            redisService.set("S10StartUpTime",S10StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S10ProcessingTime = S10ProcessingTime + 1;
            redisService.set("S10ProcessingTime",S10ProcessingTime.toString());
        }
        S10weldWire = Double.parseDouble(array[21]) - S10weldWirePreDay;
        //System.out.println(weldWire);
        redisService.set("S10WeldWire",S10weldWire.toString());
    }


    @Scheduled(cron = "*/1 * * * * ?")
    // @Async
    public void ComputeS11Data(){
        String str=redisService.lindex("S11",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S11PreStatus");
        if(!S11preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S11PreStatus");
                len--;
            }

            redisService.lpush("S11PreStatus", array[5] + "|" + formatter.format(new Date()));
            S11preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S11StartUpTime = S11StartUpTime + 1;
            redisService.set("S11StartUpTime",S11StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S11ProcessingTime = S11ProcessingTime + 1;
            redisService.set("S11ProcessingTime",S11ProcessingTime.toString());
        }
    }



    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS12Data(){
        //System.out.println("S07");
        String str=redisService.lindex("S12",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S12PreStatus");
        if(!S12preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S12PreStatus");
                len--;
            }

            redisService.lpush("S12PreStatus", array[5] + "|" + formatter.format(new Date()));
            S12preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S12StartUpTime = S12StartUpTime + 1;
            redisService.set("S12StartUpTime",S12StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S12ProcessingTime = S12ProcessingTime + 1;
            redisService.set("S12ProcessingTime",S12ProcessingTime.toString());
        }
        S12weldWire = Double.parseDouble(array[21]) - S12weldWirePreDay;
        //System.out.println(weldWire);
        redisService.set("S12WeldWire",S12weldWire.toString());
    }


    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS13Data(){
        String str=redisService.lindex("S13",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S13PreStatus");
        if(!S13preStatus.equals(Integer.parseInt(array[5]))) {
            while (len >= 20) {
                redisService.rpop("S13PreStatus");
                len--;
            }

            redisService.lpush("S13PreStatus", array[5] + "|" + formatter.format(new Date()));
            S13preStatus = Integer.parseInt(array[5]);
        }
        if("1".equals(array[0])){//开机中
            S13StartUpTime = S13StartUpTime + 1;
            redisService.set("S13StartUpTime",S13StartUpTime.toString());
        }
        if("1".equals(array[3])){//工作中
            S13ProcessingTime = S13ProcessingTime + 1;
            redisService.set("S13ProcessingTime",S13ProcessingTime.toString());
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
   // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS14Data(){
        // System.out.println("S15");
        String str=redisService.lindex("S14",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S14PreStatus");
        if(!S14preStatus.equals(Integer.parseInt(array[10]))) {
            while (len >= 20) {
                redisService.rpop("S14PreStatus");
                len--;
            }

            redisService.lpush("S14PreStatus", array[10] + "|" + formatter.format(new Date()));
            S14preStatus = Integer.parseInt(array[10]);
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    //@Async
    public void ComputeS15Data(){
       // System.out.println("S15");
        String str=redisService.lindex("S15",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        if("2".equals(array[0])){//计时开始,sysStatus==2
            S15HeartBeat = 0L;
        }else if("1".equals(array[0])){//计时结束,sysStatus==1
            S15PreHeartBeat=S15HeartBeat;
        }else{
            S15HeartBeat=S15HeartBeat+1;
        }

        redisService.set("S15HeartBeat",S15PreHeartBeat.toString());

        Long len = redisService.llen("S15PreStatus");
        if(!S15preStatus.equals(Integer.parseInt(array[0]))) {
            while (len >= 20) {
                redisService.rpop("S15PreStatus");
                len--;
            }

            redisService.lpush("S15PreStatus", array[0] + "|" + formatter.format(new Date()));
            S15preStatus = Integer.parseInt(array[0]);
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void ComputeS16Data(){
        String str=redisService.lindex("S16",0);
        String[] array = str.split("\\|");

        Long len = redisService.llen("S16PreStatus");
        if(!S16preStatus.equals(Integer.parseInt(array[11]))) {
            while (len >= 20) {
                redisService.rpop("S16PreStatus");
                len--;
            }

            redisService.lpush("S16PreStatus", array[11] + "|" + formatter.format(new Date()));
            S16preStatus = Integer.parseInt(array[11]);
        }
        try {
            if(!(array[1]==null||array[1].isEmpty())&&!(array[2]==null||array[2].isEmpty())) {
                dateStart = timeFormatter.parse(array[1] + " " + array[2]);
            }else{
                dateStart = new Date();
            }
            if(!(array[5]==null||array[5].isEmpty())&&!(array[6]==null||array[6].isEmpty()))
                dateLastCLose = timeFormatter.parse(array[5] + " " + array[6]);
            else{
                dateLastCLose = dateStart;
            }

            if(dateStart.compareTo(dateLastCLose)>=0){
                S16HeartBeat = 1L;
            }else{
                S16HeartBeat = 0L;
            }
            redisService.set("S16HeartBeat",S16HeartBeat.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    //@Async
    public void ComputeS17Data(){
        //System.out.println("S17");
        String str=redisService.lindex("S17",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        if("1".equals(array[18])){//计时开始,runStatus==1
            S17HeartBeat = 0L;
        }else if("0".equals(array[18])){//计时结束,runStatus==0
            S17PreHeartBeat=S17HeartBeat;
        }else{
            S17HeartBeat=S17HeartBeat+1;
        }

        redisService.set("S17HeartBeat",S17PreHeartBeat.toString());

        Long len = redisService.llen("S17PreStatus");//保存过去20次变化，用作展示
        if(!S17preStatus.equals(Integer.parseInt(array[18]))) {
            while (len >= 20) {
                redisService.rpop("S17PreStatus");
                len--;
            }

            redisService.lpush("S17PreStatus", array[18] + "|" + formatter.format(new Date()));
            S17preStatus = Integer.parseInt(array[18]);
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    //@Async
    public void ComputeS18Data(){
        //System.out.println("S18");
        String str=redisService.lindex("S18",0);
        //System.out.println(str);
        String[] array = str.split("\\|");

        String S18PrimerDryStatus = array[0].substring(2)+array[1]+array[2].substring(0,1);
        String S18TopcoatDryStatus = array[6].substring(2)+array[7]+array[8].substring(0,1);
        String S18PrimerSprayStatus = array[20].substring(0,5)+array[22]+array[23].substring(0,4);
        String S18TopcoatSprayStatus = array[30].substring(0,5)+array[31].substring(1)+array[32].substring(0,5);


        if(Double.valueOf(array[48]).intValue() == 0) {//刚开机时，所有的加工时长都重置为0
            S18PrimerSprayTotalTakt = 0.0;
            redisService.set("S18PrimerSprayUtilize",Double.valueOf("100.0").toString());
            S18PrePrimerSprayProcessingTimes = 0;
        }else if(Double.valueOf(array[52]).intValue() != S18PrePrimerSprayProcessingTimes){
            S18PrimerSprayTotalTakt += Double.valueOf(array[51]);
            redisService.set("S18PrimerSprayUtilize",Double.valueOf(S18PrimerSprayTotalTakt/Double.valueOf(array[48])).toString());
            S18PrePrimerSprayProcessingTimes = Double.valueOf(array[52]).intValue();
        }
        if(Double.valueOf(array[60]).intValue() == 0) {
            S18TopcoatSprayTotalTakt = 0.0;
            redisService.set("S18TopcoatSprayUtilize",Double.valueOf("100.0").toString());
            S18PreTopcoatSprayProcessingTimes = 0;
        }else if(Double.valueOf(array[64]).intValue() != S18PreTopcoatSprayProcessingTimes){
            S18TopcoatSprayTotalTakt += Double.valueOf(array[63]);
            redisService.set("S18TopcoatSprayUtilize",Double.valueOf(S18TopcoatSprayTotalTakt/Double.valueOf(array[60])).toString());
            S18PreTopcoatSprayProcessingTimes = Double.valueOf(array[64]).intValue();
        }
        if(Double.valueOf(array[54]).intValue() == 0) {
            S18PrimerDryTotalTakt = 0.0;
            redisService.set("S18PrimerDryUtilize",Double.valueOf("100.0").toString());
            S18PrePrimerDryProcessingTimes = 0;
        }else if(Double.valueOf(array[58]).intValue() != S18PrePrimerDryProcessingTimes){
            S18PrimerDryTotalTakt += Double.valueOf(array[57]);
            redisService.set("S18PrimerDryUtilize",Double.valueOf(S18PrimerDryTotalTakt/Double.valueOf(array[54])).toString());
            S18PrePrimerDryProcessingTimes = Double.valueOf(array[58]).intValue();
        }
        if(Double.valueOf(array[66]).intValue() == 0) {
            S18TopcoatDryTotalTakt = 0.0;
            redisService.set("S18TopcoatDryUtilize",Double.valueOf("100.0").toString());
            S18PreTopcoatDryProcessingTimes = 0;
        }else if(Double.valueOf(array[70]).intValue() != S18PreTopcoatDryProcessingTimes){
            S18TopcoatDryTotalTakt += Double.valueOf(array[69]);
            redisService.set("S18TopcoatDryUtilize",Double.valueOf(S18TopcoatDryTotalTakt/Double.valueOf(array[66])).toString());
            S18PreTopcoatDryProcessingTimes = Double.valueOf(array[70]).intValue();
        }

        int len;


        if(!S18PrePrimerDryStatus.equals(S18PrimerDryStatus)){
            redisService.ltrim("S18PrePrimerDryStatus",1,0);//清空
            len = S18PrimerDryStatus.length();
            for(int i = 0;i<len;i++){
                char c = S18PrimerDryStatus.charAt(i);
                if('1' == c){
                    redisService.lpush("S18PrePrimerDryStatus", PrimerDryStatus.get(i) + "|" + formatter.format(new Date()));
                }
            }
            S18PrePrimerDryStatus = S18PrimerDryStatus;
        }

        if(!S18PreTopcoatDryStatus.equals(S18TopcoatDryStatus)){
            redisService.ltrim("S18PreTopcoatDryStatus",1,0);//清空
            len = S18TopcoatDryStatus.length();
            for(int i = 0;i<len;i++){
                char c = S18TopcoatDryStatus.charAt(i);
                if('1' == c){
                    redisService.lpush("S18PreTopcoatDryStatus", TopcoatDryStatus.get(i) + "|" + formatter.format(new Date()));
                }
            }
            S18PreTopcoatDryStatus = S18TopcoatDryStatus;
        }

        if(!S18PrePrimerSprayStatus.equals(S18PrimerSprayStatus)){
            redisService.ltrim("S18PrePrimerSprayStatus",1,0);//清空
            len = S18PrimerSprayStatus.length();
            for(int i = 0;i<len;i++){
                char c = S18PrimerSprayStatus.charAt(i);
                if('1' == c){
                    redisService.lpush("S18PrePrimerSprayStatus", PrimerSprayStatus.get(i) + "|" + formatter.format(new Date()));
                }
            }
            S18PrePrimerSprayStatus = S18PrimerSprayStatus;
        }

        if(!S18PreTopcoatSprayStatus.equals(S18TopcoatSprayStatus)){
            redisService.ltrim("S18PreTopcoatSprayStatus",1,0);//清空
            len = S18TopcoatSprayStatus.length();
            for(int i = 0;i<len;i++){
                char c = S18TopcoatSprayStatus.charAt(i);
                if('1' == c){
                    redisService.lpush("S18PreTopcoatSprayStatus", TopcoatSprayStatus.get(i) + "|" + formatter.format(new Date()));
                }
            }
            S18PreTopcoatSprayStatus = S18TopcoatSprayStatus;
        }
    }


}
