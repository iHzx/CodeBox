package com.api.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.core.exception.CodeBoxException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ReqUtil {

    public static int getRandom(int min, int max) {
        Random random = new Random();
        int int1 = random.nextInt(max) % (max - min + 1) + min;
        int int2 = random.nextInt(99) % (99 - 10 + 1) + 10;
        return int1 * int2;
    }

    public static String getCheckCodeStr(){
        Random random = new Random();
        String randString_p = "0123456789";
        String randomString = "";
        for(int i=1;i<=6;i++){
            randomString=randomString+String.valueOf(randString_p.charAt(random.nextInt(randString_p.length())));
        }
        return randomString;
    }

    public static Object getData(HttpServletRequest request, Class c) {
        try {
            return JSON.parseObject(request.getParameter("data"), c);
        } catch (Exception e) {
            throw new CodeBoxException("报文转换错误!");
        }
    }

    public static Map<String, Object> getDataToMap(HttpServletRequest request) {
        try {
            return JSON.parseObject(request.getParameter("data"));
        } catch (Exception e) {
            throw new CodeBoxException("报文转换错误!");
        }
    }

    public static Map<String, Object> objToMap(Object obj){
        return JSON.parseObject(JSON.toJSONString(obj));
    }



    public static JSONObject getData(HttpServletRequest request) {
        try {
            return JSON.parseObject(request.getParameter("data"));
        } catch (Exception e) {
            throw new CodeBoxException("报文转换错误!");
        }
    }

    public static List<?> getDataToList(HttpServletRequest request, Class c) {
        try {
            return JSON.parseArray(request.getParameter("data"), c);
        } catch (Exception e) {
            throw new CodeBoxException("报文转换错误!");
        }

    }



}
