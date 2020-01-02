/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.controller;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.Constant;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.form.FormParams;
import com.imema.modules.sys.entity.SysDeptEntity;
import com.imema.modules.sys.entity.SysUserEntity;
import com.imema.modules.sys.service.SysDeptService;
import com.imema.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 部门管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询全部
	 */
	@RequestMapping(value = "/list")
	@RequiresPermissions("sys:dept:list")
	public R list(@RequestBody FormParams params){
		List<SysDeptEntity> list = sysDeptService.queryList(params.getData());
		return R.ok().putData(list);
	}
	/**
	 * 选择部门(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:dept:select")
	public R select(){
		List<SysDeptEntity> areaList= new ArrayList<>();
		if(getUserId() == Constant.SUPER_ADMIN){
			areaList = sysDeptService.queryParentList();
		}else{
			//根据当前用户的公司id为部门
			SysUserEntity user = sysUserService.getById(getUserId());
			SysDeptEntity deptEntity = sysDeptService.queryOne(user.getCompanyId());
			areaList.add(deptEntity);
		}
		//所有子
		List<SysDeptEntity> childList = sysDeptService.queryChildList();
		for (SysDeptEntity area : areaList) {
			area.put("currentId",getUserId());
			setTree(area,childList);
		}

		return R.ok().putData(areaList);
	}

	/**
	 * 上级部门Id(管理员则为0)
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sys:dept:list")
	public R info(){
		long deptId = 0;
		if(getUserId() != Constant.SUPER_ADMIN){
			List<SysDeptEntity> deptList = sysDeptService.queryList(new HashMap<String, Object>());
			Long parentId = null;
			for(SysDeptEntity sysDeptEntity : deptList){
				if(parentId == null){
					parentId = sysDeptEntity.getParentId();
					continue;
				}
				if(parentId > sysDeptEntity.getParentId().longValue()){
					parentId = sysDeptEntity.getParentId();
				}
			}
			deptId = parentId;
		}

		return R.ok().put("deptId", deptId);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{deptId}")
	@RequiresPermissions("sys:dept:info")
	public R info(@PathVariable("deptId") Long deptId){
		SysDeptEntity dept = sysDeptService.getById(deptId);

		return R.ok().put("dept", dept);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:dept:save")
	@Transactional
	public R save(@RequestBody SysDeptEntity dept){
		if(StringUtils.isEmpty(dept.getDeptId())){
			dept.setState(EntityState.NEW);

		}else{
			dept.setState(EntityState.MODIFIED);
		}
	    sysDeptService.save(dept);
		return R.ok();
	}


	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:dept:delete")
	public R delete(@RequestBody Map<String,Object> deptId){
		//判断是否有子部门
		List<Integer> list = (List<Integer>)deptId.get("data");
		for(int i=0;i<list.size();i++){
				int a=list.get(i);
				List<SysDeptEntity> deptList =  sysDeptService.queryHaveChild(a);
				if(deptList.size() > 0){
					return R.error("请先删除子部门");
			}
			sysDeptService.removeById(a);
		}
		return R.ok();
	}
	/**
	 * 信息
	 */
	@RequestMapping("/queryname/{deptId}")
	@RequiresPermissions("sys:dept:info")
	public R queryname(@PathVariable("deptId") Long deptId){
		SysDeptEntity dept = sysDeptService.getById(deptId);
		return R.ok().putData(dept);
	}

	private void setTree(SysDeptEntity parent,List<SysDeptEntity> areaList){
		List child = parent.getChildren();
		if(child == null)
			child = new ArrayList();
		for (SysDeptEntity alist : areaList) {
			alist.put("currentId",getUserId());
			if(parent.getDeptId() == alist.getParentId()){
				child.add(alist);
				parent.setChildren(child);
			}
		}

		areaList.removeAll(child);

		for(Object c: child) {
			setTree((SysDeptEntity)c, areaList);
		}
	}


}
