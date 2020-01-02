package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("inv_reservations")
public class InvReservations extends AbstractBaseModel implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer reservationId;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Date requirementDate;

  private Integer companyId;
  private Integer productId;
  private Integer warehouseId;
  private String tranType;
  private Integer demandSourceHeaderId;
  private Integer demandSourceLineId;
  private String reservationUomCode;
  private Integer reservationQuantity;
  private String remark;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
