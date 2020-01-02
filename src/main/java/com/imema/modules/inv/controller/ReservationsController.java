/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.inv.service.ReservationsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



/**
 * 物料保留
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("inv:reservations:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reservationsService.queryPage(params);

        return R.ok().put("page", page);
    }

}
