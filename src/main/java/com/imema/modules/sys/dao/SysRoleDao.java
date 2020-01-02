/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<SysRoleEntity> queryRoleList(Long createUserId);
	List<SysRoleEntity> queryRoleNameList(Long userId);
	List<SysRoleEntity> queryRoleId(@Param("p") Map<String ,Object> param);

	IPage<SysRoleEntity> orderList(@Param("page") IPage<SysRoleEntity> page, @Param("p") Map<String ,Object> param);
}
