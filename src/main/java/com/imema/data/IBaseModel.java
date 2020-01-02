/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.data;

import com.imema.common.enums.EntityState;

/**
 *
 * @author kinble
 */
public interface IBaseModel {
    EntityState getState();

    void setState(EntityState state);

    Object get(String key);

    void put(String key, Object value);
}
