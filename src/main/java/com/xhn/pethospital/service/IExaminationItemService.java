package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.ExaminationItem;
import com.xhn.pethospital.entity.ExaminationItem;

import java.util.List;

public interface IExaminationItemService extends IService<ExaminationItem> {
    /**
     * 分页查询检查项目信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-检查项目信息名称
     * @return
     */
    public IPage<ExaminationItem> selectExaminationItemPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条检查项目信息信息
     * @param examinationItem
     */
    public int addExaminationItem(ExaminationItem examinationItem);

    /**
     * 修改一条检查项目信息信息
     * @param examinationItem
     */
    public int editExaminationItem(ExaminationItem examinationItem);

    /**
     * 根据主键id查询一个检查项目信息对象
     * @param id
     * @return
     */
    public ExaminationItem queryExaminationItemById(Integer id);

    /**
     * 根据主键id删除一个检查项目信息对象
     * @param id
     * @return
     */
    public int delExaminationItemById(Integer id);

    public List<ExaminationItem> queryExaminationItemList();
}
