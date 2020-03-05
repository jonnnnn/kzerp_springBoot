package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mtl_product")
public class MtlProduct extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String prodid;
  private String prodno;
  private String name;
  private String manufacture;
  private String approvalno;
  private Integer bigpackagequantity;
  private Integer midpackagequantity;
  private String busitypetext;
  private String purchaser;
  private String purchaseid;
  private String specialParam;
  private String description;
  private String unit;
  private String prodscopeno;
  private String sterilization;
  private Integer defaultVendorId;
  private Integer status;
  private String pinyinCode;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

  @TableField(exist = false)
  private String allString;

}
