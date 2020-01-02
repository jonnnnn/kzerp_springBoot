package com.imema.modules.fin.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("fin_invoice")
public class FinInvoice  extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private String customerName;
  private Integer customerId;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Date ivDate;
  private BigDecimal amount;
  private String summary;
  private Integer ivType;
  private String cpName;
  private String taxNum;
  private String cpAddress;
  private String cpPhone;
  private String cpBank;
  private String cpBankNum;
  private Integer status;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
