/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.data.AbstractBaseModel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.imema.data.LookUpType;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import lombok.Data;

/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
@Data
@TableName("fin_real_payrec")
public class RealPayrecEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 往来单位id
	 */
	private Integer custId;
	/**
	 * 往来单位名称
	 */
	@TableField(exist = false)
	private String custName;
	/**
	 * 收付款日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date payDate;
	/**
	 * 收付款类型（预收客户款、预付供应商款、核销预收客户款、核销预付供应商款、采购订单、销售退货、其他等）
	 */
	private String summary;
	/**
	 * 收付款金额
	 */
	private BigDecimal amount;
	/**
	 * 状态
	 */
	/**
	 * 上游业务单据类型
	 */
	@LookUpType(value = "STATUS")
	private String status;
	/**
	 * 收付款负责人
	 */
	private String pic;
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
	 * 应付单行
	 */
	@TableField(exist=false)
	private List<RealPayrecOrdEntity> lineList;
}
