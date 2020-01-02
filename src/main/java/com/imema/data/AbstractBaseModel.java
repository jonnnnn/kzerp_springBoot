/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kinble
 */
public abstract class AbstractBaseModel implements IBaseModel {

    @TableField(exist=false)
    @JSONField(serialize = false)
    private Map<String, Object> extProperties = new HashMap<>();

    @Override
    public EntityState getState() {
        if(get("__state") != null) {
            String ss = get("__state").toString();
            return EntityState.valueOf(ss);
        }
        return  null;
    }

    @Override
    public void setState(EntityState state) {
        if(state != null)
            put("__state", state.name());
    }

    @Override
    public Object get(String key) {
        if(ReflectionUtils.getDeclaredField(getClass(), key) != null) {
            return ReflectionUtils.getFieldValue(this, key);
        } else {
            return extProperties.get(key);
        }
    }

    @Override
    public void put(String key, Object value) {
        if(ReflectionUtils.getDeclaredField(getClass(), key) == null && value != null) {
            extProperties.put(key, value);
        }
    }
}
