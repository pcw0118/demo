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

@EnableScheduling
@Component
@EnableAsync
public class scheduleWork {
    @Autowired
    private RedisService redisService;

    String timeFormat="yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat formatter=new SimpleDateFormat(timeFormat);

    private static Long S07StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S07ProcessingTime = 0L;//当日加工时间
    private static Double S07weldGasPreDay = 0.0;//焊接气体
    private static Double S07weldWirePreDay = 0.0;//焊丝
    private static Double S07weldGas = 0.0;//焊接气体
    private static Double S07weldWire = 0.0;//焊丝
    private static Long S07PreHeartBeat = 0L;
    private static Integer S07preStatus = -1;

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

    private static Long S12StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S12ProcessingTime = 0L;//当日加工时间
    private static Double S12weldWirePreDay = 0.0;//焊丝
    private static Double S12weldWire = 0.0;//焊丝
    private static Long S12PreHeartBeat = 0L;
    private static Integer S12preStatus = -1;

    private static Integer S14preStatus = -1;

    private static Long S15HeartBeat = 0L;
    private static Long S15PreHeartBeat = 0L;
    private static Integer S15preStatus = -1;

    private static Long S17HeartBeat = 0L;
    private static Long S17PreHeartBeat = 0L;
    private static Integer S17preStatus = -1;



    @Scheduled(cron = "0 0 0 * * ?")//每晚12点
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void dailyDataReset(){//清零任务
        // System.out.println("S15");
        //S07-----------------------------------------------
        String str=redisService.lindex("S07",0);
        //System.out.println(str);
        String[] array = str.split("\\|");
        S07StartUpTime = 0L;
        S07ProcessingTime = 0L;
        S07weldGasPreDay = Double.parseDouble(array[21]);
        S07weldWirePreDay = Double.parseDouble(array[22]);
        long len = redisService.llen("S07HourWireData");
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
    }

    @Scheduled(cron = "0 0 */1 * * ?")//每小时
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void hourlyDataSet(){//
        //S07-------------------------------------------------------------
        String str=redisService.lindex("S07",0);
        String[] array = str.split("\\|");
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

            redisService.lpush("S10sPreStatus", array[5] + "|" + formatter.format(new Date()));
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

            redisService.lpush("S12sPreStatus", array[5] + "|" + formatter.format(new Date()));
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


}
