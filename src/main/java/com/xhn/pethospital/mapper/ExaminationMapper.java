package com.xhn.pethospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.pethospital.entity.Examination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExaminationMapper extends BaseMapper<Examination> {
    @Update("update examination set eStatus=1,eGeneratedTime=sysdate() where eId=#{id}")
    public int changeStatus(@Param("id")int id);
}
