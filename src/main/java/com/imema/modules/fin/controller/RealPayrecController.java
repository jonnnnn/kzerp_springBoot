/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.controller;

import java.util.Arrays;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imema.modules.form.FormParams;

import com.imema.modules.fin.entity.RealPayrecEntity;
import com.imema.modules.fin.service.RealPayrecService;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;



/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
@RestController
@RequestMapping("fin/realpayrec")
public class RealPayrecController {
    @Autowired
    private RealPayrecService realPayrecService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("fin:realpayrec:list")
    public R list(@RequestBody FormParams params){
        PageUtils page = realPayrecService.queryPage(params);

        return R.ok().putData(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("fin:realpayrec:info")
    public R info(@PathVariable("id") Integer id){
		RealPayrecEntity realPayrec = realPayrecService.getById(id);

        return R.ok().putData(realPayrec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("fin:realpayrec:save")
    public R save(@RequestBody RealPayrecEntity realPayrec){
		realPayrecService.savePay(realPayrec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("fin:realpayrec:update")
    public R update(@RequestBody RealPayrecEntity realPayrec){
		realPayrecService.updateById(realPayrec);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("fin:realpayrec:delete")
    public R delete(@RequestBody Integer[] ids){
		realPayrecService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
