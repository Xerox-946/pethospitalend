package com.xhn.pethospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.pethospital.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select menu.* from role_menu, menu\n" +
            "   where role_menu.role_id = #{value} and role_menu.menu_id = menu.id and role_menu.status='true'")
    List<Menu> listMenuByRoleId(@Param("value") Integer roleId);

    @Select("select menu.id,menu.pid,menu.menuname,menu.type,menu.url,menu.score ,role_menu.status as status from role_menu, menu where role_menu.role_id =#{value} and role_menu.menu_id = menu.id ORDER BY menu.id")
    List<Menu> listMenuTreeByRoleId(@Param("value") Integer roleId);
}
