package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mtl_product")
public class MtlProduct extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private String alisaName;
  private Integer categoryId;
  private Integer vehicleId;
  private Integer brandId;
  private Integer madeinId;
  private String barCode;
  private String picCode;
  private String specialParam;
  private String description;
  private String unit;
  private String volume;
  private String weight;
  private Integer defaultVendorId;
  private Integer status;
  private String pinyinCode;
  private String wbCode;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;
  private Integer safeQty;
}
