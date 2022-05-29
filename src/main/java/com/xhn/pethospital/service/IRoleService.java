package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<Role> selectRolePage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息信息
     * @param role
     */
    public int addRole(Role role);

    /**
     * 修改一条账单信息信息
     * @param role
     */
    public int editRole(Role role);

    /**
     * 根据主键id查询一个账单信息对象
     * @param id
     * @return
     */
    public Role queryRoleById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int delRoleById(Integer id);

    public List<Role> queryRoleList();

    public int setFalse(int rid);

    public int updateTree(int rid,int mid);
}
