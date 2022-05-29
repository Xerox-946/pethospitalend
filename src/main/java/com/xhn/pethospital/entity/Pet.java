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
@TableName("pet")
//宠物表
public class Pet {
    @TableField(value = "pId")
    @TableId(value = "pId",type = IdType.AUTO)
    //主键
    private Integer pId;
    //宠物名称
    @TableField(value = "pName")
    private String pName;
    //宠物类型
    @TableField(value = "pType")
    private String pType;
    //宠物主人
    @TableField(value = "oName")
    private String oName;
    //宠物性别
    @TableField(value = "pGender")
    private String pGender;
    //宠物生日
    @TableField(value = "pBirthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pBirthday;
    //宠物遗传病史
    @TableField(value = "pGeneticHistory")
    private String pGeneticHistory;
    //宠物过敏病史
    @TableField(value = "pAllergicHistory")
    private String pAllergicHistory;
    //宠物爱好
    @TableField(value = "pHabbit")
    private String pHabbit;
    //宠物品种
    @TableField(value = "pTypeName")
    private String pTypeName;
    /*生产时间转换成年月日*/
    public String getPBirthdayStr(){
        if(pBirthday==null){
            return "";
        }else {
            return DateUtil.dateConvert(pBirthday);
        }
    }
}