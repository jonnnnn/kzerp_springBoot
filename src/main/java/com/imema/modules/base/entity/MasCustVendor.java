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
  private String code;
  private String name;
  private String shortName;
  private Integer type;
  private String tel;
  private String fax;
  private String email;
  private String mm;
  private String companyAddress;
  private String legalMan;
  private String webSite;
  private String bank;
  private String bankAccount;
  private String taxNum;
  private String pinyinCode;
  private String wbCode;
  private String pic;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;
}
