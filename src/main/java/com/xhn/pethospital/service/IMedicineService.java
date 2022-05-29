package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Medicine;

import java.util.List;

public interface IMedicineService extends IService<Medicine> {
    /**
     * 分页查询药品信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品信息名称
     * @return
     */
    public IPage<Medicine> selectMedicinePage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品信息信息
     * @param medicine
     */
    public int addMedicine(Medicine medicine);

    /**
     * 修改一条药品信息信息
     * @param medicine
     */
    public int editMedicine(Medicine medicine);

    /**
     * 根据主键id查询一个药品信息对象
     * @param id
     * @return
     */
    public Medicine queryMedicineById(Integer id);

    /**
     * 根据主键id删除一个药品信息对象
     * @param id
     * @return
     */
    public int delMedicineById(Integer id);

//    public Medicine queryMedicineByAccount(Medicine medicine);

    public List<Medicine> queryMedicineList();
}
