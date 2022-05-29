package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Doctor;
import com.xhn.pethospital.entity.Owner;

import java.util.List;

public interface IOwnerService extends IService<Owner> {
    /**
     * 分页查询用户数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-用户名称
     * @return
     */
    public IPage<Owner> selectOwnerPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条用户信息
     * @param owner
     */
    public int addOwner(Owner owner);

    /**
     * 修改一条用户信息
     * @param owner
     */
    public int editOwner(Owner owner);

    /**
     * 根据主键id查询一个用户对象
     * @param id
     * @return
     */
    public Owner queryOwnerById(Integer id);

    /**
     * 根据主键id删除一个用户对象
     * @param id
     * @return
     */
    public int delOwnerById(Integer id);

    public Owner queryOwnerByAccount(Owner owner);

    public List<Owner> queryOwnerList();
}
