package com.example.demo.help;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {

    private T data;

    private int code;

    private String message;

    private boolean success;


    public Response(T data) {
        this.data = data;
        this.code = BusinessResponseCode.SUCCESS.getCode();
        this.message = BusinessResponseCode.SUCCESS.getTip();
        this.success = true;
    }


    public void setData(T data) {
        this.data = data;
        this.code = BusinessResponseCode.SUCCESS.getCode();
        this.message = BusinessResponseCode.SUCCESS.getTip();
        this.success = true;
    }

    public static <T> Response<T> error(T data) {
        return restResult(data, BusinessResponseCode.INTERNAL_ERROR.getCode(), null, false);
    }

    public static Response error(String msg) {
        return restResult(null, BusinessResponseCode.INTERNAL_ERROR.getCode(), msg, false);
    }

    public static <T> Response<T> error(T data, String msg) {
        return restResult(data, BusinessResponseCode.INTERNAL_ERROR.getCode(), msg, false);
    }

    public static Response successMsg(String msg) {
        return restResult(null, BusinessResponseCode.SUCCESS.getCode(), msg, true);
    }

    public static <T> Response<T> successMsg(T data, String msg) {
        return restResult(data, BusinessResponseCode.SUCCESS.getCode(), msg, true);
    }

    private static <T> Response<T> restResult(T data, int code, String msg, boolean success) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setData(data);
        response.setMessage(msg);
        response.setSuccess(success);
        return response;
    }
}
