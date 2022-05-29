package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Record;
import com.xhn.pethospital.mapper.RecordMapper;
import com.xhn.pethospital.service.IRecordService;

public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
    @Override
    public IPage<Record> selectRecordPage(int pageNum, int pageSize, String param) {
        return null;
    }

    @Override
    public int addRecord(Record record) {
        return 0;
    }

    @Override
    public int editRecord(Record record) {
        return 0;
    }

    @Override
    public Record queryRecordById(Integer id) {
        return null;
    }

    @Override
    public int delRecordById(Integer id) {
        return 0;
    }
}
