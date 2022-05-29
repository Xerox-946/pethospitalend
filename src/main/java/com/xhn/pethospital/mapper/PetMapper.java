package com.xhn.pethospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.pethospital.entity.Pet;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PetMapper extends BaseMapper<Pet> {
    @Select("select pType from pet group by pType;")
    public List<String> getPTypeList();

    @Select("select count(*) from pet where pname=#{pname} and oname=#{oname}")
    public int existPet(@Param("pname")String pname,@Param("oname")String oname);

}
