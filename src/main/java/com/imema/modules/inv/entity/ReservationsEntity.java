/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 物料保留
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_reservations")
public class ReservationsEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 保留id
	 */
	@TableId
	private Integer reservationId;
	/**
	 * 需求日期
	 */
	private Date requirementDate;
	/**
	 * 公司编号
	 */
	private Integer companyId;
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 仓库id
	 */
	private Integer warehouseId;
	/**
	 * 保留类型
	 */
	private String tranType;
	/**
	 * 需求来源单头id（比如需求来源名称为销售订单，则表示销售订单id）
	 */
	private Integer demandSourceHeaderId;
	/**
	 * 需求来源行id
	 */
	private Integer demandSourceLineId;
	/**
	 * 保留量计量单位（比如：千克）
	 */
	private String reservationUomCode;
	/**
	 * 保留数量
	 */
	private Integer reservationQuantity;
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

}
