package com.xhn.pethospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.pethospital.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface RoleMapper extends BaseMapper<Role> {
    @Update("UPDATE role_menu set status = \"true\" where role_id=#{rid} and menu_id=#{mid}")
    public int updateTree(@Param("rid")int rid,@Param("mid")int mid);
    @Update("UPDATE role_menu set status =\"false\" where role_id=#{rid}")
    public int setFalse(@Param("rid")int rid);
}
