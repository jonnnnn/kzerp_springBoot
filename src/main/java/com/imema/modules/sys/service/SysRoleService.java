/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<SysRoleEntity> queryRoleList(Long createUserId);

	List<SysRoleEntity> queryRoleNameList(Long userId);
	List<SysRoleEntity> queryRoleId(Map parmes);
}
