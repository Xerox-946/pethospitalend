package com.xhn.pethospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.pethospital.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StaticMapper extends BaseMapper<Admin> {
    @Select("select ptype,count(ptype) as counts from pet group by ptype;")
    public List<Map<String,String>> petTypeCount();
    @Select("select count(*) from ${searchList}")
    public Integer getRoleCounts(@Param("searchList")String searchList);
    @Select("select dName,count(dName) as counts from appointment group by dName")
    public List<Map<String,String>> getdAppointment();
    @Select("select a.click_date as dates,ifnull(b.count,0) as counts\n" +
            "           from (\n" +
            "           SELECT curdate() as click_date\n" +
            "           union all\n" +
            "           SELECT date_sub(curdate(),interval 1 day) as click_date\n" +
            "           union all\n" +
            "           SELECT date_sub(curdate(),interval 2 day) as click_date\n" +
            "           union all\n" +
            "           SELECT date_sub(curdate(),interval 3 day) as click_date\n" +
            "           union all\n" +
            "            SELECT date_sub(curdate(),interval 4 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 5 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 6 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 7 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 8 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 9 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 10 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 11 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 12 day) as click_date\n" +
            "            union all\n" +
            "            SELECT date_sub(curdate(),interval 13 day) as click_date\n" +
            "           ) a left join (\n" +
            "            select DATE_FORMAT(atime,'%Y-%m-%d')as atime, count(*) as count\n" +
            "            from appointment\n" +
            "            group by DATE_FORMAT(atime,'%Y-%m-%d')\n" +
            "            ) b on a.click_date = b.aTime ORDER BY a.click_date desc;")
    public List<Map<String,String>> lastforteenDayDiagnosis();
    @Select("select ${searchList} from appointment;")
    public Map<String,Object> getNDstatics(@Param("searchList")String searchList);
}
