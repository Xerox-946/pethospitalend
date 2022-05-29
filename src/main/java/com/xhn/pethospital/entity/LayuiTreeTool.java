package com.xhn.pethospital.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor   // 无参构造函数

public class LayuiTreeTool implements Serializable {
    private Integer id;  // 标签对应ID
    private String title; // Tree显示的名称
    private String field; // 域，对应
    private Boolean checked;// 复选框是否选中: 省略默认为false;
    private Boolean spread;//该参数控制是否展开,true展开,false折叠,默认为false
    private List<LayuiTreeTool> children;
}
