/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.form;

import lombok.Data;

/**
 * 密码表单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

}
