package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mas_warehouse_slot")
public class MasWarehouseSlot extends AbstractBaseModel implements Serializable {

  private Integer id;
  private Integer productId;
  private Integer warehouseId;
  private String name;
  private String remark;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;
  private Integer companyId;

}
