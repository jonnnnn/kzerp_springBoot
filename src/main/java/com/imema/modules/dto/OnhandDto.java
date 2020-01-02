/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.dto;

import lombok.Data;

import java.util.List;



/**
 * 现有量DTO
 */
@Data
public class OnhandDto implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//公司ID
	private Integer companyId;
	//操作员工
	private String userName;
	//来源订单ID
	private Integer sourceHeaderId;
	//保留类型
	private String tranType;
	//保留明细
	private List<OnhandLineDto>onhandLineDtos;
}
