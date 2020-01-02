package com.imema.common.utils;

import org.springframework.util.StringUtils;

/**
 * @author Mr.Lee
 * @since 2019-08-12 11:21
 * Description:处理字符串
 **/
public class CommonStringUtils extends StringUtils {
    public static Boolean stringMemberAllNull(String[] arrays){
        for (String str : arrays) {
            if(!isEmpty(str)){
                return false;
            }
        }
        return true;
    }

    public static Boolean nullOrBlank(String[] str){
        for (String s : str) {
            if (StringUtils.isEmpty(s)&&StringUtils.trimAllWhitespace(s)==null){
                return true;
            }
        }
        return false;
    }
}
