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
@TableName("doctor")
//医生表
public class Doctor {
    @TableField(value = "dId")
    @TableId(value = "dId",type = IdType.AUTO)
    //主键
    private Integer dId;
    //医生名字
    @TableField(value = "dName")
    private String dName;
    //医生账号
    @TableField(value = "dAccount")
    private String dAccount;
    //医生密码
    @TableField(value = "dPassword")
    private String dPassword;
    //医生性别
    @TableField(value = "dGender")
    private String dGender;
    //医生电话
    @TableField(value = "dPhone")
    private String dPhone;
    //医生身份证
    @TableField(value = "dIdNum")
    private String dIdNum;
    //医生生日
    @TableField(value = "dBirthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dBirthday;

    /*生产时间转换成年月日*/
    public String getDBirthdayStr(){
        return DateUtil.dateConvert(dBirthday);
    }
}
