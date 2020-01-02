package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mas_cust_vendor_contact")
public class MasCustVendorContact extends AbstractBaseModel implements Serializable {

  private Integer id;
  private Integer custId;
  private String name;
  private String shortName;
  private String linkman;
  private String mobileNo;
  private String tel;
  private String weixinNo;
  private String email;
  private String remark;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
