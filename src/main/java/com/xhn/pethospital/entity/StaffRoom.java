package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("staffroom")
//检查项目表
public class StaffRoom {
    @TableField(value = "srId")
    @TableId(value = "srId",type = IdType.AUTO)
    //主键
    private Integer srId;
    //检查的房间名称
    @TableField(value = "srRoomName")
    private String srRoomName;
}
