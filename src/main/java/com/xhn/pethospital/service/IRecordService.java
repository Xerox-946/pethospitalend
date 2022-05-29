package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Record;

public interface IRecordService extends IService<Record> {
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<Record> selectRecordPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息信息
     * @param record
     */
    public int addRecord(Record record);

    /**
     * 修改一条账单信息信息
     * @param record
     */
    public int editRecord(Record record);

    /**
     * 根据主键id查询一个账单信息对象
     * @param id
     * @return
     */
    public Record queryRecordById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int delRecordById(Integer id);
}
