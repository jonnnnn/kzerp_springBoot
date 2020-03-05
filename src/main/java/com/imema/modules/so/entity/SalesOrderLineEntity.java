/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.common.validator.group.AddGroup;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.data.AbstractBaseModel;
import com.imema.modules.base.entity.MtlProduct;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售订单明细
 * 
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@Data
@TableName("sal_sales_order_line")
public class SalesOrderLineEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 销售单id
	 */
	@NotNull(message="订单保存异常", groups = {AddGroup.class, UpdateGroup.class})
	private Integer orderId;
	/**
	 * 商品id
	 */
	@NotNull(message="订单行物料不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer productId;
	/**
	 * 下单数
	 */
	@NotNull(message="订单行下单数量不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer orderQty;
	/**
	 * 实际交货数
	 */
	private Integer realQty;
	/**
	 * 销售价
	 */
	@NotNull(message="订单行销售价不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private BigDecimal price;
	/**
	 * 当前成本价
	 */
	private BigDecimal costPrice;
	/**
	 * 行汇总金额
	 */
	private BigDecimal amount;
	/**
	 * 税率
	 */
	private BigDecimal taxRate;
	/**
	 * 备注
	 */
	private String remark;
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

	private String note;

}
