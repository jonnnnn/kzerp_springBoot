/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	List<SysMenuEntity> queryParentList();
	List<SysMenuEntity> queryChildList();
	List<SysMenuEntity> queryHaveChild(int menuId);
	SysMenuEntity queryOne(int menuId);
	List<SysMenuEntity> queryChildNoMenuList();
}
