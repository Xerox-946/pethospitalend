package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Examination;
import com.xhn.pethospital.mapper.AdminMapper;
import com.xhn.pethospital.mapper.ExaminationMapper;
import com.xhn.pethospital.service.IExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ExaminationServiceImpl extends ServiceImpl<ExaminationMapper, Examination> implements IExaminationService {

    @Resource
    private ExaminationMapper examinationMapper;
    @Override
    public IPage<Examination> selectExaminationPage(int pageNum, int pageSize, String param, HttpSession session) {
        QueryWrapper<Examination> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("pName",param).or().
                    like("oName",param).or().
                    like("dName",param).or().
                    like("sName",param).or().
                    like("eiName",param).or().
                    like("aId",param);
        }
        if(session.getAttribute("loginRole").equals("医生")){
            queryWrapper.eq("dName",session.getAttribute("loginUser"));
        }else if(session.getAttribute("loginRole").equals("用户")){
            queryWrapper.eq("oName",session.getAttribute("loginUser"));
        }else if(session.getAttribute("loginRole").equals("职工")){
            queryWrapper.eq("sName",session.getAttribute("loginUser"));
        }else{

        }
        Page<Examination> page = new Page<>(pageNum,pageSize);
        return examinationMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addExamination(Examination examination) {
        return examinationMapper.insert(examination);
    }

    @Override
    public int editExamination(Examination examination) {
        return examinationMapper.updateById(examination);
    }

    @Override
    public Examination queryExaminationById(Integer id) {
        return examinationMapper.selectById(id);
    }

    @Override
    public int delExaminationById(Integer id) {
        return examinationMapper.deleteById(id);
    }

//    @Override
//    public Examination queryExaminationByAccount(Examination examination) {
//        QueryWrapper<Examination> wrapper = new QueryWrapper<>();
//        wrapper.eq("dAccount",examination.getDAccount());
//        return examinationMapper.selectOne(wrapper);
//    }

    @Override
    public List<Examination> queryExaminationList() {
        return examinationMapper.selectList(null);
    }

    @Override
    public int changeStatus(int id) {
        return examinationMapper.changeStatus(id);
    }
}
