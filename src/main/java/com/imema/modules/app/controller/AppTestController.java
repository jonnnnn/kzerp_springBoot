/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.app.controller;


import com.imema.common.utils.R;
import com.imema.modules.app.annotation.Login;
import com.imema.modules.app.annotation.LoginUser;
import com.imema.modules.app.entity.UserEntity;
import com.imema.modules.inv.service.OnhandService;
import com.imema.modules.sys.entity.SysUserEntity;
import com.imema.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * APP测试接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app")
@Api("APP测试接口")
public class AppTestController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private OnhandService onhandService;

    @Login
    @GetMapping("userInfo")
    @ApiOperation("获取用户信息")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @PostMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(SysUserEntity userEntity){
        return R.ok().put("msg", userEntity.get("test"));
    }

    @PostMapping("notTokenBody")
    @ApiOperation("忽略Token验证测试")
    public R notTokenBody(@RequestBody SysUserEntity userEntity){
        SysUserEntity user = userService.queryByUserName("admin");
        System.out.println(userEntity);
        return R.ok().put("msg", user);
    }

    @PutMapping("notTokenBody/{id}")
    @ApiOperation("忽略Token验证测试")
    @Transactional
    public R notTokenBody(@PathVariable Long id, @RequestBody SysUserEntity userEntity){
        SysUserEntity user = userService.getById(id);
        user.setCreateUserId(3l);
        userService.update(user);
        String a = null;
        a.indexOf("1");
        return R.ok().putData(user);
    }

}
