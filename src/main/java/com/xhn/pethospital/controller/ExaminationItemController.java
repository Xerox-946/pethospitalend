package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.ExaminationItem;
import com.xhn.pethospital.service.IExaminationItemService;
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
 * 科室相关的controller
 */
@Controller
@RequestMapping(value = "/examinationItem")
public class ExaminationItemController {

    @Autowired
    private IExaminationItemService examinationItemService;

    /**
     * 转向科室页面
     */
    @RequestMapping
    public String examinationItem(){
        return "/examinationItem";
    }

    /**
     * 分页查询科室列表
     */
    @RequestMapping(value = "/examinationItemQueryPage")
    @ResponseBody
    public Object examinationItemQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<ExaminationItem> iPage = examinationItemService.selectExaminationItemPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向科室新增页面
     */
    @RequestMapping(value = "/examinationItemPage")
    public String examinationItemPage(){
        return "/examinationItemPage";
    }

    /**
     * 添加一个科室
     */
    @RequestMapping(value = "/examinationItemAdd")
    @ResponseBody
    public Object examinationItemAdd(ExaminationItem examinationItem){
        examinationItem.setEiCreateTime(new Date());
        try{
            int i = examinationItemService.addExaminationItem(examinationItem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向科室编辑页面
     */
    @RequestMapping(value = "/examinationItemQueryById")
    public String examinationItemQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ExaminationItem examinationItem = examinationItemService.queryExaminationItemById(id);
        model.addAttribute("obj",examinationItem);
        return "/examinationItemPage";
    }

    /**
     * 修改一个科室
     */
    @RequestMapping(value = "/examinationItemEdit")
    @ResponseBody
    public Object examinationItemEdit(ExaminationItem examinationItem){
        try{
            int i = examinationItemService.editExaminationItem(examinationItem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个科室
     */
    @RequestMapping(value = "/examinationItemDelById")
    @ResponseBody
    public Object examinationItemDelById(Integer id){
        try{
            int i = examinationItemService.delExaminationItemById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有科室
     */
    @RequestMapping(value = "/examinationItemList")
    @ResponseBody
    public Object examinationItemList(){
        List<ExaminationItem> examinationItemList = examinationItemService.queryExaminationItemList();
        return ResultMapUtil.getHashMapList(examinationItemList);
    }

    @RequestMapping(value = "/examinationItemInfo")
    public String ExaminationItemInfo(){
        return "/examinationItemInfo";
    }


    @RequestMapping(value = "/examinationItemQuery")
    @ResponseBody
    public ExaminationItem examinationItemQuery(HttpSession session){
        ExaminationItem examinationItem = examinationItemService.queryExaminationItemById((Integer)session.getAttribute("loginId"));
        return examinationItem;
    }
}





















