/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
@Data
@TableName("fin_real_payrec_dtl")
public class RealPayrecDtlEntity extends AbstractBaseModel implements Serializable {
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
	 * 收款账号ID
	 */
	private Integer gatheringType;

	/**
	 * 收付款金额
	 */
	private BigDecimal amount;

	/**
	 * 删除标记
	 */
	private String deletedFlag;


	/**
	 * 核销状态,1 表示已全部核销 2 表示部分核销
	 */
	private Integer applyFlag;

	/**
	 * '已核销金额'
	 */
	private BigDecimal applyAmount;

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
