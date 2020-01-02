package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mas_warehouse")
public class MasWarehouse extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private Integer virtualFlag;
  private String address;
  private String pic;
  private String mobileNo;
  private String tel;
  private Integer companyId;
  private String remark;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
