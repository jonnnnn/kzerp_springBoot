/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;



/**
 * 角色与菜单对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
	int deleteBatch(Long roleIds);
	
}
