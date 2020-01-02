/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imema.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);


	/**
	 * 根据用户名，查询系统用户
	 */
	IPage<SysUserEntity> pageUserName(Page page, String username);

	IPage<SysUserEntity> orderList(@Param("page") IPage<SysUserEntity> page, @Param("p") Map<String ,Object> param);

	SysUserEntity queryById(int userId);

	SysUserEntity queryId(String mobile);

	SysUserEntity queryMobile(@Param("p") Map<String ,Object> param);

	SysUserEntity checkPassword(@Param("p") Map<String ,Object> param);

	SysUserEntity queryUsername(String username);
}
