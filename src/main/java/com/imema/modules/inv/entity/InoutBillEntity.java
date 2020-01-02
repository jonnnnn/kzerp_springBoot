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
import java.util.List;

/**
 * 出入库单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Data
@TableName("inv_inout_bill")
public class InoutBillEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 单号规则
	 */
	@TableField(exist = false)
	private static final String BILL_CODE="INV_INOUT_BILL";
	@TableField(exist = false)
	private static final String BILL_COLUMN="billNum";
	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 业务单号
	 */
	private String billNum;
	/**
	 * 业务类型
	 */
	@LookUpType("TRAN_TYPE")
	private String transactionType;
	/**
	 * 上游业务单据类型
	 */
	@LookUpType(value = "SOURCE_ORDER_TYPE")
	private String sourceOrderType;
	/**
	 * 上游业务单id
	 */
	private Integer sourceOrderId;
	/**
	 * 上游业务单号
	 */
	private String sourceOrderNum;
	/**
	 * 经办人
	 */
	private String pic;
	/**
	 * 出入库日期
	 */
	private Date inDate;
	/**
	 * 状态
	 */
	@LookUpType(value = "STATUS")
	private String status;
	/**
	 * 出入库仓库id
	 */
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
	 * 出入库明细
	 */
	@TableField(exist=false)
	private List<InoutBillLineEntity> lineList;

}
