/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.common.utils;

import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @author Mark sunlightcs@gmail.com
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
