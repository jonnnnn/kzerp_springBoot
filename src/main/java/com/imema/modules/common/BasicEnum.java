/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.common;

import org.apache.commons.lang.StringUtils;


public enum BasicEnum {

	/**
	 * 事物类型
	 */
	SO_OUT("销售出库", "SO_OUT","SO_ORDER"), SO_RETURN_IN("销售退货入库", "SO_RETURN_IN","SO_RETURN"),
	PO_RETURN_OUT("采购退货出库", "PO_RETURN_OUT","PO_RETURN"),PO_IN("采购入库", "PO_IN","PO_ORDER"),
	DB_OUT("调拨出库", "DB_OUT","DB_ORDER"),DB_IN("调拨入库", "DB_IN","DB_ORDER"),
	PD_ORDER("盘点出入库", "PD_ORDER","PD_ORDER"),
	OTHER_OUT("其他出库", "OTHER_OUT","OTHER_ORDER"),OTHER_IN("其他入库", "OTHER_IN","OTHER_ORDER"),

	/**
	 * 标准下拉框类型
	 */
	employee("员工下拉框","employee","select code as `value`, cname as `key` from mas_employee e where e.cname like '%#query#%'"),
	customer("客户下拉框","customer","select id as `value`, name as `key` from mas_cust_vendor e where e.name like '%#query#%'"),
	vendor("供应商下拉框","vendor","select id as `value`, name as `key` from mas_cust_vendor e where e.cust_vendor='VENDOR' and e.name like '%#query#%'"),
	shipComp("物流下拉框","shipComp","select id as `value`, name as `key` from mas_cust_vendor e where e.cust_vendor='SUP' and e.name like '%#query#%'"),
	customervendor("客户和供应商下拉框","customervendor","select id as `value`, name as `key` from mas_cust_vendor e where e.name like '%#query#%'"),
	warehouse("仓库下拉框","warehouse","select id as `value`, code as `key` from mas_warehouse e where e.code like '%#query#%'"),
	product("物料下拉框","product","select id as `value`, name as `key` from mtl_product e where e.name like '%#query#%'"),
	priceproduct("价格物料下拉框","priceproduct","select id as `value`, code as `key` from mtl_product e where" +
			" e.id not in (select PRODUCT_ID from mtl_product_price) and e.code like '%#query#%'"),
	productbrand("物料品牌","pbrand","select id as `value`, name as `key` from mtl_product_brand e where e.name like '%#query#%'"),
	productcategory("物料分类","pcategory","select id as `value`, name as `key` from mtl_product_category mpc" +
			" where mpc.id not in (select parent_id from mtl_product_category) and mpc.name like '%#query#%' and mpc.id not" +
			" in (select name from mtl_product)"),
	productcategoryall("物料所有分类","productcategoryall","select code as `value`, name as `key` from mtl_product_category e where" +
			" e.name like '%#query#%'"),
	productmadein("物料产地","pmadein","select id as `value`, name as `key` from mtl_product_madein e where e.name like '%#query#%'"),
	productvehicle("物料车型","pvehicle","select id as `value`, name as `key` from mtl_product_vehicle e where e.name like '%#query#%'"),
	customersearch("往来单位","customersearch","select m.id as `value`,m.name as `key`,m.* from mas_cust_vendor m where 1=1 and" +
			" (m.id like '%#query#%' or m.name like '%#query#%')"),
	dict("系统字典","dict","select id as `value`,name as `key` from sys_dictionary sd where sd.add_flag=1 and sd.name like '%#query#%'"),
	dictItem("字典细则","dictItem",""),
    custType("客户类型","custType","select si.code as `value`,si.name as `key` from sys_dictionary_item si left" +
            " join sys_dictionary s on si.DICTIONARY_ID=s.id where s.code='CUST_TYPE' and si.extend_val='CUST' and si.name like '%#query#%'"),
    vendorType("供应商类型","vendorType","select si.code as `value`,si.name as `key` from sys_dictionary_item si" +
            " left join sys_dictionary s on si.DICTIONARY_ID=s.id where s.code='CUST_TYPE' and si.extend_val='VENDOR' and si.name like '%#query#%'"),
    ivType("票据类型","ivType","select si.code as `value`, si.name as `key` from sys_dictionary_item si left join" +
            " sys_dictionary s on si.DICTIONARY_ID=s.id where s.code='invoice_type' and si.name like '%#query#%'"),
    subjectCat("科目类型","subjectCat","select si.code as `value`, si.name as `key` from sys_dictionary_item si" +
            " left join sys_dictionary s on si.DICTIONARY_ID=s.id where s.code='SUBJECT_CAT' and si.name like '%#query#%'"),
	supType("物流公司","supType","select si.code as `value`,si.name as `key` from sys_dictionary_item si left join" +
			" sys_dictionary s on si.DICTIONARY_ID=s.id where s.code='SUP_TYPE' and si.extend_val='SUP' and si.name like '%#query#%'"),
	gatheringType("财务账号","gatheringType","select id as `value`,name as `key` from fin_account where COMPANY_ID='1' and DELETED_FLAG = 'N' "),

	/**
	 * 业务下拉框
	 */
	SHIP_TYPE("发运方式", "SHIP_TYPE","DICT"),
	GATHERING_TYPE("收付款类型", "GATHERING_TYPE","DICT"),




	DATA_STATUS_INSERT("新增", "INSERT",""), DATA_STATUS_UPDATE("修改", "UPDATE",""),
	DATA_STATUS_DELETE("删除", "DELETE","");
	private String name;
	private String value;
	private String attr;

	BasicEnum(String name, String value, String attr) {
		this.name = name;
		this.value = value;
		this.attr = attr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public static BasicEnum getBasicEnumByCode(String code){
	    for(BasicEnum basicEnum : BasicEnum.values()){
	      if(StringUtils.equals(code, basicEnum.getValue())){
	        return basicEnum;
	      }
	    }
	    return null;
	  }
	public static String getInOrOut(String code){
		return code.substring(code.lastIndexOf('_')+1,code.length());
	}
}
