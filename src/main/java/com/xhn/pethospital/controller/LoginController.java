package com.xhn.pethospital.controller;

import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Doctor;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.entity.Staff;
import com.xhn.pethospital.service.IAdminService;
import com.xhn.pethospital.service.IDoctorService;
import com.xhn.pethospital.service.IOwnerService;
import com.xhn.pethospital.service.IStaffService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private IOwnerService ownerService;
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IStaffService staffService;


    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String account, String password, String role, HttpSession session){
        if(account==null||password==null){
            return ResultMapUtil.getHashMapLogin("账号密码不能为空","2");
        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(account,password,role);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResultMapUtil.getHashMapLogin("账号不存在","2");
        }catch (IncorrectCredentialsException e){
            return ResultMapUtil.getHashMapLogin("密码错误","2");
        }
        if("管理员".equals(role)){
            Admin admin=new Admin();
            admin.setAdAccount(account);
            Admin admin1=adminService.queryAdminByAdAccount(admin);
            session.setAttribute("loginUser", admin1.getAdName());
            session.setAttribute("loginId",admin1.getAdId());
            session.setAttribute("loginRole",role);
            return ResultMapUtil.getHashMapLogin("管理员登录成功","1");
        }else if("医生".equals(role)){
            Doctor doctor=new Doctor();
            doctor.setDAccount(account);
            Doctor doctor1=doctorService.queryDoctorByAccount(doctor);
            session.setAttribute("loginUser",doctor1.getDName());
            session.setAttribute("loginId",doctor1.getDId());
            session.setAttribute("loginRole",role);
            return ResultMapUtil.getHashMapLogin("医生登录成功","1");
        }else if("职工".equals(role)) {
            Staff staff = new Staff();
            staff.setSAccount(account);
            Staff staff1 = staffService.queryStaffByAccount(staff);
            session.setAttribute("loginUser", staff1.getSName());
            session.setAttribute("loginId", staff1.getSId());
            session.setAttribute("loginRole", role);
            return ResultMapUtil.getHashMapLogin("职工登录成功", "1");
        } else{
            Owner owner=new Owner();
            owner.setOAccount(account);
            Owner owner1=ownerService.queryOwnerByAccount(owner);
            session.setAttribute("loginUser",owner1.getOName());
            session.setAttribute("loginId",owner1.getOId());
            session.setAttribute("loginRole",role);
            return ResultMapUtil.getHashMapLogin("用户登录成功","1");
        }
    }

    @RequestMapping(value = "/loginRole")
    @ResponseBody
    public ResultMapUtil getLoginRole(HttpSession session){
        return ResultMapUtil.ok(session.getAttribute("loginRole"));
    }

    @RequestMapping(value = "/index")
    public String index(){
            return "/index";
    }
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/register")
    public String registerPage(){
        return "/register";
    }

    /**
     * 添加一个用户
     */
    @RequestMapping(value = "/registerAdd")
    @ResponseBody
    public Object registerAdd(Owner owner){
        try{
            int i = ownerService.addOwner(owner);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
