package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Doctor;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 医生相关的controller
 */
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    /**
     * 转向医生页面
     */
    @RequestMapping
    public String doctor(){
        return "/doctor";
    }

    /**
     * 分页查询医生列表
     */
    @RequestMapping(value = "/doctorQueryPage")
    @ResponseBody
    public Object doctorQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<Doctor> iPage = doctorService.selectDoctorPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向医生新增页面
     */
    @RequestMapping(value = "/doctorPage")
    public String doctorPage(){
        return "/doctorPage";
    }

    /**
     * 添加一个医生
     */
    @RequestMapping(value = "/doctorAdd")
    @ResponseBody
    public Object doctorAdd(Doctor doctor){
        try{
            int i = doctorService.addDoctor(doctor);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向医生编辑页面
     */
    @RequestMapping(value = "/doctorQueryById")
    public String doctorQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Doctor doctor = doctorService.queryDoctorById(id);
        model.addAttribute("obj",doctor);
        return "/doctorPage";
    }

    /**
     * 修改一个医生
     */
    @RequestMapping(value = "/doctorEdit")
    @ResponseBody
    public Object doctorEdit(Doctor doctor){
        try{
            int i = doctorService.editDoctor(doctor);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个医生
     */
    @RequestMapping(value = "/doctorDelById")
    @ResponseBody
    public Object doctorDelById(Integer id){
        try{
            int i = doctorService.delDoctorById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有医生
     */
    @RequestMapping(value = "/doctorList")
    @ResponseBody
    public Object doctorList(){
        List<Doctor> doctorList = doctorService.queryDoctorList();
        return ResultMapUtil.getHashMapList(doctorList);
    }

    @RequestMapping(value = "/doctorInfo")
    public String DoctorInfo(){
        return "/doctorInfo";
    }


    @RequestMapping(value = "/doctorQuery")
    @ResponseBody
    public Doctor doctorQuery(HttpSession session){
        Doctor doctor = doctorService.queryDoctorById((Integer)session.getAttribute("loginId"));
        return doctor;
    }
}





















