package com.example.demo.help;

import org.omg.CORBA.TIMEOUT;

public class TimeSecondConverter {
    private TimeSecondConverter(){};

    public static String Second2Time(Long seconds){//seconds to HH:mm:ss
        String res = "";
        Long step = 3600L;
        if(seconds == 0) return "00:00:00";
        while(seconds != 0){
            Long val = new Double(Math.floor(seconds/step)).longValue();
            res += (val<10) ? "0"+val : val;
            seconds = seconds%step;
            step = step/60;
            if(seconds != 0){
                res = res+":";
            }
        }
        return res;
    }

    public static Long Time2Second(String time){//HH:mm:ss to seconds
        Long res = 0L;
        String[] array = time.split(":");
        Long step = 1L;
        int len = array.length;
        for(int i=len-1;i>=0;i--){
            res += step * Long.parseLong(array[i]);
            step *= 60;
        }
        return res;
    }



}
