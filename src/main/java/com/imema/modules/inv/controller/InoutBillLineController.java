/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.inv.service.InoutBillLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * 出入库单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/inoutbillline")
@Api("APP出入库明细接口")
public class InoutBillLineController {
    @Autowired
    private InoutBillLineService inoutBillLineService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("inv:inoutbill:list")
    @ApiOperation("根据出入库ID获取出入库明细")
    public R list(@RequestBody FormParams formParams){
        Integer inoutBillId = Integer.parseInt(formParams.getData().get("id").toString());
        List<InoutBillLineEntity> inoutBillLineEntityList=inoutBillLineService.getInoutBillLineEntityListByInoutBillId(inoutBillId);
        return R.ok().putData(inoutBillLineEntityList);
    }
}
