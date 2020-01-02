/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.entity.CheckBillEntity;
import com.imema.modules.inv.service.CheckBillLineService;
import com.imema.modules.inv.service.CheckBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;



/**
 * 盘点单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@RestController
@RequestMapping("inv/checkbill")
@Api("APP盘点接口")
public class CheckBillController {
    @Autowired
    private CheckBillService checkBillService;
    @Autowired
    private CheckBillLineService checkBillLineService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取盘点列表")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = checkBillService.queryPage(params);
        return R.ok().putData(page);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("inv:checkbill:save")
    @ApiOperation("盘点保存")
    @Transactional
    public R save(@RequestBody CheckBillEntity checkBillEntity){
        try {
            EntityState state = checkBillEntity.getState();
            if (state.equals(EntityState.NEW)) {
                checkBillEntity.setCheckDate(new Date());
                checkBillEntity.setStatus(OrderEnum.NEW.getvalue());
                checkBillEntity.setDeletedFlag("N");
                checkBillService.save(checkBillEntity);
                // 保存从表数据
                checkBillLineService.save(checkBillEntity);
            } else if (state.equals(EntityState.MODIFIED)) {
                checkBillService.save(checkBillEntity);
                checkBillLineService.save(checkBillEntity);
            } else if (state.equals(EntityState.DELETED)) {
                checkBillEntity.setDeletedFlag("Y");
                checkBillService.save(checkBillEntity);
            } else if (state.equals(EntityState.NONE)) {
                checkBillLineService.save(checkBillEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException("保存订单失败！"+e.getMessage());
        }
        return R.ok();
    }
    /**
     * 提交并且自动拣货
     */
    @PostMapping("/submit")
    @RequiresPermissions("inv:checkbill:submit")
    @ApiOperation("盘点提交")
    @Transactional
    public R submit(@RequestBody CheckBillEntity checkBillEntity){
        checkBillService.submit(checkBillEntity);
        return R.ok();
    }
}
