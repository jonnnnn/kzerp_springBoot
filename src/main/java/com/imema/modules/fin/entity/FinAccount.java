package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
* 银行账户
* @author Mr Lee
* */
@Data
@TableName("fin_account")
public class FinAccount extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String name;
  private String bankName;
  private String bankNum;
  private BigDecimal initBalance;
  private BigDecimal balance;
  private Integer status;
  private String remark;
  private Integer companyId;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
