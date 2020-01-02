/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.controller;

import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.pur.entity.PoLineEntity;
import com.imema.modules.pur.service.PoLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/**
 * 进货单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@Controller
@RequestMapping("pur/poline")
@Api("APP采购明细接口")
public class PoLineController {
    @Autowired
    private PoLineService poLineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pur:poline:list")
    @ResponseBody
    @ApiOperation("根据采购ID获取采购明细列表")
    public R list(@RequestBody FormParams params){
        int poHeaderId = Integer.parseInt(params.getParam("id").toString());
        List<PoLineEntity> poLineEntityList=poLineService.getPoLineEntityListByPoId(poHeaderId);
        return R.ok().putData(poLineEntityList);
    }

    @RequestMapping("/view")
    @RequiresPermissions("pur:poline:list")
    public R view(){
        return R.ok();
    }
}
