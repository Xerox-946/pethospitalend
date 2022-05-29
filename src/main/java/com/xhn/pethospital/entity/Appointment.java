package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhn.pethospital.common.DateUtil;
import lombok.Data;

import java.util.Date;

@Data
@TableName("appointment")
//挂号表
public class Appointment {
    @TableField(value = "aId")
    @TableId(value = "aId",type = IdType.AUTO)
    //主键
    private Integer aId;
    //宠物名称
    @TableField(value = "pName")
    private String pName;
    //问诊时间
    @TableField(value = "aTime")
    private Date aTime;
    public String getATimeStr(){
        return DateUtil.dateConvert(aTime);
    }
    //具体症状
    @TableField(value = "aSymptoms")
    private String aSymptoms;
    //被创建时间
    @TableField(value = "aCreatetime")
    private Date aCreatetime;
    public String getACreatetimeStr(){
        return DateUtil.dateConvert(aCreatetime);
    }
    //操作人名称
    @TableField(value = "aOperator")
    private String aOperator;
    //医生姓名
    @TableField(value = "dName")
    private String dName;
    //宠物主人名字
    @TableField(value = "oName")
    private String oName;
    @TableField(value = "status")
    private Integer status;
    @TableField(value = "pType")
    private String pType;
    @TableField(value = "mName")
    private String mName;
    @TableField(value = "preMethod")
    private String preMethod;
    //检查项目名称
    @TableField(value ="eiName" )
    private String eiName;
}
