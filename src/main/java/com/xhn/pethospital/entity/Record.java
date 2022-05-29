package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("record")
//病例
public class Record {
    @TableField(value = "rId")
    @TableId(value = "rId",type = IdType.AUTO)
    //主键
    private Integer rId;
    //宠物名称
    @TableField(value = "pName")
    private Integer pName;
    //医生名称
    @TableField(value = "dName")
    private Integer dName;
    //关联的挂号id
    @TableField(value = "aId")
    private Integer aId;
    //被创建时间
    @TableField(value = "preCreatetime")
    private Date preCreatetime;
    //病例内容
    @TableField(value = "rContent")
    private String rContent;
}
