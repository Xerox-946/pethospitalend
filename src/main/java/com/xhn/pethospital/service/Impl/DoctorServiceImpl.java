package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Doctor;
import com.xhn.pethospital.mapper.AdminMapper;
import com.xhn.pethospital.mapper.DoctorMapper;
import com.xhn.pethospital.service.IDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

    @Resource
    private DoctorMapper doctorMapper;
    @Override
    public IPage<Doctor> selectDoctorPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dName",param);
        }
        Page<Doctor> page = new Page<>(pageNum,pageSize);
        return doctorMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addDoctor(Doctor doctor) {
        return doctorMapper.insert(doctor);
    }

    @Override
    public int editDoctor(Doctor doctor) {
        return doctorMapper.updateById(doctor);
    }

    @Override
    public Doctor queryDoctorById(Integer id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public int delDoctorById(Integer id) {
        return doctorMapper.deleteById(id);
    }

    @Override
    public Doctor queryDoctorByAccount(Doctor doctor) {
        QueryWrapper<Doctor> wrapper = new QueryWrapper<>();
        wrapper.eq("dAccount",doctor.getDAccount());
        return doctorMapper.selectOne(wrapper);
    }

    @Override
    public List<Doctor> queryDoctorList() {
        return doctorMapper.selectList(null);
    }
}
