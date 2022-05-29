package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Examination;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IExaminationService extends IService<Examination> {
    /**
     * 分页查询检查单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-检查单信息名称
     * @return
     */
    public IPage<Examination> selectExaminationPage(int pageNum, int pageSize, String param, HttpSession session);

    /**
     * 新增一条检查单信息信息
     * @param examination
     */
    public int addExamination(Examination examination);

    /**
     * 修改一条检查单信息信息
     * @param examination
     */
    public int editExamination(Examination examination);

    /**
     * 根据主键id查询一个检查单信息对象
     * @param id
     * @return
     */
    public Examination queryExaminationById(Integer id);

    /**
     * 根据主键id删除一个检查单信息对象
     * @param id
     * @return
     */
    public int delExaminationById(Integer id);

    public List<Examination> queryExaminationList();

    public int changeStatus(int id);
}
