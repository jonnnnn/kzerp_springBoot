/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import com.imema.data.LookUpType;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 应收应付单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:38
 */
@Data
@TableName("fin_payrec")
public class PayrecEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 应收/应付款
	 */
	private String type;
	/**
	 * 应收/应付款名称
	 */
	@TableField(exist = false)
	private PayRecType typeName;
	/**
	 * 关联业务类型
	 */
	/**
	 * 上游业务单据类型
	 */
	@LookUpType(value = "SOURCE_ORDER_TYPE")
	private String sourceOrderType;
	/**
	 * 来源订单ID
	 */
	private Integer sourceOrderId;

	/**
	 * 来源拣货ID
	 */
	private Integer sourcePickId;


	/**
	 * 来源订单号
	 */
	private String sourceOrderNum;
	/**
	 * 往来单位
	 */
	private Integer custId;
	/**
	 * 往来单位
	 */
	private String custName;
	/**
	 * 科目
	 */
	private Integer subjectId;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 应收付款创建日期
	 */
	private Date orderDate;
	/**
	 * 经办人
	 */
	private String pic;
	/**
	 * 付款状态
	 */
	@LookUpType(value = "PAY_TYPE")
	private String status;
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

	enum PayRecType {
		RECEIVABLE("应收款"), PAYABLE("应付款");

		private String type;

		PayRecType(String type) {
			this.type = type;
		}

		public static PayRecType getPayRecTypeByCode(String code){
			for(PayRecType payRecType : PayRecType.values()){
				if(StringUtils.equals(code, payRecType.name())){
					return payRecType;
				}
			}
			return null;
		}
	}

	PayRecType getTypeName() {
		return PayRecType.getPayRecTypeByCode(this.type);
	}

	void setTypeName(PayRecType type) {
		this.typeName = type;
	}

}
