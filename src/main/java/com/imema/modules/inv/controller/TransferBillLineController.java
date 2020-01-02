/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.entity.TransferBillLineEntity;
import com.imema.modules.inv.service.TransferBillLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 调拨单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/transferbillline")
@Api("APP调拨明细接口")
public class TransferBillLineController {
    @Autowired
    private TransferBillLineService transferBillLineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("inv:transferbillline:list")
    @ApiOperation("根据调拨ID获取调拨明细列表")
    public R list(@RequestBody FormParams params){
        int transferBillId = Integer.parseInt(params.getParam("id").toString());
        List<TransferBillLineEntity> transferBillLineEntityList=transferBillLineService.getTransferBillLineEntityListByTransferBillId(transferBillId);
        return R.ok().putData(transferBillLineEntityList);
    }
}
