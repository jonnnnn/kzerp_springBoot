/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.R;
import com.imema.modules.sys.dao.SysUserTokenDao;
import com.imema.modules.sys.entity.SysUserTokenEntity;
import com.imema.modules.sys.oauth2.TokenGenerator;
import com.imema.modules.sys.service.SysUserTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

	//12小时后过期
	private final static int EXPIRE = 7;


	@Override
	public R createToken(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = DateUtil.date();
		//过期时间
		Date expireTime = DateUtil.offsetDay(now, EXPIRE);

		QueryWrapper<SysUserTokenEntity> queryWrapper = new QueryWrapper<>();
		//判断是否生成过token
		SysUserTokenEntity tokenEntity = this.getOne(queryWrapper.eq("user_id", userId).eq("token", token));
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			this.save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			this.updateById(tokenEntity);
		}

		R r = R.ok().putData("uuid", userId).putData("token", token).putData("expire", EXPIRE);

		return r;
	}

	@Override
	public boolean checkToken(long userId, String token) {
		//当前时间
		Date now = DateUtil.date();
		//过期时间
		Date expireTime = DateUtil.offsetDay(now, EXPIRE);
		QueryWrapper<SysUserTokenEntity> queryWrapper = new QueryWrapper<>();
		//判断是否生成过token
		SysUserTokenEntity tokenEntity = this.getOne(queryWrapper.eq("user_id", userId).eq("token", token));
		if(tokenEntity != null) {
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			this.updateById(tokenEntity);
			return true;
		}
		return false;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//修改token
		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		this.updateById(tokenEntity);
	}
}
