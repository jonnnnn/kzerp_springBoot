/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.form;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class FormParams extends HashMap {

    public Map<String, Object> getPageForm() {
        return (Map<String, Object>)get("pageForm");
    }

    public Map<String, Map> getDataForm() {
        return (Map<String, Map>)get("dataForm");
    }

    public Map<String, Object> getData() {
        return (getDataForm() == null || getDataForm().get("data") == null) ?
                MapUtils.EMPTY_MAP : (Map<String, Object>)getDataForm().get("data");
    }

    public Object getParam(String param) {
        return getData().get(param);
    }
}
