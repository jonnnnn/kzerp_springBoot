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
 * 调拨单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_transfer_bill")
public class TransferBillEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 单号规则
	 */
	@TableField(exist = false)
	private static final String BILL_CODE="INV_TRANSFER_BILL";
	@TableField(exist = false)
	private static final String BILL_COLUMN="orderNum";
	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 调拨单号
	 */
	private String orderNum;
	/**
	 * 调拨主题
	 */
	private String topic;
	/**
	 * 调出仓id
	 */
	private Integer fromWarehouseId;
	/**
	 * 调入仓id
	 */
	private Integer toWarehouseId;
	/**
	 * 调拨日期
	 */
	private Date transferDate;
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
	 * 执行出库人
	 */
	private String outBy;
	/**
	 * 执行出库时间
	 */
	private Date outDate;
	/**
	 * 执行入库人
	 */
	private String inBy;
	/**
	 * 执行入库时间
	 */
	private Date inDate;
	/**
	 * 调出公司
	 */
	private Integer outCompanyId;
	/**
	 * 调入公司
	 */
	private Integer inCompanyId;
	/**
	 * 备注
	 */
	private String remark;
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
	 * 调拨明细
	 */
	@TableField(exist = false)
	private List<TransferBillLineEntity> lineList;
}
