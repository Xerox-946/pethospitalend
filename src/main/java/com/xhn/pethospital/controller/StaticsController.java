package com.xhn.pethospital.controller;

import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.service.IAdminService;
import com.xhn.pethospital.service.IStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/statics")
public class StaticsController {
    @Autowired
    private IStaticService staticService;

    @RequestMapping
    public String prescription(){
        return "/statics";
    }

    @RequestMapping("/getPTypeCount")
    @ResponseBody
    public ResultMapUtil getPTypeCount(){
        return ResultMapUtil.ok(staticService.getPetTypeCount());
    }

    @RequestMapping("/getRoleCounts")
    @ResponseBody
    public ResultMapUtil getRoleCounts(){
        return staticService.getRoleCounts();
    }

    @RequestMapping("/getdAppointment")
    @ResponseBody
    public ResultMapUtil getdAppointment(){
        return staticService.getdAppointment();
    }

    @PostMapping("/lastforteenDayDiagnosis")
    @ResponseBody
    public ResultMapUtil lastforteenDayDiagnosis(){
        return staticService.lastforteenDayDiagnosis();
    }

    @PostMapping("/getNDstatics")
    @ResponseBody
    public ResultMapUtil getNDstatics(){
        return staticService.getNDstatics();
    }
}
