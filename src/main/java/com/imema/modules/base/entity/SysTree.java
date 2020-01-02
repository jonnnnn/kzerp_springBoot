package com.imema.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("sys_tree")
public class SysTree extends AbstractBaseModel implements Serializable {

  private Integer id;
  private Integer parentId;
  private String type;
  private String code;
  private String name;
  private Integer orderNum;
  private Integer sys;
  private Integer companyId;
  private String remark;
  private String attr1;
  private String attr2;
  private String attr3;
  private String attr4;
  private String attr5;
  private String deletedFlag;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

  @TableField(exist = false)
  private String pname;
  @TableField(exist = false)
  private List<SysTree> children;

}
