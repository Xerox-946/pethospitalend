package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    @TableField(value = "adId")
    @TableId(value = "adId",type = IdType.AUTO)
    //主键
    private Integer adId;
    //管理员名称
    @TableField(value = "adName")
    private String adName;
    //管理员账号
    @TableField(value = "adAccount")
    private String adAccount;
    //管理员密码
    @TableField(value = "adPassword")
    private String adPassword;
}
