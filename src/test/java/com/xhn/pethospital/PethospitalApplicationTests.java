package com.xhn.pethospital;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.controller.OwnerController;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.service.IAdminService;
import com.xhn.pethospital.service.IOwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PethospitalApplicationTests {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IOwnerService ownerService;
    @Test
    void contextLoads() {
        Admin admin=new Admin();
        admin.setAdAccount("xhn946");
        Admin admin1=adminService.queryAdminByAdAccount(admin);
        if(admin1!=null){
            System.out.println(admin1.getAdPassword());
        }
        List<Owner> ownerList = ownerService.queryOwnerList();
        System.out.println(ownerList);
        if(ownerList!=null&&ownerList.size()>0){
            System.out.println("ownerList");
        }else {
            System.out.println("有的");
        }
    }
}
