/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
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
