/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.imema.common.utils.ReflectionUtils;
import com.imema.common.utils.SpringContextUtils;
import com.imema.modules.base.dao.SysLookUpValuesDao;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author kinble
 */
@JsonComponent
public class JsonDataDeserializer {

    public static class Serializer extends JsonSerializer<AbstractBaseModel> {
        // arg0 即是Controller返回的对象
        // arg1 即是输出对象
        @Override
        public void serialize(AbstractBaseModel modal, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException {
            jsonGenerator.writeObject(toExtMap(modal));
        }

        private static Map toExtMap(final IBaseModel modal) throws IOException {
            SysLookUpValuesDao sysLookUpValuesDao = SpringContextUtils.getBean(SysLookUpValuesDao.class);
            if(sysLookUpValuesDao == null) {
                throw  new IOException("快码映射失败");
            }
            JSONObject map = (JSONObject)JSON.toJSON(modal);
            Map<String, Object> extMap = (Map<String, Object>)ReflectionUtils.getFieldValue(modal, "extProperties");
            Field[] fields=modal.getClass().getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(LookUpType.class)) {
                    LookUpType lookUpType = field.getAnnotation(LookUpType.class);
                    if(StringUtils.isEmpty(ReflectionUtils.getFieldValue(modal,field.getName()))){
                        continue;
                    }
                    String luCode=ReflectionUtils.getFieldValue(modal,field.getName()).toString();
                    String luValue=lookUpType.value();
                    String luType=lookUpType.type();
                    if("CODE".equals(luType)){
                        String meaning=sysLookUpValuesDao.getLookUpNameByCode(luValue,luCode);
                        extMap.put(field.getName()+"Mean", meaning);
                    }else if("DICT".equals(luType)){
                        String meaning=sysLookUpValuesDao.getDictNameById(luValue,luCode);
                        extMap.put(field.getName()+"Mean", meaning);
                    }
                }

                Object subObj = ReflectionUtils.getFieldValue(modal,field.getName());
                if(subObj != null) {
                    if(Collection.class.isAssignableFrom(subObj.getClass())) {
                        Collection subList = (Collection) subObj;
                        Iterator sit = subList.iterator();
                        boolean isModel = false;
                        List<Map> tranList = new ArrayList<>();
                        while (sit.hasNext()) {
                            Object subItem = sit.next();
                            if (isModel || (subItem != null && IBaseModel.class.isAssignableFrom(subItem.getClass()))) {
                                Map temMap = toExtMap((IBaseModel) subItem);
                                tranList.add(temMap);
                                isModel = true;
                            }
                        }
                        if (tranList.size() > 0)
                            map.put(field.getName(), tranList);
                    }
                }
            }

            // 扩展字段的map
            if(!extMap.isEmpty()) {
                map.putAll(extMap);
            }
            return map;
        }

    }
}
