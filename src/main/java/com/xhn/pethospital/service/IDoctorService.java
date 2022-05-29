package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Doctor;

import java.util.List;

public interface IDoctorService extends IService<Doctor> {
    /**
     * 分页查询医生数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-医生名称
     * @return
     */
    public IPage<Doctor> selectDoctorPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条医生信息
     * @param doctor
     */
    public int addDoctor(Doctor doctor);

    /**
     * 修改一条医生信息
     * @param doctor
     */
    public int editDoctor(Doctor doctor);

    /**
     * 根据主键id查询一个医生对象
     * @param id
     * @return
     */
    public Doctor queryDoctorById(Integer id);

    /**
     * 根据主键id删除一个医生对象
     * @param id
     * @return
     */
    public int delDoctorById(Integer id);

    public Doctor queryDoctorByAccount(Doctor doctor);

    public List<Doctor> queryDoctorList();
}
