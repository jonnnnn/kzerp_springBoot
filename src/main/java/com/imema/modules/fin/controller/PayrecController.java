/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.fin.entity.PayrecEntity;
import com.imema.modules.fin.service.PayrecService;
import com.imema.modules.form.FormParams;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;



/**
 * 应收应付单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:38
 */
@RestController
@RequestMapping("fin/payrec")
public class PayrecController {
    @Autowired
    private PayrecService payrecService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @RequiresPermissions("fin:payrec:list")
    public R list(@RequestBody FormParams params){
        PageUtils page = payrecService.queryPage(params);

        return R.ok().putData(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("fin:payrec:info")
    public R info(@PathVariable("id") Integer id){
		PayrecEntity payrec = payrecService.getById(id);

        return R.ok().putData(payrec);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("fin:payrec:save")
    public R save(@RequestBody PayrecEntity payrec){
		payrecService.save(payrec);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("fin:payrec:update")
    public R update(@RequestBody PayrecEntity payrec){
		payrecService.updateById(payrec);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("fin:payrec:delete")
    public R delete(@RequestBody Integer[] ids){
		payrecService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
