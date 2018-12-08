package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Msg {
    private int code;
    private String msg;
    private Map<String,Object> extend = new HashMap<String,Object>();
    public static Msg fail(){
        Msg result = new Msg();
        result.code=100;
        result.msg="处理失败";
        return result;
    }
    public static Msg success(){
        Msg result = new Msg();
        result.code=200;
        result.msg="处理成功";
        return result;
    }
    public Msg add(String key,Object value){
        this.extend.put(key,value);
        return this;
    }
}
