/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.annotation.DataFilter;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.so.entity.SalesOrderEntity;
import com.imema.modules.sys.dao.SysDeptDao;
import com.imema.modules.sys.entity.SysDeptEntity;
import com.imema.modules.sys.service.SysDeptService;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("sysDeptService")
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

	@Override
	@DataFilter(subDept = true, user = false, tableAlias = "t1")
	public List<SysDeptEntity> queryList(Map<String, Object> params){
		return baseMapper.queryList(params);
	}

	@Override
	public List<Long> queryDetpIdList(Long parentId) {
		return baseMapper.queryDetpIdList(parentId);
	}

	@Override
	public List<Long> getSubDeptIdList(Long deptId){
		//部门及子部门ID列表
		List<Long> deptIdList = new ArrayList<>();

		//获取子部门ID
		List<Long> subIdList = queryDetpIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		return deptIdList;
	}

	/**
	 * 递归
	 */
	private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList){
		for(Long deptId : subIdList){
			List<Long> list = queryDetpIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}

			deptIdList.add(deptId);
		}
	}

	public List<SysDeptEntity> list(Map<String,Object> params) {
//        findDepts()  ==>order by pid,order_num
		List<SysDeptEntity> list = baseMapper.selectByMap(params);
		Map<Long, List<SysDeptEntity>> map = new HashMap<>();
		Map<Long, SysDeptEntity> idMap = new HashMap<>();
//        pid+deptList
		for (SysDeptEntity dept : list) {
			idMap.put(dept.getDeptId(), dept);

			long pid = dept.getParentId();

			if (!map.keySet().contains(pid)) {
				List<SysDeptEntity> subList = new ArrayList<>();
				subList.add(dept);
				map.put(pid, subList);
			} else {
				map.get(pid).add(dept);
			}
		}
//        设置子队列
		Set<Long> set = map.keySet();
		for (long pid : set) {
			List<SysDeptEntity> SysDeptEntitys = map.get(pid);
			if (pid == 0) {
				for (SysDeptEntity dept : SysDeptEntitys) {
					dept.setParentName("顶级菜单");
				}
			} else {
				idMap.get(pid).setChildren(SysDeptEntitys);
				for (SysDeptEntity dept : SysDeptEntitys) {
					dept.setParentName(idMap.get(pid).getName());
				}
			}
		}

		List<SysDeptEntity> result = map.get(0);

		return result;
	}

	@Override
	public List<SysDeptEntity> queryParentList() {
		return baseMapper.queryParentList();
	}

	@Override
	public List<SysDeptEntity> queryChildList() {
		return baseMapper.queryChildList();
	}

	@Override
	public SysDeptEntity queryOne(int dept_id) {
		return baseMapper.queryOne(dept_id);
	}

	@Override
	public List<SysDeptEntity> queryHaveChild(int deptId) {
		return baseMapper.queryHaveChild(deptId);
	}

	@Override
	public int tree(SysDeptEntity sysDeptEntity) {
		SysDeptEntity  dept = baseMapper.queryOne(sysDeptEntity.getParentId().intValue());
		if(dept.getIsTop()!=1){
			tree(dept);
		}
		return dept.getDeptId().intValue();
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Map<String,Object> pageForm = (Map<String, Object>) params.get("pageForm");
		Map<String,Object> dataForm = (Map<String, Object>) params.get("dataForm");
		Map<String,Object> selectForm = (Map<String, Object>) dataForm.get("data");
		IPage<SysDeptEntity> page = baseMapper.orderList(new Query<SysDeptEntity>().getPage(pageForm),selectForm);
		return new PageUtils(page);
	}


}
