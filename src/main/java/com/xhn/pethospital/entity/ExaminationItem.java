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
@TableName("examinationitem")
//检查项目表
public class ExaminationItem {
    @TableField(value = "eiId")
    @TableId(value = "eiId",type = IdType.AUTO)
    //主键
    private Integer eiId;
    //检查项目
    @TableField(value = "eiName")
    private String eiName;
    @TableField(value = "eiCreateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eiCreateTime;
    /*生产时间转换成年月日*/
    public String getEiCreateTimeStr(){
        return DateUtil.dateConvert(eiCreateTime);
    }
    @TableField(value = "eiDetail")
    private String eiDetail;
}
