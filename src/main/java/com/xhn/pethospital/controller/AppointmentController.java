package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Appointment;
import com.xhn.pethospital.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 挂号相关的controller
 */
@Controller
@RequestMapping(value = "/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    /**
     * 转向挂号页面
     */
    @RequestMapping
    public String appointment(){
        return "/appointment";
    }


    /**
     * 分页查询挂号列表
     */
    @RequestMapping(value = "/appointmentQueryPage")
    @ResponseBody
    public Object appointmentQueryPage(String param,String diagnosised, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize,HttpSession session,@RequestParam(name = "dName",required = false)String dName){
        try{
            IPage<Appointment> iPage = appointmentService.selectAppointmentPage(pageNum,pageSize,param,diagnosised,session,dName);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向挂号新增页面
     */
    @RequestMapping(value = "/appointmentPage")
    public String appointmentPage(){
        return "/appointmentPage";
    }

    /**
     * 添加一个挂号
     */
    @RequestMapping(value = "/appointmentAdd")
    @ResponseBody
    public Object AppointmentAdd(Appointment appointment,HttpSession session){
        appointment.setACreatetime(new Date());
        appointment.setAOperator((String)session.getAttribute("loginUser"));
        appointment.setATime(new Date());
        appointment.setStatus(-1);
        try{
            int i = appointmentService.addAppointment(appointment);
            return ResultMapUtil.getHashMapGH(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向挂号编辑页面
     */
    @RequestMapping(value = "/appointmentQueryById")
    public String appointmentQueryById(@RequestParam(name = "id",required = true)Integer id, Model model,HttpSession session){
        Appointment appointment = appointmentService.queryAppointmentById(id);
        model.addAttribute("obj",appointment);
        if(session.getAttribute("loginRole").equals("管理员")){
            return "/doAppointmentPage";
        }else{
            return "/appointmentPage";
        }

    }

    /**
     * 修改一个挂号
     */
    @RequestMapping(value = "/appointmentEdit")
    @ResponseBody
    public Object appointmentEdit(Appointment appointment,HttpSession session){
        appointment.setACreatetime(new Date());
        appointment.setAOperator((String)session.getAttribute("loginUser"));
        appointment.setATime(new Date());
        try{
            int i = appointmentService.editAppointment(appointment);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个挂号
     */
    @RequestMapping(value = "/appointmentDelById")
    @ResponseBody
    public Object appointmentDelById(Integer id){
        try{
            int i = appointmentService.delAppointmentById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有挂号
     */
    @RequestMapping(value = "/appointmentList")
    @ResponseBody
    public Object appointmentList(){
        List<Appointment> appointmentList = appointmentService.queryAppointmentList();
        return ResultMapUtil.getHashMapList(appointmentList);
    }

    @RequestMapping(value = "/appointmentInfo")
    public String AppointmentInfo(){
        return "/appointmentInfo";
    }


    @RequestMapping(value = "/appointmentQuery")
    @ResponseBody
    public Appointment appointmentQuery(HttpSession session){
        Appointment appointment = appointmentService.queryAppointmentById((Integer)session.getAttribute("loginId"));
        return appointment;
    }
}





















