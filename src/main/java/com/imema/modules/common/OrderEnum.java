/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.common;

import org.apache.commons.lang.StringUtils;


public enum OrderEnum {

	/**
	 * 采购订单类型
	 */
	PO_RETURN("采购退货", "PO_RETURN"),PO("采购", "PO_ORDER"),
	FREIGHT("运费", "FREIGHT"),

	/**
	 * 销售订单类型
	 */
	SO_RETURN("销售退货", "SO_RETURN"),SO("销售", "SO_ORDER"),



	/**
	 * 财务付款状态
	 */
	FIN_PAID("已付款", "PAID"),FIN_UNPAID("未付款", "UNPAID"),

	/**
	 * 订单状态
	 */
	NEW("草稿", "NEW"),SUBMIT("已提交","SUBMIT"),
	SENDED("已生成拣货指令", "SENDED"), PICKUP("已扫码", "PICKUP"),
	CANCEL("已取消", "CANCEL"),COMPLETED("已完成", "COMPLETED");
	private String name;
	private String value;

	private OrderEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getvalue() {
		return value;
	}

	public void setvalue(String value) {
		this.value = value;
	}
	
	public static OrderEnum getBasicEnumByCode(String code){
	    for(OrderEnum basicEnum : OrderEnum.values()){
	      if(StringUtils.equals(code, basicEnum.getvalue())){
	        return basicEnum;
	      }
	    }
	    return null;
	  }
}
