package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Medicine;
import com.xhn.pethospital.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 药品相关的controller
 */
@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {

    @Autowired
    private IMedicineService medicineService;

    /**
     * 转向药品页面
     */
    @RequestMapping
    public String medicine(){
        return "/medicine";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/medicineQueryPage")
    @ResponseBody
    public Object medicineQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<Medicine> iPage = medicineService.selectMedicinePage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/medicinePage")
    public String medicinePage(){
        return "/medicinePage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/medicineAdd")
    @ResponseBody
    public Object medicineAdd(Medicine medicine){
        try{
            int i = medicineService.addMedicine(medicine);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/medicineQueryById")
    public String medicineQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Medicine medicine = medicineService.queryMedicineById(id);
        model.addAttribute("obj",medicine);
        return "/medicinePage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/medicineEdit")
    @ResponseBody
    public Object medicineEdit(Medicine medicine){
        try{
            int i = medicineService.editMedicine(medicine);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/medicineDelById")
    @ResponseBody
    public Object medicineDelById(Integer id){
        try{
            int i = medicineService.delMedicineById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/medicineList")
    @ResponseBody
    public Object medicineList(){
        List<Medicine> medicineList = medicineService.queryMedicineList();
        return ResultMapUtil.getHashMapList(medicineList);
    }

    @RequestMapping(value = "/medicineInfo")
    public String MedicineInfo(){
        return "/medicineInfo";
    }


    @RequestMapping(value = "/medicineQuery")
    @ResponseBody
    public Medicine medicineQuery(HttpSession session){
        Medicine medicine = medicineService.queryMedicineById((Integer)session.getAttribute("loginId"));
        return medicine;
    }
}





















