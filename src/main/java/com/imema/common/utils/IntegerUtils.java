package com.imema.common.utils;

/**
 * @author Mr.Lee
 * @since 2019-08-09 00:35
 * Description: 处理Integer工具类
 **/
public class IntegerUtils {
    public static Integer parseInt(String val){
        if (val==null||val==""){
            return null;
        }else {
            return Integer.parseInt(val);
        }
    }
}
