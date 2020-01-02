/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.exception.RRException;
import com.imema.common.utils.Constant;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.sys.dao.SysRoleDao;
import com.imema.modules.sys.entity.SysDeptEntity;
import com.imema.modules.sys.entity.SysRoleEntity;
import com.imema.modules.sys.service.SysRoleMenuService;
import com.imema.modules.sys.service.SysRoleService;
import com.imema.modules.sys.service.SysUserRoleService;
import com.imema.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRoleEntity role) {
        role.setCreateTime(new Date());
        this.save(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        this.updateById(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.removeByIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


    @Override
	public List<SysRoleEntity> queryRoleList(Long createUserId) {
		return baseMapper.queryRoleList(createUserId);
	}

    @Override
    public List<SysRoleEntity> queryRoleNameList(Long userId) {
        return baseMapper.queryRoleNameList(userId);
    }

    @Override
    public List<SysRoleEntity> queryRoleId(Map parmes) {
        return baseMapper.queryRoleId(parmes);
    }

    /**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRoleEntity role){
		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(role.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}
		
		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());
		
		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new RRException("新增角色的权限，已超出你的权限范围");
		}
	}
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String,Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String,Object> dataForm = (Map<String, Object>) params.get("dataForm");
        Map<String,Object> selectForm = (Map<String, Object>) dataForm.get("data");
        IPage<SysRoleEntity> page = baseMapper.orderList(new Query<SysRoleEntity>().getPage(pageForm),selectForm);
        return new PageUtils(page);
    }
}
