/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.sys.entity.SysRoleDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色与部门对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {
	
	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long[] roleIds);
	List<Long> queryDeptList(Long roleIds);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long roleIds);
}
