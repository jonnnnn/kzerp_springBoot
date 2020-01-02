/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.controller;

import com.imema.common.annotation.SysLog;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.Constant;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.validator.Assert;
import com.imema.common.validator.ValidatorUtils;
import com.imema.common.validator.group.AddGroup;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.modules.app.form.FormUtils;
import com.imema.modules.form.FormParams;
import com.imema.modules.sys.entity.SysDeptEntity;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.entity.SysUserEntity;
import com.imema.modules.sys.entity.SysUserRoleEntity;
import com.imema.modules.sys.form.PasswordForm;
import com.imema.modules.sys.service.SysDeptService;
import com.imema.modules.sys.service.SysRoleService;
import com.imema.modules.sys.service.SysUserRoleService;
import com.imema.modules.sys.service.SysUserService;
import io.swagger.models.auth.In;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private SysRoleService sysRoleService;


	/**
	 * 所有用户列表
	 */
	@PostMapping("/list")
	@RequiresPermissions("sys:user:list")
	@Transactional
	public R list(@RequestBody FormParams params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			//FormUtils.putData(params, "createUserId", getUserId());
			if(getUser().getSuperUser()!=1){
				params.getDataForm().get("data").put("userId", getUserId());
			}else{
				params.getDataForm().get("data").put("companyId", getCompanyId());
			}

		}
		PageUtils page = sysUserService.queryPage(params);
		for(Object obj : page.getList()) {
			SysUserEntity user = (SysUserEntity) obj;
			List<SysRoleEntity> roleEntityList = sysRoleService.queryRoleNameList(user.getUserId());
			List<Long> roleIds = new ArrayList<>();
			String roleNames = "";
			for(SysRoleEntity role : roleEntityList) {
				roleNames += role.getRoleName() + ",";
				roleIds.add(role.getRoleId());
			}
			user.put("roleNames", roleNames);
			user.setRoleIds(roleIds);
			user.put("currenId",getUserId());
		}
		return R.ok().putData(page);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@GetMapping("/info")
	public R info(){
		return R.ok().putData(getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@PostMapping("/password")
	public R password(@RequestBody FormParams form){
		SysUserEntity userEntity = sysUserService.queryById(Integer.parseInt(form.get("userId").toString()));
		//sha256加密
		String newPassword = new Sha256Hash(form.get("newPassword").toString(), userEntity.getSalt()).toHex();
		//超级用户可以直接改密码
		if(getUser().getSuperUser()==1){
			sysUserService.updatePassword(Long.parseLong(form.get("userId").toString()),form.get("password").toString(), newPassword);
		}else{
			//sha256加密
			String password = new Sha256Hash(form.get("password").toString(), userEntity.getSalt()).toHex();

			//更新密码
			boolean flag = sysUserService.updatePassword(Long.parseLong(form.get("userId").toString()),password, newPassword);
			if(!flag){
				return R.error("原密码不正确");
			}
		}


		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@GetMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.getById(userId);
		
		//获取用户所属的角色列表
		List<SysRoleEntity> roleIdList = sysUserRoleService.queryRoleList(userId);
		user.setRoleList(roleIdList);
		return R.ok().putData(user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@PostMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		user.setCreateUserId(getUserId());
		if(StringUtils.isEmpty(user.getUserId())){
			user.setState(EntityState.NEW);
			if(getUserId() != Constant.SUPER_ADMIN){
				user.setCompanyId(getCompanyId());
			}else{
				//超级用户必须挂在顶层公司下
				if(user.getSuperUser()==1){
					user.setCompanyId(user.getDeptId().intValue());
				}else {
					SysDeptEntity sysDeptEntity = sysDeptService.queryOne(user.getDeptId().intValue());
					int check = sysDeptService.tree(sysDeptEntity);
					user.setCompanyId(check);
				}
			}

		}else{
			user.setState(EntityState.MODIFIED);
			sysUserRoleService.deleteUser(user.getUserId().intValue());
		}
		sysUserService.save(user);
		SysUserEntity sysUserEntity = sysUserService.checkMobile(user.getMobile());
		if(user.getRoleIds()!=null){
			for(int i=0;i<user.getRoleIds().size();i++){
				SysUserRoleEntity userRoleEntity = new SysUserRoleEntity();
				userRoleEntity.setState(EntityState.NEW);
				if(user.getState()==EntityState.NEW){
					userRoleEntity.setUserId(sysUserEntity.getUserId());
				}else{
					userRoleEntity.setUserId(user.getUserId());
				}
				userRoleEntity.setRoleId(user.getRoleIds().get(i));
				sysUserRoleService.save(userRoleEntity);
			}
		}
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@PostMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Map<String,Object> userId){
		List<Integer> list = (List<Integer>)userId.get("data");
		for(int i=0;i<list.size();i++) {
			Long a = list.get(i).longValue();
			sysUserService.removeById(a);
		}
		return R.ok();
	}
	@PostMapping("/checkmobile")
	public R checkmobile(@RequestBody Map<String ,Object> map){
		if(map.get("userId")==null){
			SysUserEntity userEntity = sysUserService.checkMobile(map.get("mobile").toString());
			if(userEntity==null){
				return R.ok().putData("");
			}else {
				return R.ok().putData("手机号码已存在！");
			}
		}else{
			SysUserEntity userEntity = sysUserService.queryMobile(map);
			if(userEntity==null){
                SysUserEntity userEntity1 = sysUserService.checkMobile(map.get("mobile").toString());
                if(userEntity1==null){
                    return R.ok().putData("");
                }else {
                    return R.ok().putData("手机号码已存在！");
                }
			}else {
                return R.ok().putData("");
			}
		}
	}
	@PostMapping("/checkpassword")
	public R checkpassword(@RequestBody Map<String ,Object> map){
		SysUserEntity userEntity = sysUserService.queryById(Integer.parseInt(map.get("userId").toString()));
		if(getUser().getSuperUser()!=1){
			String password = new Sha256Hash(map.get("password").toString(), userEntity.getSalt()).toHex();
			map.put("password",password);
			SysUserEntity sysUserEntity1 = sysUserService.checkPassword(map);
			if(sysUserEntity1==null){
				return R.ok().putData("密码错误！");
			}else {
				return R.ok().putData("");
			}
		}
		return R.ok().putData("");

	}
	@PostMapping("/checkusername")
	public R checkUsername(@RequestBody Map<String ,Object> map){
		SysUserEntity userEntity = sysUserService.checkUsername(map.get("username").toString());
		if(userEntity==null){
			return R.ok().putData("");
		}else {
			return R.ok().putData("账号已存在！");
		}
	}

}
