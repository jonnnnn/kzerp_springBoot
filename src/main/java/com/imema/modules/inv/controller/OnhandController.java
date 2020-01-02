/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.service.OnhandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 现有量
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/onhand")
@Api("APP现有量接口")
public class OnhandController {
    @Autowired
    private OnhandService onhandService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取现有量列表")
    public R list(@RequestBody FormParams params){
        PageUtils page = onhandService.queryPage(params);
        return R.ok().putData(page);
    }
}
