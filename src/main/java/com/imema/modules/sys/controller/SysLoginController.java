/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.controller;

import com.imema.common.utils.R;
import com.imema.modules.sys.entity.SysUserEntity;
import com.imema.modules.sys.form.SysLoginForm;
import com.imema.modules.sys.service.SysCaptchaService;
import com.imema.modules.sys.service.SysUserService;
import com.imema.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
public class SysLoginController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;
	@Autowired
	private SysCaptchaService sysCaptchaService;

	/**
	 * 验证码
	 */
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, String uuid)throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//获取图片验证码
		BufferedImage image = sysCaptchaService.getCaptcha(uuid);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 验证登录
	 */
	@RequestMapping("/sys/checkLogin")
	public R checkLogin(SysLoginForm form) {
		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(form.getUsername());
		if(user == null)
			user = sysUserService.queryById(Integer.parseInt(form.getUuid()));
		if(user == null) {
			return R.error("账号不存在");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}

		if(sysUserTokenService.checkToken(user.getUserId(), form.getToken())) {
			return R.ok().putData(user);
		} else {
			return R.error("请重新登录");
		}
	}

	/**
	 * 登录
	 */
	@PostMapping("/sys/login")
	public R login(@RequestBody SysLoginForm form)throws IOException {
 		boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
		if(!captcha){
			//return R.error("验证码不正确");
		}

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(user.getUserId());
		r.putData("username", user.getUsername());
		r.putData("superUser",user.getSuperUser());
		return r;
	}


	/**
	 * 退出
	 */
	@PostMapping("/sys/logout")
	public R logout() {
		sysUserTokenService.logout(getUserId());
		return R.ok();
	}
	
}
