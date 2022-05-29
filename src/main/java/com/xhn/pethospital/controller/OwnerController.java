package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户相关的controller
 */
@Controller
@RequestMapping(value = "/owner")
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    /**
     * 转向用户页面
     */
    @RequestMapping
    public String ownerList(){
        return "/owner";
    }

    /**
     * 分页查询用户列表
     */
    @RequestMapping(value = "/ownerQueryPage")
    @ResponseBody
    public Object ownerListQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<Owner> iPage = ownerService.selectOwnerPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    

    /**
     * 转向用户编辑页面
     */
    @RequestMapping(value = "/ownerQueryById")
    public String ownerListQueryById(@RequestParam(name = "id",required = true)Integer oId, Model model){
        Owner owner = ownerService.queryOwnerById(oId);
        model.addAttribute("obj",owner);
        return "/ownerPage";
    }

    @RequestMapping(value = "/ownerQuery")
    @ResponseBody
    public Owner ownerQuery(HttpSession session){
        Owner owner = ownerService.queryOwnerById((Integer)session.getAttribute("loginId"));
        return owner;
    }

    /**
     * 修改一个用户
     */
    @RequestMapping(value = "/ownerEdit")
    @ResponseBody
    public Object ownerListEdit(Owner owner){
        try{
            int i = ownerService.editOwner(owner);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有用户
     */
    @RequestMapping(value = "/ownerList")
    @ResponseBody
    public Object ownerListL(){
        List<Owner> ownerList = ownerService.queryOwnerList();
        return ResultMapUtil.getHashMapList(ownerList);
    }

    @RequestMapping(value = "/ownerInfo")
    public String ownerInfo(){
        return "/ownerInfo";
    }
}





















