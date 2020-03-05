package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mas_cust_vendor")
public class MasCustVendor extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String custVendor;
  private String custid;
  private String custno;
  private String custname;
  private String custidentify;
  private String contactperson;
  private String contactphone;
  private String custadd;
  private String custtype;
  private Integer relation;
  private Integer isActive;
  private String businessscopecode;
  private String ownerareatext;
  private String purchaser;
  private String businessman;
  private String mainopname;
  private String pinyinCode;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;
}
