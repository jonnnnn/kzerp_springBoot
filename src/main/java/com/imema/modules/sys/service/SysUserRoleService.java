/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.entity.SysUserRoleEntity;

import java.util.List;



/**
 * 用户与角色对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {
	
	void saveOrUpdate(Long userId, List<SysRoleEntity> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<SysRoleEntity> queryRoleList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);

	/**
	 * 根据用户删除
	 */
	int deleteUser(int userId);
}
