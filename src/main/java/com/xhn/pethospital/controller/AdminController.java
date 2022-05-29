package com.xhn.pethospital.controller;

import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Menu;
import com.xhn.pethospital.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/admin/menu/listAdminMenu")
    @ResponseBody
    public ResultMapUtil listAdminMenu(HttpSession session) {
        List<Menu> result;
        String role=(String)session.getAttribute("loginRole");
        //1、判断当前用户的角色
        if("管理员".equals(role)) {
            //管理员
            result = adminService.listAdminMenuByRole(1);
        } else if("医生".equals(role)) {
            //普通用户
            result = adminService.listAdminMenuByRole(2);
        }else if("职工".equals(role)) {
            //普通用户
            result = adminService.listAdminMenuByRole(4);
        }else{
            result = adminService.listAdminMenuByRole(3);
        }
        System.out.println(result.size());
        if(result==null || result.size() == 0) {
            return ResultMapUtil.error("菜单为空");
        }
        return ResultMapUtil.ok(result);
    }
}
