package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.mapper.StaticMapper;
import com.xhn.pethospital.service.IStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaticServiceImpl extends ServiceImpl<StaticMapper, Admin> implements IStaticService {

    @Resource
    private StaticMapper staticMapper;

    @Override
    public List getPetTypeCount() {
        return staticMapper.petTypeCount();
    }

    @Override
    public ResultMapUtil getRoleCounts() {
        Map<String,Integer> map =new HashMap<>();
        map.put("医生",staticMapper.getRoleCounts("doctor"));
        map.put("用户",staticMapper.getRoleCounts("owner"));
        map.put("职工",staticMapper.getRoleCounts("staff"));
        return ResultMapUtil.ok(map);
    }

    @Override
    public ResultMapUtil getdAppointment() {
        List<Map<String,String>> list=staticMapper.getdAppointment();
        return ResultMapUtil.ok(list);
    }

    @Override
    public ResultMapUtil lastforteenDayDiagnosis() {
        return ResultMapUtil.ok(staticMapper.lastforteenDayDiagnosis());
    }

    @Override
    public ResultMapUtil getNDstatics() {
        Date dt=new Date();
        int year=dt.getYear()+1900;
        int num=year-2012+1;
        String dynamicSql ="";
        Long[] sum=new Long[num];
        for(int i=0;i<num;i++) {
            sum[i]=0L;
            dynamicSql += "sum(case when year(atime) = (SELECT year(CURDATE())-" + i + ") then 1 else 0 end) y" + i + ",";
        }
        dynamicSql=dynamicSql.substring(0, dynamicSql.length()-1);
        Map<String,Object> obj=staticMapper.getNDstatics(dynamicSql);
        for(int i=0;i<num;i++) {
             sum[i]=((BigDecimal)obj.get("y"+i)).longValue();
        }
        return ResultMapUtil.ok(sum);
    }
}
