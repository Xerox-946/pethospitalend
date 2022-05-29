package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("staff")
//职员表
public class Staff {
    @TableField(value = "sId")
    @TableId(value = "sId",type = IdType.AUTO)
    //主键
    private Integer sId;
    //名字
    @TableField(value = "sName")
    private String sName;
    //账号
    @TableField(value = "sAccount")
    private String sAccount;
    //密码
    @TableField(value = "sPassword")
    private String sPassword;
    //性别
    @TableField(value = "sGender")
    private String sGender;
    //身份证
    @TableField(value = "sIdNum")
    private String sIdNum;
    //电话
    @TableField(value = "sPhone")
    private String sPhone;
}
