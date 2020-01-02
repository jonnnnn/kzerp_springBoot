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
 * 调拨单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Data
@TableName("inv_transfer_bill_line")
public class TransferBillLineEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 调拨单id
	 */
	private Integer transferBillId;
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 单位
	 */
	private String uom;
	/**
	 * 调拨数量
	 */
	private Integer orderQty;
	/**
	 * 备注
	 */
	private String remark;
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
