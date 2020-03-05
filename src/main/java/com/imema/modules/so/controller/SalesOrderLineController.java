/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import com.imema.modules.so.service.SalesOrderLineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 销售订单明细
 *
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@RestController
@RequestMapping("so/salesorderline")
public class SalesOrderLineController {
    @Autowired
    private SalesOrderLineService salesOrderLineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("so:salesorder:list")
    public R list(@RequestBody Map<String, Object> params){
        List<Map> page = salesOrderLineService.queryOrder(params);

        return R.ok().putData(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("so:salesorder:info")
    public R info(@PathVariable("id") Integer id){
		SalesOrderLineEntity salesOrderLine = salesOrderLineService.getById(id);

        return R.ok().put("salesOrderLine", salesOrderLine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("so:salesorder:save")
    public R save(@RequestBody SalesOrderLineEntity salesOrderLine){
		salesOrderLineService.save(salesOrderLine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("so:salesorderline:update")
    public R update(@RequestBody SalesOrderLineEntity salesOrderLine){
		salesOrderLineService.updateById(salesOrderLine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("so:salesorder:delete")
    public R delete(@RequestBody Integer[] ids){
		salesOrderLineService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
