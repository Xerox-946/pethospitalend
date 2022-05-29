package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Admin;

import java.util.List;

public interface IStaticService extends IService<Admin> {
    public List getPetTypeCount();

    public ResultMapUtil getRoleCounts();

    public ResultMapUtil getdAppointment();

    public ResultMapUtil lastforteenDayDiagnosis();

    public ResultMapUtil getNDstatics();
}
