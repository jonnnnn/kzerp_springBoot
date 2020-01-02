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
import java.util.Date;
import java.util.List;

/**
 * 盘点单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Data
@TableName("inv_check_bill")
public class CheckBillEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 单号规则
	 */
	@TableField(exist = false)
	private static final String BILL_CODE="INV_CHECK_BILL";
	@TableField(exist = false)
	private static final String BILL_COLUMN="orderNum";
	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 盘点单号
	 */
	private String orderNum;
	/**
	 * 盘点主题
	 */
	private String topic;
	/**
	 * 盘点仓id
	 */
	private Integer warehouseId;
	/**
	 * 盘点日期
	 */
	private Date checkDate;
	/**
	 * 负责人
	 */
	private String pic;
	/**
	 * 状态
	 */
	@LookUpType(value = "STATUS")
	private String status;
	/**
	 * 审批状态
	 */
	private String wfStatus;
	/**
	 * 审批意见
	 */
	private String wfOpinion;
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
	 * 盘点明细
	 */
	@TableField(exist = false)
	private List<CheckBillLineEntity> lineList;
}
