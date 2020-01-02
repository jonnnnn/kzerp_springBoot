/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.common.validator.group.AddGroup;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_user")
public class SysUserEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;

	/**
	 * 用户账号
	 */
	@NotBlank(message="用户账号不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String username;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	@NotBlank(message="密码不能为空", groups = AddGroup.class)
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	@NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	/**
	 * 超级用户  0：否   1：是
	 */
	private Integer superUser;

	/**
	 * 角色列表
	 */
	@TableField(exist=false)
	private List<SysRoleEntity> roleList;

	/**
	 * 创建者ID
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 部门ID
	 */
	@NotNull(message="部门不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long deptId;

	/**
	 * 公司ID
	 */
	private Integer companyId;


	/**
	 * 部门
	 */
	@TableField(exist=false)
	private SysDeptEntity dept;

	@TableField(exist=false)
	private String deptName;

	@TableField(exist=false)
	private String companyName;

	@TableField(exist=false)
	private List<Long> roleIds;

}
