/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.entity.CheckBillLineEntity;
import com.imema.modules.inv.service.CheckBillLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 盘点单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@RestController
@RequestMapping("inv/checkbillline")
@Api("APP盘点明细接口")
public class CheckBillLineController {
    @Autowired
    private CheckBillLineService checkBillLineService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("inv:checkbillline:list")
    @ApiOperation("根据盘点ID获取盘点明细列表")
    public R list(@RequestBody FormParams params){
        int checkBillId = Integer.parseInt(params.getParam("id").toString());
        List<CheckBillLineEntity> checkBillLineEntityList=checkBillLineService.getCheckBillLineEntityListByCheckBillId(checkBillId);
        return R.ok().putData(checkBillLineEntityList);
    }
}
