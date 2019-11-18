package com.turing.professional_website.util;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

/**
 * http响应状态码封装类
 * @author Jack
 * @date 2019-03-20-16:40
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Msg {

    private int code;
    private String msg;
    private Map<String,Object> extended = new HashMap<String, Object>();

    public Msg add(String key, Object value){

        this.getExtended().put(key, value);
        return this;
    }

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理成功!");
        return msg;
    }

    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("处理失败!");
        return msg;
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
