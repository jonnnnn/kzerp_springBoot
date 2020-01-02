package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("mtl_product_price")
@Data
public class MtlProductPrice extends AbstractBaseModel implements Serializable {

  private Integer id;
  private Integer productId;
  private BigDecimal salePrice;
  private BigDecimal costPrice;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
