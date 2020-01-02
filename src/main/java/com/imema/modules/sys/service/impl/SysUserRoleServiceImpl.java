/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.MapUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.sys.dao.SysUserRoleDao;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.entity.SysUserRoleEntity;
import com.imema.modules.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * 用户与角色对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

	@Override
	public void saveOrUpdate(Long userId, List<SysRoleEntity> roleIdList) {
		//先删除用户与角色关系
		this.removeByMap(new MapUtils().put("user_id", userId));

		if(roleIdList == null || roleIdList.size() == 0){
			return ;
		}

		//保存用户与角色关系
		for(SysRoleEntity role : roleIdList){
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(role.getRoleId());

			this.save(sysUserRoleEntity);
		}
	}

	@Override
	public List<SysRoleEntity> queryRoleList(Long userId) {
		return baseMapper.queryRoleList(userId);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return baseMapper.deleteBatch(roleIds);
	}

	@Override
	public int deleteUser(int userId) {
		return baseMapper.deleteUser(userId);
	}
}
