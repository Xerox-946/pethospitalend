package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Pet;
import com.xhn.pethospital.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 宠物相关的controller
 */
@Controller
@RequestMapping(value = "/pet")
public class PetController {

    @Autowired
    private IPetService petService;

    /**
     * 转向宠物页面
     */
    @RequestMapping
    public String pet(){
        return "/pet";
    }

    /**
     * 分页查询宠物列表
     */
    @RequestMapping(value = "/petQueryPage")
    @ResponseBody
    public Object petQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum, @RequestParam(value = "limit",defaultValue = "10")int pageSize, HttpSession session,@RequestParam(name = "type",required = false)String type){
        try{
            IPage<Pet> iPage = petService.selectPetPage(pageNum,pageSize,param,session,type);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向宠物新增页面
     */
    @RequestMapping(value = "/petPage")
    public String petPage(){
        return "/petPage";
    }

    /**
     * 添加一个宠物
     */
    @RequestMapping(value = "/petAdd")
    @ResponseBody
    public Object petAdd(Pet pet){
        try{
            int i = petService.addPet(pet);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向宠物编辑页面
     */
    @RequestMapping(value = "/petQueryById")
    public String petQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Pet pet = petService.queryPetById(id);

        model.addAttribute("obj",pet);
        return "/petPage";
    }

    /**
     * 修改一个宠物
     */
    @RequestMapping(value = "/petEdit")
    @ResponseBody
    public Object petEdit(Pet pet){
        try{
            int i = petService.editPet(pet);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个宠物
     */
    @RequestMapping(value = "/petDelById")
    @ResponseBody
    public Object petDelById(Integer id){
        try{
            int i = petService.delPetById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有宠物
     */
    @RequestMapping(value = "/petList")
    @ResponseBody
    public Object petList(){
        List<Pet> petList = petService.queryPetList();
        return ResultMapUtil.getHashMapList(petList);
    }

    @RequestMapping(value = "/petInfo")
    public String petInfo(){
        return "/petInfo";
    }

    @RequestMapping(value = "/getpetTypeList")
    @ResponseBody
    public ResultMapUtil petTypeList(){
        return ResultMapUtil.ok(petService.queryPetTypeList());
    }

}





















