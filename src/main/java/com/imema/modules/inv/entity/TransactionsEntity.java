/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import com.imema.data.LookUpType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物料事务
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_transactions")
public class TransactionsEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 事务id
	 */
	@TableId
	private Integer transactionId;
	/**
	 * 物料id
	 */
	private Integer productId;
	/**
	 * 仓库库
	 */
	private Integer warehouseId;
	/**
	 * 实物货位
	 */
	private String actualLocator;
	/**
	 * 事务来源id
	 */
	private Integer sourceId;
	/**
	 * 来源单据编号
	 */
	private String sourceCode;
	/**
	 * 事务来源行id
	 */
	private Integer sourceLineId;
	/**
	 * 来源业务单号，比如销售订单号
	 */
	private String transactionReference;
	/**
	 * 事务数量
	 */
	private Integer transactionQuantity;
	/**
	 * 计量单位
	 */
	private String transactionUom;
	/**
	 * 销售价
	 */
	private BigDecimal salePrice;
	/**
	 * 含税成本单价
	 */
	private BigDecimal costPrice;
	/**
	 * 事务日期
	 */
	private Date transactionDate;
	/**
	 * 事物类型
	 */
	@LookUpType(value = "TRAN_TYPE")
	private String tranType;
	/**
	 * 前期数量
	 */
	private Integer priorQuantity;
	/**
	 * 结余数量
	 */
	private Integer balanceQuantity;
	/**
	 * 前期成本
	 */
	private BigDecimal priorCost;
	/**
	 * 最新成本
	 */
	private BigDecimal newCost;
	/**
	 * 成本计算日期
	 */
	private Date transactionCostedDate;
	/**
	 * 事务执行人（保存仓管员员工code）
	 */
	private String employeeCode;
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

}
