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
 * 盘点单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Data
@TableName("inv_check_bill_line")
public class CheckBillLineEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 盘点单id
	 */
	private Integer checkBillId;
	/**
	 * 货位id
	 */
	private Integer warehouseSlotId;
	/**
	 * 商品id
	 */
	private Integer productId;
	/**
	 * 单位
	 */
	private String uom;
	/**
	 * 帐面数量
	 */
	private Integer quantityOld;
	/**
	 * 盘点数量
	 */
	private Integer quantityNew;
	/**
	 * 差异数
	 */
	private Integer orderQty;
	/**
	 * 差异原因
	 */
	private String diffCause;
	/**
	 * 解决方案
	 */
	private String solution;
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
