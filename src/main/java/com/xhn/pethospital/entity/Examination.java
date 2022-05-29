package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhn.pethospital.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("examination")
//检查表
public class Examination {
    @TableField(value = "eId")
    @TableId(value = "eId",type = IdType.AUTO)
    //主键
    private Integer eId;
    //检查项目名称
    @TableField(value ="eiName" )
    private String eiName;
    //宠物名称
    @TableField(value ="pName" )
    private String pName;
    //医生名称
    @TableField(value ="dName" )
    private String dName;
    //检查时间
    @TableField(value ="eGeneratedTime" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eGeneratedTime;
    //挂号id
    @TableField(value ="aId" )
    private Integer aId;
    //检查状态
    @TableField(value ="eStatus" )
    private Integer eStatus;
    @TableField(value ="sName" )
    private String sName;
    @TableField(value ="oName" )
    private String oName;

    public String getEGeneratedTimeStr(){
        if(eGeneratedTime==null){
            return "";
        }else {
            return DateUtil.dateConvert(eGeneratedTime);
        }
    }
}
