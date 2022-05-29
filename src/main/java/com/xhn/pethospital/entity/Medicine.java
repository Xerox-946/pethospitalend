package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("medicine")
//药品表
public class Medicine {
    @TableField(value = "mId")
    @TableId(value = "mId",type = IdType.AUTO)
    //主键
    private Integer mId;
    //药名
    @TableField(value = "mName")
    private String mName;
    //用法
    @TableField(value = "mUsage")
    private String mUsage;
    //剂量
    @TableField(value = "mDosage")
    private String mDosage;
    //功能描述
    @TableField(value = "mFunction")
    private String mFunction;
}

