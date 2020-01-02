/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import com.imema.data.LookUpType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 出入库单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_inout_bill_line")
public class InoutBillLineEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 出入库单id
	 */
	private Integer billId;
	/**
	 * 上游业务单行id
	 */
	private Integer sourceOrderLineId;
	/**
	 * 货位
	 */
	private String warehouseSlotId;
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 单位
	 */
	private String uom;
	/**
	 * 目标出入库数量(正数表示入库,负数为出)
	 */
	private Integer qty;
	/**
	 * 实际出入库数量
	 */
	private Integer realQty;
	/**
	 * 销售价
	 */
	private BigDecimal salePrice;
	/**
	 * 成本价
	 */
	private BigDecimal costPrice;
	/**
	 * 状态
	 */
	@LookUpType(value = "STATUS")
	private String status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记
	 */
	private String deletedFlag;
	/**
	 * 运费
	 */
	private BigDecimal freight;
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
	 * 时间戳
	 */
	private Date ts;
	/**
	 * 前期成本
	 */
	@TableField(exist=false)
	private BigDecimal priorCost;
	/**
	 * 最新成本
	 */
	@TableField(exist=false)
	private BigDecimal newCost;
	/**
	 * 前期数量
	 */
	@TableField(exist=false)
	private Integer priorQuantity;
	/**
	 * 结余数量
	 */
	@TableField(exist=false)
	private Integer balanceQuantity;

}
