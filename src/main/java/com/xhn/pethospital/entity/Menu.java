package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("menu")
public class Menu {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    //主键
    private Integer id;
    @TableField(value = "pid")
    private Integer pid;
    @TableField(value = "name")
    private String name;
    @TableField(value = "menuname")
    private String menuname;
    @TableField(value = "type")
    private String type;
    @TableField(value = "url")
    private String url;
    @TableField(value = "score")
    private Integer score;
    @TableField(value = "status")
    private String status;

    private List<Menu> childMenu;
}
