package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.ExaminationItem;
import com.xhn.pethospital.mapper.AdminMapper;
import com.xhn.pethospital.mapper.ExaminationItemMapper;
import com.xhn.pethospital.service.IExaminationItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminationItemServiceImpl extends ServiceImpl<ExaminationItemMapper, ExaminationItem> implements IExaminationItemService {

    @Resource
    private ExaminationItemMapper examinationItemMapper;
    @Override
    public IPage<ExaminationItem> selectExaminationItemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ExaminationItem> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("eiName",param);
        }
        Page<ExaminationItem> page = new Page<>(pageNum,pageSize);
        return examinationItemMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addExaminationItem(ExaminationItem examinationItem) {
        return examinationItemMapper.insert(examinationItem);
    }

    @Override
    public int editExaminationItem(ExaminationItem examinationItem) {
        return examinationItemMapper.updateById(examinationItem);
    }

    @Override
    public ExaminationItem queryExaminationItemById(Integer id) {
        return examinationItemMapper.selectById(id);
    }

    @Override
    public int delExaminationItemById(Integer id) {
        return examinationItemMapper.deleteById(id);
    }

    @Override
    public List<ExaminationItem> queryExaminationItemList() {
        return examinationItemMapper.selectList(null);
    }
}
