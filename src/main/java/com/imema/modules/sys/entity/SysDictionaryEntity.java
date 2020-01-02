package com.imema.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_dictionary")
public class SysDictionaryEntity extends AbstractBaseModel implements Serializable {

  private Integer id;
  private String code;
  private String name;
  private String remark;
  private Integer addFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

}
