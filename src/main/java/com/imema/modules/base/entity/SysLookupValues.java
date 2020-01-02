package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_lookup_values")
public class SysLookupValues extends AbstractBaseModel implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId
  private Integer id;
  private String lookupType;
  private String lookupTypeTag;
  private String lookupCode;
  private String meaning;
  private String description;
  private String enabledFlag;
  private Integer seqNum;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private Integer editFlag;
  private Integer deleteFlag;
  private Integer companyId;
  private Date lastUpdateDate;
  private String lastUpdatedBy;
  private Date creationDate;
  private String createdBy;
}
