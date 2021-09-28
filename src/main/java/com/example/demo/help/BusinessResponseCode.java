package com.example.demo.help;

import lombok.Getter;

public enum BusinessResponseCode {

    SUCCESS(200, "OK！"),
    INTERNAL_ERROR(500, "本次请求发生异常，请稍后再试"),
    BAD_REQUEST(400, "参数错误！");

    @Getter
    private int code;

    @Getter
    private String tip;


    BusinessResponseCode(int i, String s) {
        this.code = i;
        this.tip = s;
    }

    //todo 不使用循环，将code转换为tip;
    public static String translate(int code) {
        return null;
    }
}
