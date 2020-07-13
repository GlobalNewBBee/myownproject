package com.myown.game.constant;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonResponse {

    //返回的状态码
    private Integer code;
    //返回前端的消息
    private String message;
    //返回的数据
    private Object data;

    public CommonResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResponse() {
    }

    public void success(String message,Object data){
        this.code = 200;
        this.data = data;
    }

    public void success(String message){
        this.code = 200;
        this.message = message;
    }

    public void success(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public void success(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void fail(String message){
        this.code = 400;
        this.message = message;
    }

    public void fail(String message,Object data){
        this.code = 400;
        this.message = message;
        this.data = data;
    }
    public void fail(Integer code,String messgae){
        this.code = code;
        this.message = message;
    }

    public void fail(Integer code,String messgae,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
