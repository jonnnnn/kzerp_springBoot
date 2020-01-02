/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.inv.service.TransactionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



/**
 * 物料事物
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/transactions")
@Api("APP库存流水接口")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionsService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取库存流水表")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = transactionsService.queryPage(params);
        return R.ok().putData(page);
    }

}
