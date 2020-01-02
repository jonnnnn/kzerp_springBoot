/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.controller;

import com.imema.common.annotation.SysLog;
import com.imema.common.enums.EntityState;
import com.imema.common.exception.RRException;
import com.imema.common.utils.Constant;
import com.imema.common.utils.R;
import com.imema.modules.sys.entity.SysMenuEntity;
import com.imema.modules.sys.service.ShiroService;
import com.imema.modules.sys.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private ShiroService shiroService;

	/**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public R nav(){
		System.out.printf("uid>>>>>" + getUserId());
		List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
		Set<String> permissions = shiroService.getUserPermissions(getUserId());
		return R.ok().putData("menuList", menuList).putData("permissions", permissions);
	}
	
	/**
	 * 所有菜单列表页面
	 */
	@PostMapping("/list")
	@RequiresPermissions("sys:menu:list")
	public R list(){
		List<SysMenuEntity> areaList = sysMenuService.queryParentList();
		List<SysMenuEntity> childList = sysMenuService.queryChildList();
		for (SysMenuEntity area : areaList) {
			buildTree(area,childList);
		}
		return R.ok().putData(areaList);
	}
	
	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@GetMapping("/select")
	public R select(){
		List<SysMenuEntity> areaList = sysMenuService.queryParentList();
		List<SysMenuEntity> childList = new ArrayList<>();
		if(getUserId() != Constant.SUPER_ADMIN){
			childList = sysMenuService.queryChildNoMenuList();
		}else{
			childList = sysMenuService.queryChildList();
		}

		for (SysMenuEntity area : areaList) {
			buildTree(area,childList);
		}
		return R.ok().putData(areaList);
	}
	
	/**
	 * 菜单信息
	 */
	@GetMapping("/info/{menuId}")
	@RequiresPermissions("sys:menu:info")
	public R info(@PathVariable("menuId") Long menuId){
		SysMenuEntity menu = sysMenuService.getById(menuId);
		return R.ok().put("menu", menu);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存菜单")
	@PostMapping("/save")
	@RequiresPermissions("sys:menu:save")
	public R save(@RequestBody SysMenuEntity menu){
        if(org.springframework.util.StringUtils.isEmpty(menu.getMenuId())){
            menu.setState(EntityState.NEW);
        }else{
            menu.setState(EntityState.MODIFIED);
        }
		sysMenuService.save(menu);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改菜单")
	@PostMapping("/update")
	@RequiresPermissions("sys:menu:update")
	public R update(@RequestBody SysMenuEntity menu){
		//数据校验
		verifyForm(menu);
				
		sysMenuService.updateById(menu);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除菜单")
	@PostMapping("/delete")
	@RequiresPermissions("sys:menu:delete")
	public R delete(@RequestBody Map<String,Object> menuId){
		//判断是否有子菜单或按钮
		List<Integer> list = (List<Integer>)menuId.get("data");
		for(int i=0;i<list.size();i++){
			int a=list.get(i);
			List<SysMenuEntity> menuList = sysMenuService.queryHaveChild(a);
			if(menuList.size() > 0){
				return R.error("请先删除子菜单或按钮");
			}
			sysMenuService.removeById(a);
		}
		return R.ok();
	}
	
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenuEntity menu){
		if(StringUtils.isBlank(menu.getName())){
			throw new RRException("菜单名称不能为空");
		}
		
		if(menu.getParentId() == null){
			throw new RRException("上级菜单不能为空");
		}
		
		//菜单
		if(menu.getType() == Constant.MenuType.MENU.getValue()){
			if(StringUtils.isBlank(menu.getUrl())){
				throw new RRException("菜单URL不能为空");
			}
		}
		
		//上级菜单类型
		int parentType = Constant.MenuType.CATALOG.getValue();
		if(menu.getParentId() != 0){
			SysMenuEntity parentMenu = sysMenuService.getById(menu.getParentId());
			parentType = parentMenu.getType();
		}
		
		//目录、菜单
		if(menu.getType() == Constant.MenuType.CATALOG.getValue() ||
				menu.getType() == Constant.MenuType.MENU.getValue()){
			if(parentType != Constant.MenuType.CATALOG.getValue()){
				throw new RRException("上级菜单只能为目录类型");
			}
			return ;
		}
		
		//按钮
		if(menu.getType() == Constant.MenuType.BUTTON.getValue()){
			if(parentType != Constant.MenuType.MENU.getValue()){
				throw new RRException("上级菜单只能为菜单类型");
			}
			return ;
		}
	}

	//列表
	private void buildTree(SysMenuEntity parent,List<SysMenuEntity> areaList) {
		List child = parent.getChildren();
		if(child == null)
			child = new ArrayList();
		for (SysMenuEntity alist : areaList) {
			if(parent.getMenuId() == alist.getParentId()){
				child.add(alist);
				parent.setChildren(child);
			}
		}
		areaList.removeAll(child);

		for(Object c: child) {
			buildTree((SysMenuEntity)c, areaList);
		}
	}

}
