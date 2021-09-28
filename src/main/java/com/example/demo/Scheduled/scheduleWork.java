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

    private static Integer S14preStatus = -1;

    private static Long S15HeartBeat = 0L;
    private static Long S15PreHeartBeat = 0L;
    private static Integer S15preStatus = -1;

    private static Long S17HeartBeat = 0L;
    private static Long S17PreHeartBeat = 0L;
    private static Integer S17preStatus = -1;

    private static Long S07StartUpTime = 0L;//,当日开机时间，每天晚上12点清零
    private static Long S07ProcessingTime = 0L;//当日加工时间
    private static Double weldGasPreDay = 0.0;//焊接气体
    private static Double weldWirePreDay = 0.0;//焊丝
    private static Double weldGas = 0.0;//焊接气体
    private static Double weldWire = 0.0;//焊丝
    private static Long S07PreHeartBeat = 0L;
    private static Integer S07preStatus = -1;



    @Scheduled(cron = "0 0 0 * * ?")//每晚12点
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void dailyDataReset(){//清零任务
        // System.out.println("S15");
        String str=redisService.lindex("S07",0);
        //System.out.println(str);
        String[] array = str.split("\\|");
        S07StartUpTime = 0L;
        S07ProcessingTime = 0L;
        weldGasPreDay = Double.parseDouble(array[21]);
        weldWirePreDay = Double.parseDouble(array[22]);
        long len = redisService.llen("S07HourWireData");
        while((len--)>0){
            redisService.rpop("S07HourWireData");
        }
        len = redisService.llen("S07HourGasData");
        while((len--)>0){
            redisService.rpop("S07HourGasData");
        }
        redisService.rpush("S07HourWireData","0");
        redisService.rpush("S07HourGasData","0");
    }

    @Scheduled(cron = "0 0 */1 * * ?")//每小时
    // @Async                                  //异步执行需上述数据具有原子性，且若是所有函数能一秒内完成则无意义，暂定不需要异步执行。
    public void hourlyDataSet(){//
        // System.out.println("S15");
        String str=redisService.lindex("S07",0);
        //System.out.println(str);
        String[] array = str.split("\\|");
        //S07StartUpTime = 0L;
        //S07ProcessingTime = 0L;
        //weldGasPreDay = Double.parseDouble(array[21]);
        //weldWirePreDay = Double.parseDouble(array[22]);
        weldGas = Double.parseDouble(array[21]) - weldGasPreDay;
        weldWire = Double.parseDouble(array[22]) - weldWirePreDay;
        redisService.rpush("S07HourWireData",weldWire.toString());
        redisService.rpush("S07HourGasData",weldGas.toString());
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
        weldGas = Double.parseDouble(array[21]) - weldGasPreDay;
        weldWire = Double.parseDouble(array[22]) - weldWirePreDay;
        redisService.set("S07WeldGas",weldGas.toString());
        //System.out.println(weldWire);
        redisService.set("S07WeldWire",weldWire.toString());
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
