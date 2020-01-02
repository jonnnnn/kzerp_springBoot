package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("inv_transactions")
public class InvTransactions extends AbstractBaseModel implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer transactionId;
  private Integer companyId;
  private Integer warehouseId;
  private Integer productId;
  private String actualLocator;
  private Integer sourceId;
  private String sourceCode;
  private Integer sourceLineId;
  private String transactionReference;
  private BigDecimal transactionQuantity;
  private String transactionUom;
  private BigDecimal salePrice;
  private BigDecimal costPrice;
  private Date transactionDate;
  private String tranType;
  private BigDecimal priorQuantity;
  private BigDecimal balanceQuantity;
  private BigDecimal priorCost;
  private BigDecimal newCost;
  private Date transactionCostedDate;
  private String employeeCode;
  private String remark;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
