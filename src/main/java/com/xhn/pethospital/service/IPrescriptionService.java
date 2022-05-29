package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Prescription;
import org.apache.shiro.session.Session;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IPrescriptionService extends IService<Prescription> {
    /**
     * 分页查询病例信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-病例信息名称
     * @return
     */
    public IPage<Prescription> selectPrescriptionPage(int pageNum, int pageSize, String param, HttpSession session);

    /**
     * 新增一条病例信息信息
     * @param prescription
     */
    public int addPrescription(Prescription prescription);

    /**
     * 修改一条病例信息信息
     * @param prescription
     */
    public int editPrescription(Prescription prescription);

    /**
     * 根据主键id查询一个病例信息对象
     * @param id
     * @return
     */
    public Prescription queryPrescriptionById(Integer id);

    /**
     * 根据主键id删除一个病例信息对象
     * @param id
     * @return
     */
    public int delPrescriptionById(Integer id);


    public List<Prescription> queryPrescriptionList();
}
