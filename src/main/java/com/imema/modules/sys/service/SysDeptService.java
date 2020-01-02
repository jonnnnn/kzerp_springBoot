/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.sys.entity.SysDeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysDeptService extends IService<SysDeptEntity> {

	List<SysDeptEntity> queryList(Map<String, Object> map);
	PageUtils queryPage(Map<String, Object> params);
	/**
	 * 查询子部门ID列表
	 * @param parentId  上级部门ID
	 */
	List<Long> queryDetpIdList(Long parentId);

	/**
	 * 获取子部门ID，用于数据过滤
	 */
	List<Long> getSubDeptIdList(Long deptId);

	/**
	* 查询递归队列：部门
	* @param params
	 */
	List<SysDeptEntity> list(Map<String,Object> params);

	List<SysDeptEntity> queryParentList();
	List<SysDeptEntity> queryChildList();
	SysDeptEntity queryOne(int dept_id);
	List<SysDeptEntity> queryHaveChild(int deptId);
	/**
	 * 递归部门顶层 作为公司ID
	 */
	int tree(SysDeptEntity sysDeptEntity);
}
