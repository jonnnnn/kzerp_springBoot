/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.app.form;

import com.imema.modules.form.FormParams;

import java.util.Map;

/**
 * @author kinble
 */
public class FormUtils {

    public static Map<String, Object> putData(FormParams formParams, String key, Object value) {
        if(formParams.getDataForm() != null) {
            Map relDataForm = formParams.getDataForm();
            Map<String, Object> data = (Map<String, Object>) relDataForm.get("data");
            if(data != null) {
                data.put(key, value);
            }
        } else {
            formParams.put(key, value);
        }
        return formParams;
    }

    public static Map<String, Object> putAllData(FormParams formParams, Map<String, Object> all) {
        if(formParams.getDataForm() != null) {
            Map relDataForm = formParams.getDataForm();
            Map<String, Object> data = (Map<String, Object>) relDataForm.get("data");
            if(data != null) {
                data.putAll(all);
            }
        } else {
            formParams.putAll(all);
        }
        return formParams;
    }
}
