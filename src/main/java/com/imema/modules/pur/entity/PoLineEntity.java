/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 进货单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@Data
@TableName("pur_po_line")
public class PoLineEntity extends AbstractBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 订单id
	 */
	private Integer orderId;
	/**
	 * 商品id
	 */
	private Integer productId;
	/**
	 * 单位
	 */
	private String uom;
	/**
	 * 下单数
	 */
	private Integer orderQty;
	/**
	 * 实际收货数
	 */
	private Integer realQty;
	/**
	 * 累计接收数
	 */
	private int totalAcceptQty=0;
	/**
	 * 累计运费
	 */
	private BigDecimal totalFreight=BigDecimal.ZERO;
	/**
	 * 采购价
	 */
	private BigDecimal costPrice;
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
