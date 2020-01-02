/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.data.AbstractBaseModel;
import com.imema.data.LookUpType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 采购单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@Data
@TableName("pur_po_header")
public class PoHeaderEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 订单类型(采购/采购退货)
	 */
	private String orderType;
	/**
	 * 采购订单号
	 */
	private String orderNum;
	/**
	 * 供应商ID
	 */
	private Integer vendorId;
	/**
	 * 供应商联系人
	 */
	private String contactName;
	/**
	 * 供应商联系电话
	 */
	private String contactPhone;
	/**
	 * 采购日期
	 */
	private Date orderDate;
	/**
	 * 采购主题
	 */
	private String topic;
	/**
	 * 采购员
	 */
	private String agentId;
	/**
	 * 计划交货期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date planDeliveryDate;
	/**
	 * 状态
	 */
	@LookUpType(value = "STATUS")
	private String status;
	/**
	 * 采购总金额
	 */
	private BigDecimal orderAmount;
	/**
	 * 公司
	 */
	private Integer companyId;
	/**
	 * 仓库
	 */
	private Integer warehouseId;
	/**
	 * 付款方式
	 */
	private String payType;
	/**
	 * 发运方式
	 */
	private String shipType;
	/**
	 * 发运公司
	 */
	private Integer shipId;
	/**
	 * 发运单号
	 */
	private String shipNum;
	/**
	 * 累计运费
	 */
	private BigDecimal totalFreight=BigDecimal.ZERO;
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
	 * 采购明细
	 */
	@TableField(exist=false)
	private List<PoLineEntity> lineList;

}
