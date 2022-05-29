package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Appointment;
import com.xhn.pethospital.entity.Examination;
import com.xhn.pethospital.entity.Prescription;
import com.xhn.pethospital.service.IAppointmentService;
import com.xhn.pethospital.service.IExaminationService;
import com.xhn.pethospital.service.IPrescriptionService;
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
 * 病例相关的controller
 */
@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    private IPrescriptionService prescriptionService;
    @Autowired
    private IAppointmentService appointmentService;
    @Autowired
    private IExaminationService examinationService;

    /**
     * 转向病例页面
     */
    @RequestMapping
    public String prescription(){
        return "/prescription";
    }

    /**
     * 分页查询病例列表
     */
    @RequestMapping(value = "/prescriptionQueryPage")
    @ResponseBody
    public Object prescriptionQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize,HttpSession session){
        try{
            IPage<Prescription> iPage = prescriptionService.selectPrescriptionPage(pageNum,pageSize,param,session);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向病例新增页面
     */
    @RequestMapping(value = "/prescriptionPage")
    public String prescriptionPage(){
        return "/prescriptionPage";
    }

    /**
     * 添加一个病例
     */
    @RequestMapping(value = "/prescriptionAdd")
    @ResponseBody
    public Object prescriptionAdd(Prescription prescription){
        try{
            int i = prescriptionService.addPrescription(prescription);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向病例编辑页面
     */
    @RequestMapping(value = "/prescriptionQueryByAId")
    public String prescriptionQueryByAId(@RequestParam(name = "id",required = true)Integer id, Model model){
        Appointment appointment=appointmentService.queryAppointmentById(id);
        model.addAttribute("obj",appointment);
        return "/prescriptionPage";
    }

    @RequestMapping(value = "/prescriptionQueryById")
    public String prescriptionQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Prescription prescription=prescriptionService.queryPrescriptionById(id);
        model.addAttribute("obj",prescription);
        return "/prescriptionPage";
    }

    /**
     * 修改一个病例
     */
    @RequestMapping(value = "/prescriptionEdit")
    @ResponseBody
    public Object prescriptionEdit(Prescription prescription){
        prescription.setPreCreatetime(new Date());
        prescription.setPreId(1);
        prescriptionService.addPrescription(prescription);
        Appointment appointment=appointmentService.queryAppointmentById(prescription.getAId());
        appointment.setATime(new Date());
        appointment.setStatus(1);
        appointmentService.editAppointment(appointment);
        if(prescription.getEiName().equals("") || prescription.getEiName()==null){
        }else{
            Examination examination=new Examination();
            examination.setEiName(prescription.getEiName());
            examination.setAId(prescription.getAId());
            examination.setDName(prescription.getDName());
            examination.setEStatus(0);
            examination.setOName(prescription.getOName());
            examination.setEId(1);
            examination.setPName(prescription.getPName());
            examination.setEGeneratedTime(new Date());
            examinationService.addExamination(examination);
        }

        try{
            int i = prescriptionService.editPrescription(prescription);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个病例
     */
    @RequestMapping(value = "/prescriptionDelById")
    @ResponseBody
    public Object prescriptionDelById(Integer id){
        try{
            int i = prescriptionService.delPrescriptionById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有病例
     */
    @RequestMapping(value = "/prescriptionList")
    @ResponseBody
    public Object prescriptionList(){
        List<Prescription> prescriptionList = prescriptionService.queryPrescriptionList();
        return ResultMapUtil.getHashMapList(prescriptionList);
    }

    @RequestMapping(value = "/prescriptionInfo")
    public String PrescriptionInfo(){
        return "/prescriptionInfo";
    }


    @RequestMapping(value = "/prescriptionQuery")
    @ResponseBody
    public Prescription prescriptionQuery(HttpSession session){
        Prescription prescription = prescriptionService.queryPrescriptionById((Integer)session.getAttribute("loginId"));
        return prescription;
    }
}





















