/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imema.common.utils.R;
import com.imema.common.utils.ReflectionUtils;
import com.imema.data.IBaseModel;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author kinble
 */
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Component
public class ControllerAspect {

    @Pointcut("execution ( public * com.imema.modules..*.*Controller.*(..)) ")
    public void allController() {

    }

    @Before("allController()")
    public void before(JoinPoint point) {
        ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequestWrapper request = (HttpServletRequestWrapper) req.getRequest();
        Object[] args = point.getArgs();
        if (args.length == 0) {
            return;
        }

        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg == null) continue;

            if (IBaseModel.class.isAssignableFrom(arg.getClass())) {
                IBaseModel targetProxy = (IBaseModel) arg;
                Map<String, String[]> parameterMap = req.getRequest().getParameterMap();
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    if (targetProxy.get(entry.getKey()) != null)
                        continue;
                    if (entry.getValue() != null && entry.getValue().length == 1) {
                        targetProxy.put(entry.getKey(), entry.getValue()[0]);
                    } else if (entry.getValue().length > 1) {
                        targetProxy.put(entry.getKey(), entry.getValue());
                    }
                }
                try {
                    String jsonStr = getReqBodyMsg(request);
                    if (StringUtils.isNotBlank(jsonStr)) {
                        JSONObject jsonObject = JSON.parseObject(jsonStr);
                        handleModel(targetProxy, jsonObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                args[i] = targetProxy;
            }
        }
    }

    private void handleModel(Object obj, Object json) throws  Exception {
        if(json == null || obj == null || !IBaseModel.class.isAssignableFrom(obj.getClass())) return;
        IBaseModel model = (IBaseModel) obj;
        if(JSONObject.class.isAssignableFrom(json.getClass())) {
            JSONObject jsonObject = (JSONObject) json;
            for(Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                Object val = entry.getValue();
                String key = entry.getKey();
                if(val == null) continue;
                // 非简单型的字段
                if(ReflectionUtils.hasField(obj, key)) {
                    Object fieldObj = ReflectionUtils.getFieldValue(obj, key);
                    if(fieldObj==null)continue;
                    if(Collection.class.isAssignableFrom(fieldObj.getClass())) {
                        Collection subList = (Collection) fieldObj;
                        // 对应的json对象也是数组
                        JSONArray valList = (JSONArray) val;
                        if(subList.isEmpty() || valList.isEmpty()) continue;
                        Iterator it = subList.iterator();
                        Iterator vit = valList.iterator();
                        while (it.hasNext() && vit.hasNext()) {
                            handleModel(it.next(), vit.next());
                        }
                    } else if(IBaseModel.class.isAssignableFrom(fieldObj.getClass())) {
                        handleModel(fieldObj, key);
                    }
                }
                model.put(key, val);
            }
        }
    }

    private String getReqBodyMsg(HttpServletRequest request) throws Exception {
        StringBuilder wholeStr = new StringBuilder();
        String contentType = request.getHeader("Content-Type");
        if(contentType.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase())) {
            BufferedReader br = null;
            try {
                br = request.getReader();
                String line = null;
                while ((line = br.readLine()) != null) {
                    wholeStr.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return wholeStr.toString();
    }

    @Around("allController()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret = null;
        try {
            ret = joinPoint.proceed();
        }catch (Exception e) {
            e.printStackTrace();
            this.afterThrowing(joinPoint, e);
            return R.error(e.getMessage());
        }
        return ret;
    }

    @AfterThrowing(pointcut = "allController()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("method:" + methodName);
        System.out.println("异常：" + ex.getMessage());
    }

    @AfterReturning(pointcut = "allController()", returning = "rtv")
    public Object afterReturn(JoinPoint joinPoint, Object rtv) {

        return rtv;
    }
}
