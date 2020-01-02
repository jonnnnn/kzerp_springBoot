/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.common.validator.group.AddGroup;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.data.AbstractBaseModel;
import com.imema.data.LookUpType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 销售订单
 * 
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@Data
@TableName("sal_sales_order")
public class SalesOrderEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 单号规则
	 */
	@TableField(exist = false)
	private static final String BILL_CODE="SAL_SALES_ORDER";
	@TableField(exist = false)
	private static final String BILL_COLUMN="orderNum";

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 订单类型(销售/退货/报价)
	 */
	private String orderType;
	/**
	 * 订单号
	 */
	private String orderNum;

	/**
	 * 客户名称
	 */
	@TableField(exist=false)
	@ApiModelProperty(value = "客户名称")
	private String customerName;




	/**
	 * 客户id
	 */
	@NotNull(message="客户不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer customerId;


	/**
	 * 销售日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	/**
	 * 业务员id
	 */
	private String pic;
	/**
	 * 要求交货期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date planDeliveryDate;
	/**
	 * 单据状态
	 */
	@LookUpType(value = "ORDER_STATUS")
	private String status;
	/**
	 * 订单金额
	 */
	@NotNull(message="订单金额不能为空", groups = {UpdateGroup.class})
	private BigDecimal orderAmount;

	/**
	 * 发运方式
	 */
	@LookUpType(value = "SHIP_TYPE" ,type = "DICT")
	private String shipType;
	/**
	 * 收货地址
	 */
	private String receiveAddress;
	/**
	 * 收货人
	 */
	private String receiveName;
	/**
	 * 收货人电话
	 */
	private String receivePhone;


	private boolean autoPeaking;

	/**
	 * 仓库ID,特殊备用
	 */
	@TableField(exist=false)
	private Integer warehouseId;

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

	/**
	 * 订单行
	 */
	@TableField(exist=false)
	private List<SalesOrderLineEntity> lineList;

}
