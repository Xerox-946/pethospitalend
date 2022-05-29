package com.xhn.pethospital.config;

import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Doctor;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.entity.Staff;
import com.xhn.pethospital.service.IAdminService;
import com.xhn.pethospital.service.IDoctorService;
import com.xhn.pethospital.service.IOwnerService;
import com.xhn.pethospital.service.IStaffService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IOwnerService ownerService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String userAccount=token.getUsername();
        String role=token.getHost();
        if("管理员".equals(role)){
            Admin queryAdmin=new Admin();
            queryAdmin.setAdAccount(userAccount);
            Admin admin=adminService.queryAdminByAdAccount(queryAdmin);
            if(admin==null){
                return null;
            }
            return new SimpleAuthenticationInfo(admin,admin.getAdPassword(),getName());
        }else if("医生".equals(role)){
            Doctor queryDoctor=new Doctor();
            queryDoctor.setDAccount(userAccount);
            Doctor doctor=doctorService.queryDoctorByAccount(queryDoctor);
            if(doctor==null){
                return null;
            }
            return new SimpleAuthenticationInfo(doctor,doctor.getDPassword(),getName());
        }else if("职工".equals(role)){
            Staff queryStaff=new Staff();
            queryStaff.setSAccount(userAccount);
            Staff staff=staffService.queryStaffByAccount(queryStaff);
            if(staff==null){
                return null;
            }
            return new SimpleAuthenticationInfo(staff,staff.getSPassword(),getName());
        }else{
            Owner queryOwner=new Owner();
            queryOwner.setOAccount(userAccount);
            Owner owner=ownerService.queryOwnerByAccount(queryOwner);
            if(owner==null){
                return null;
            }
            return new SimpleAuthenticationInfo(owner,owner.getOPassword(),getName());
        }

    }
}
