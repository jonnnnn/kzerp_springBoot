package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mtl_product_madein")
public class MtlProductMadein extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private String pinyinCode;
  private String wbCode;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
