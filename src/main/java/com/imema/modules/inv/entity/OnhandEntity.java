/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 现有量
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_onhand")
public class OnhandEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 仓库id
	 */
	private Integer warehouseId;
	/**
	 * 单位
	 */
	private String uom;
	/**
	 * 库存现有量
	 */
	private Integer inventoryQuantity;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 公司
	 */
	private Integer companyId;
	/**
	 * 删除标记
	 */
	private String deletedFlag;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改日期
	 */
	private Date updateDate;
/*	*//**
	 * 公司名称
	 *//*
	@TableField(exist=false)
	private String companyname;
	*//**
	 * 仓库
	 *//*
	@TableField(exist=false)
	private String warehousecode;
	*//**
	 * 物料编码
	 *//*
	@TableField(exist=false)
	private String productcode;*/
}
