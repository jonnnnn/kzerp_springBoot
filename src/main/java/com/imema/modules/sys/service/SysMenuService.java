/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysMenuService extends IService<SysMenuEntity> {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<SysMenuEntity> getUserMenuList(Long userId);

	/**
	 * 删除
	 */
	void delete(Long menuId);

	List<SysMenuEntity> queryParentList();
	List<SysMenuEntity> queryChildList();
	SysMenuEntity queryOne(int menuId);
	List<SysMenuEntity> queryHaveChild(int menuId);
	List<SysMenuEntity> queryChildNoMenuList();
}
