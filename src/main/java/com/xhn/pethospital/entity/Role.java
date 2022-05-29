package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role")
public class Role {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    //主键
    private Integer id;
    @TableField(value = "description")
    private String description;
    @TableField(value = "role")
    private String role;
}
