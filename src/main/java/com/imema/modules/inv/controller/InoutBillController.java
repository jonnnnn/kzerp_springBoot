/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.service.InoutBillLineService;
import com.imema.modules.inv.service.InoutBillService;
import com.imema.modules.inv.service.TransactionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 出入库单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@RestController
@RequestMapping("inv/inoutbill")
@Api("APP出入库接口")
public class InoutBillController {
    @Autowired
    private InoutBillService inoutBillService;
    @Autowired
    private InoutBillLineService inoutBillLineService;
    @Autowired
    private TransactionsService transactionsService;
    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取出入库列表")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = inoutBillService.queryPage(params);
        return R.ok().putData(page);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("inv:inoutbill:save")
    @ApiOperation("拣货操作")
    @Transactional
    public R save(@RequestBody InoutBillEntity inoutBillEntity){
        try {
            inoutBillLineService.saveInoutBillLine(inoutBillEntity);
            inoutBillService.saveInoutBill(inoutBillEntity);
            transactionsService.add(inoutBillEntity);
        } catch (Exception e) {
            throw new RuntimeException("拣货失败！"+e.getMessage());
        }
        return R.ok();
    }
}
