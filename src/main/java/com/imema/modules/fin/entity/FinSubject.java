package com.imema.modules.fin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imema.data.AbstractBaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("fin_subject")
public class FinSubject extends AbstractBaseModel implements Serializable {

  private Integer id;
  private Integer parentId;
  private Integer companyId;
  private String code;
  private String name;
  private Integer subjectType;
  private Integer category;
  private Integer subjectLevel;
  private Integer direction;
  private String remark;
  private String createBy;
  private Date createDate;
  private String updateBy;
  private Date updateDate;

  @TableField(exist = false)
  private String pname;
  @TableField(exist = false)
  private List<FinSubject> children;

}
