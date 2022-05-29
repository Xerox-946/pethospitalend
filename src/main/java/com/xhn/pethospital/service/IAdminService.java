package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Menu;

import java.util.List;

public interface IAdminService extends IService<Admin> {
    /**
     * 分页查询管理员数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-管理员名称
     * @return
     */
    IPage<Admin> selectAdminPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条管理员信息
     * @param admin
     */
    int addAdmin(Admin admin);

    /**
     * 修改一条管理员信息
     * @param admin
     */
    int editAdmin(Admin admin);

    /**
     * 根据主键id查询一个管理员对象
     * @param admin
     * @return
     */
    Admin queryAdminByAdAccount(Admin admin);

    /**
     * 根据主键id删除一个管理员对象
     * @param id
     * @return
     */
    int delAdminById(Integer id);

    List<Menu> listAdminMenuByRole(Integer roleId);

    List<Menu> listAdminMenuTreeByRole(Integer roleId);
}
