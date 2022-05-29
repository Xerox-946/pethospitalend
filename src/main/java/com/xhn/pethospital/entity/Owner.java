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
@TableName("owner")
//宠物主人表
public class Owner {
    @TableField(value = "oId")
    @TableId(value = "oId",type = IdType.AUTO)
    //主键
    private Integer oId;
    //宠物主人名字
    @TableField(value = "oName")
    private String oName;
    //主人账号
    @TableField(value = "oAccount")
    private String oAccount;
    //主人密码
    @TableField(value = "oPassword")
    private String oPassword;
    //主人性别
    @TableField(value = "oGender")
    private String oGender;
    //宠物主人国籍
    @TableField(value = "oNation")
    private String oNation;
    //职业
    @TableField(value = "oOccupation")
    private String oOccupation;
    //宠物家庭住址
    @TableField(value = "oAddress")
    private String oAddress;
    //电话
    @TableField(value = "oPhone")
    private String oPhone;
    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "oBirthday")
    private Date oBirthday;

    /*生产时间转换成年月日*/
    public String getOBirthdayStr(){
        return DateUtil.dateConvert(oBirthday);
    }
}
