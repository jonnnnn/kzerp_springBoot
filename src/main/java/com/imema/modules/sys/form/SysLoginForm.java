/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.form;

import lombok.Data;

/**
 * 登录表单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class SysLoginForm {
    private String compcode;
    private String username;
    private String password;
    private String captcha;
    private String uuid;
    private String token;

}
