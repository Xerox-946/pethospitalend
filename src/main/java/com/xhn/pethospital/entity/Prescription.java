package com.xhn.pethospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhn.pethospital.common.DateUtil;
import lombok.Data;

import java.util.Date;

@Data
@TableName("prescription")
//处方
public class Prescription {
    @TableField(value = "preId")
    @TableId(value = "preId",type = IdType.AUTO)
    //主键
    private Integer preId;
    //宠物名称
    @TableField(value = "pName")
    private String pName;
    //医生名称
    @TableField(value = "dName")
    private String dName;
    //用户名称
    @TableField(value = "oName")
    private String oName;
    //药品名称
    @TableField(value = "mName")
    private String mName;
    //处方编号
    @TableField(value = "preMethod")
    private String preMethod;
    //关联的挂号id
    @TableField(value = "aId")
    private Integer aId;
    //被创建时间
    @TableField(value = "preCreatetime")
    private Date preCreatetime;
    public String getPreCreatetimeStr(){
        return DateUtil.dateConvert(preCreatetime);
    }

    @TableField(value = "eiName")
    private String eiName;

}
