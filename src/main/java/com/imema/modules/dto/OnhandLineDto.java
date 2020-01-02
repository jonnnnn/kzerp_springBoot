/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.dto;

import lombok.Data;



/**
 * 现有量DTO
 */
@Data
public class OnhandLineDto implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//仓库ID
	private Integer warehouseId;
	//物料ID
	private Integer productId;
	//保留数量
	private Integer scanedQty;
	//单位
	private String uomCode;
	//来源订单行
	private Integer sourceLineId;
}
