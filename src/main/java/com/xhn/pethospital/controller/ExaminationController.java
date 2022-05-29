package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Examination;
import com.xhn.pethospital.service.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 检查单相关的controller
 */
@Controller
@RequestMapping(value = "/examination")
public class ExaminationController {

    @Autowired
    private IExaminationService examinationService;

    /**
     * 转向检查单页面
     */
    @RequestMapping
    public String examination(){
        return "/examination";
    }

    /**
     * 分页查询检查单列表
     */
    @RequestMapping(value = "/examinationQueryPage")
    @ResponseBody
    public Object examinationQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize,HttpSession session){
        try{
            IPage<Examination> iPage = examinationService.selectExaminationPage(pageNum,pageSize,param,session);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向检查单新增页面
     */
    @RequestMapping(value = "/examinationPage")
    public String examinationPage(){
        return "/examinationPage";
    }

    /**
     * 添加一个检查单
     */
    @RequestMapping(value = "/examinationAdd")
    @ResponseBody
    public Object examinationAdd(Examination examination){
        try{
            int i = examinationService.addExamination(examination);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向检查单编辑页面
     */
    @RequestMapping(value = "/examinationQueryById")
    public String examinationQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Examination examination = examinationService.queryExaminationById(id);
        model.addAttribute("obj",examination);
        return "/examinationPage";
    }

    /**
     * 修改一个检查单
     */
    @RequestMapping(value = "/examinationEdit")
    @ResponseBody
    public Object examinationEdit(Examination examination){
        try{
            int i = examinationService.editExamination(examination);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个检查单
     */
    @RequestMapping(value = "/examinationDelById")
    @ResponseBody
    public Object examinationDelById(Integer id){
        try{
            int i = examinationService.delExaminationById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个检查单
     */
    @RequestMapping(value = "/examinationChangeById")
    @ResponseBody
    public Object examinationChangeById(Integer id){
        try{
            int i = examinationService.changeStatus(id);
            return ResultMapUtil.getHashMapChange(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有检查单
     */
    @RequestMapping(value = "/examinationList")
    @ResponseBody
    public Object examinationList(){
        List<Examination> examinationList = examinationService.queryExaminationList();
        return ResultMapUtil.getHashMapList(examinationList);
    }

    @RequestMapping(value = "/examinationInfo")
    public String ExaminationInfo(){
        return "/examinationInfo";
    }


    @RequestMapping(value = "/examinationQuery")
    @ResponseBody
    public Examination examinationQuery(HttpSession session){
        Examination examination = examinationService.queryExaminationById((Integer)session.getAttribute("loginId"));
        return examination;
    }
}





















