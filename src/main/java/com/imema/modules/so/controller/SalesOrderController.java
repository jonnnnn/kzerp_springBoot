/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.controller;

import com.imema.common.annotation.DataFilter;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.modules.so.entity.SalesOrderEntity;
import com.imema.modules.so.service.SalesOrderLineService;
import com.imema.modules.so.service.SalesOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 销售订单
 *
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@RestController
@RequestMapping("so/salesorder")
@Api("销售单接口")
public class SalesOrderController {
    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private SalesOrderLineService salesOrderLineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation(value = "销售单列表",response = SalesOrderEntity.class)
//    @RequiresPermissions("so:salesorder:list")
    @DataFilter(tableAlias="a")
    @ResponseBody
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = salesOrderService.queryOrder(params);
        return R.ok().putData(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("so:salesorder:info")
    public R info(@PathVariable("id") Integer id){
		SalesOrderEntity salesOrder = salesOrderService.getById(id);

        return R.ok().putData(salesOrder);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("so:salesorder:update")
    public R update(@RequestBody SalesOrderEntity salesOrder){
        return salesOrderService.saveOrder(salesOrder);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("so:salesorder:delete")
    public R delete(@RequestBody Map<String, Object> params){
        String ids = params.get("ids") == null ? "" : params.get("ids") .toString();
		salesOrderService.removeByIds(Arrays.asList(ids.split(",")));

        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/prod")
//    @RequiresPermissions("so:salesorder:list")
    public R prod(@RequestBody Map<String, Object> params){
        List<Map<String,Object>> prod = salesOrderService.getProduct(params);

        return R.ok().putData(prod);
    }


    /**
     * 提交
     */
    @RequestMapping("/submit")
    // @RequiresPermissions("so:salesorder:delete")
    public R submit(@RequestBody Map<String, Object> params){
        String id = params.get("id") == null ? "" : params.get("id") .toString();
        try {
            return salesOrderService.submit(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 客户信息
     */
    @RequestMapping("/cust")
//    @RequiresPermissions("so:salesorder:list")
    public R custList(@RequestBody Map<String, Object> params){
        List<Map<String,Object>> prod = salesOrderService.getCustVender(params);

        return R.ok().putData(prod);
    }

}
