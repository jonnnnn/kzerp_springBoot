/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imema.common.exception.RRException;
import com.imema.common.utils.Constant;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.sys.dao.SysUserDao;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.entity.SysUserEntity;
import com.imema.modules.sys.service.SysRoleService;
import com.imema.modules.sys.service.SysUserRoleService;
import com.imema.modules.sys.service.SysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;


	@Override
	public List<String> queryAllPerms(Long userId) {
		return baseMapper.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

	@Override
	public IPage<SysUserEntity> pageByUserName(String username) {
		Page<SysUserEntity> page = new Page();
		return baseMapper.pageUserName(page, username);
	}

	@Override
	@Transactional
	public void saveUser(SysUserEntity user) {
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		user.setSalt(salt);
		this.save(user);
		
		//检查角色是否越权
		checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleList());
	}

	@Override
	@Transactional
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
		}
		this.updateById(user);
		
		//检查角色是否越权
		checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleList());
	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.removeByIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserEntity userEntity = new SysUserEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new QueryWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
	}

	@Override
	public SysUserEntity queryById(int userId) {
		return baseMapper.queryById(userId);
	}

	@Override
	public SysUserEntity checkMobile(String mobile) {
		return baseMapper.queryId(mobile);
	}

	@Override
	public SysUserEntity queryMobile(Map<String ,Object> map) {
		return baseMapper.queryMobile(map);
	}

	@Override
	public SysUserEntity checkPassword(Map<String, Object> map) {
		return baseMapper.checkPassword(map);
	}

	@Override
	public SysUserEntity checkUsername(String username) {
		return baseMapper.queryUsername(username);
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(SysUserEntity user){
		if(user.getRoleList() == null || user.getRoleList().size() == 0){
			return;
		}
		//如果不是超级管理员，则需要判断用户的角色是否自己创建
		if(user.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}
		
		//查询用户创建的角色列表
		List<SysRoleEntity> roleIdList = sysRoleService.queryRoleList(user.getCreateUserId());

		//判断是否越权
		if(!roleIdList.containsAll(user.getRoleList())){
			throw new RRException("新增用户所选角色，不是本人创建");
		}
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Map<String,Object> pageForm = (Map<String, Object>) params.get("pageForm");
		Map<String,Object> dataForm = (Map<String, Object>) params.get("dataForm");
		Map<String,Object> selectForm = (Map<String, Object>) dataForm.get("data");
		IPage<SysUserEntity> page = baseMapper.orderList(new Query<SysUserEntity>().getPage(pageForm),selectForm);
		return new PageUtils(page);
	}
}