package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("sys_billnum_rule_type")
@Data
public class SysBillnumRuleType  extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private String prefix;
  private String prefixSeprator;
  private Integer yearFlag;
  private Integer yLength;
  private Integer monthFlag;
  private Integer dayFlag;
  private Integer sequenceLength;
  private String loopType;
  private String suffixSeprator;
  private String suffix;
  private String remark;
  private Integer year;
  private Integer month;
  private Integer day;
  private Integer sequenceNum;
  private String enabledFlag;
  private String deletedFlag;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Date startDateActive;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Date endDateActive;
  private Date lastUpdateDate;
  private String lastUpdatedBy;
  private Date creationDate;
  private String createdBy;

}
