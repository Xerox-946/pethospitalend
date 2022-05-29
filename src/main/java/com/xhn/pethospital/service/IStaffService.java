package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Staff;

import java.util.List;

public interface IStaffService extends IService<Staff> {
    /**
     * 分页查询职工数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-职工名称
     * @return
     */
    public IPage<Staff> selectStaffPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条职工信息
     * @param staff
     */
    public int addStaff(Staff staff);

    /**
     * 修改一条职工信息
     * @param staff
     */
    public int editStaff(Staff staff);

    /**
     * 根据主键id查询一个职工对象
     * @param id
     * @return
     */
    public Staff queryStaffById(Integer id);

    /**
     * 根据主键id删除一个职工对象
     * @param id
     * @return
     */
    public int delStaffById(Integer id);

    public Staff queryStaffByAccount(Staff staff);

    public List<Staff> queryStaffList();
}
