package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Staff;
import com.xhn.pethospital.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 职工相关的controller
 */
@Controller
@RequestMapping(value = "/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    /**
     * 转向职工页面
     */
    @RequestMapping
    public String staff(){
        return "/staff";
    }

    /**
     * 分页查询职工列表
     */
    @RequestMapping(value = "/staffQueryPage")
    @ResponseBody
    public Object staffQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<Staff> iPage = staffService.selectStaffPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向职工新增页面
     */
    @RequestMapping(value = "/staffPage")
    public String staffPage(){
        return "/staffPage";
    }

    /**
     * 添加一个职工
     */
    @RequestMapping(value = "/staffAdd")
    @ResponseBody
    public Object staffAdd(Staff staff){
        try{
            int i = staffService.addStaff(staff);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向职工编辑页面
     */
    @RequestMapping(value = "/staffQueryById")
    public String staffQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Staff staff = staffService.queryStaffById(id);
        model.addAttribute("obj",staff);
        return "/staffPage";
    }

    /**
     * 修改一个职工
     */
    @RequestMapping(value = "/staffEdit")
    @ResponseBody
    public Object staffEdit(Staff staff){
        try{
            int i = staffService.editStaff(staff);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个职工
     */
    @RequestMapping(value = "/staffDelById")
    @ResponseBody
    public Object staffDelById(Integer id){
        try{
            int i = staffService.delStaffById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有职工
     */
    @RequestMapping(value = "/staffList")
    @ResponseBody
    public Object staffList(){
        List<Staff> staffList = staffService.queryStaffList();
        return ResultMapUtil.getHashMapList(staffList);
    }

    @RequestMapping(value = "/staffInfo")
    public String StaffInfo(){
        return "/staffInfo";
    }


    @RequestMapping(value = "/staffQuery")
    @ResponseBody
    public Staff staffQuery(HttpSession session){
        Staff staff = staffService.queryStaffById((Integer)session.getAttribute("loginId"));
        return staff;
    }
}





















