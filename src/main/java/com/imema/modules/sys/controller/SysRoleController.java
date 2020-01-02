/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.controller;

import com.imema.common.annotation.SysLog;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.Constant;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.validator.ValidatorUtils;
import com.imema.modules.form.FormParams;
import com.imema.modules.sys.entity.*;
import com.imema.modules.sys.service.SysDeptService;
import com.imema.modules.sys.service.SysRoleDeptService;
import com.imema.modules.sys.service.SysRoleMenuService;
import com.imema.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysRoleDeptService sysRoleDeptService;
	@Autowired
	private SysDeptService sysDeptService;

	/**
	 * 角色列表
	 */
	@PostMapping("/list")
	@RequiresPermissions("sys:role:list")
	public R list(@RequestBody FormParams params){
		//如果不是超级管理员，则只查询自己创建的角色列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.getDataForm().get("data").put("companyId",getCompanyId());
		}
		PageUtils page = sysRoleService.queryPage(params);
		for(Object obj : page.getList()) {
			SysRoleEntity role = (SysRoleEntity) obj;
			List<Long> deptList = sysRoleDeptService.queryDeptList(Long.parseLong(role.getRoleId().toString()));
			List<Long> menuList = sysRoleMenuService.queryMenuIdList(Long.parseLong(role.getRoleId().toString()));
			role.setMenuIdList(menuList);
			role.setDeptIdList(deptList);
		}
		return R.ok().putData(page);
	}
	
	/**
	 * 角色列表
	 */
	@GetMapping("/select")
	@RequiresPermissions("sys:role:select")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		//如果不是超级管理员，则只查询自己所拥有的角色列表
		if(getUserId() != Constant.SUPER_ADMIN){
			map.put("companyId", getCompanyId());
		}
		List<SysRoleEntity> list = sysRoleService.queryRoleId(map);
		
		return R.ok().putData( list);
	}

	
	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@PostMapping("/save")
	@RequiresPermissions("sys:role:save")
	@Transactional
	public R save(@RequestBody SysRoleEntity role){
		ValidatorUtils.validateEntity(role);
		role.setCreateUserId(getUserId());
		if(StringUtils.isEmpty(role.getRoleId())){
			role.setState(EntityState.NEW);
			if(getUserId() != Constant.SUPER_ADMIN){
				role.setCompanyId(getCompanyId());
			}else{
				//超级用户必须挂在顶层公司下
				if(getUser().getSuperUser()==1 && getUserId() != Constant.SUPER_ADMIN){
					role.setCompanyId(getUser().getCompanyId());
				}else {
					SysDeptEntity sysDeptEntity = sysDeptService.queryOne(role.getDeptId().intValue());
					if(sysDeptEntity.getIsTop()==1){
						role.setCompanyId(role.getDeptId().intValue());
					}else{
						int check = sysDeptService.tree(sysDeptEntity);
						role.setCompanyId(check);
					}

				}
			}
			role.setCreateTime(new Date());
		}else{
			role.setState(EntityState.MODIFIED);
		}
		sysRoleService.save(role);
		Map map = new HashMap();
		map.put("roleName",role.getRoleName());
		map.put("deptId",role.getDeptId());
		map.put("createUserId",role.getCreateUserId());
		List<SysRoleEntity> list = sysRoleService.queryRoleId(map);
		for(SysRoleEntity sysRoleEntity :list){
			sysRoleDeptService.deleteBatch(sysRoleEntity.getRoleId());
			sysRoleMenuService.deleteBatch(sysRoleEntity.getRoleId());
			SysRoleDeptEntity sysRoleDeptEntity = new SysRoleDeptEntity();
			for(int i=0;i<role.getDeptIdList().size();i++){
				sysRoleDeptEntity.setDeptId(role.getDeptIdList().get(i));
				sysRoleDeptEntity.setRoleId(sysRoleEntity.getRoleId());
				sysRoleDeptEntity.setState(EntityState.NEW);
				sysRoleDeptService.save(sysRoleDeptEntity);
			}
			SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
			for(int i=0;i<role.getMenuIdList().size();i++){
				sysRoleMenuEntity.setMenuId(role.getMenuIdList().get(i));
				sysRoleMenuEntity.setRoleId(sysRoleEntity.getRoleId());
				sysRoleMenuEntity.setState(EntityState.NEW);
				sysRoleMenuService.save(sysRoleMenuEntity);
			}
		}
		return R.ok();
	}

	
	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@PostMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	@Transactional
	public R delete(@RequestBody Map<String,Object> roleIds){
		List<Integer> list = (List<Integer>)roleIds.get("data");
		for(int i=0;i<list.size();i++){
			Long a=list.get(i).longValue();
			sysRoleMenuService.deleteBatch(a);
			sysRoleDeptService.deleteBatch(a);
			sysRoleService.removeById(a);
		}
		return R.ok();
	}
}
