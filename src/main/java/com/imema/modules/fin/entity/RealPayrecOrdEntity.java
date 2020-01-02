/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
@Data
@TableName("fin_real_payrec_ord")
public class RealPayrecOrdEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 收款id
	 */
	private Integer gatheringId;
	/**
	 * 应收应付ID
	 */
	private Integer payrecId;
	/**
	 * 业务单号
	 */
	private String orderNum;

	/**
	 * 收付款金额
	 */
	private BigDecimal gatheringAmount;

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
