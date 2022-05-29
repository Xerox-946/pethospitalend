package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Prescription;
import com.xhn.pethospital.mapper.PrescriptionMapper;
import com.xhn.pethospital.service.IPrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements IPrescriptionService {

    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Override
    public IPage<Prescription> selectPrescriptionPage(int pageNum, int pageSize, String param , HttpSession session) {
        QueryWrapper<Prescription> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("pName",param).or().
                    like("oName",param).or().
                    like("dName",param).or().
                    like("mName",param).or().
                    like("eiName",param).or().
                    like("premethod",param);
        }
        if(session.getAttribute("loginRole").equals("医生")){
            queryWrapper.eq("dName",session.getAttribute("loginUser"));
        }else if(session.getAttribute("loginRole").equals("用户")){
            queryWrapper.eq("oName",session.getAttribute("loginUser"));
        }else{

        }
        Page<Prescription> page = new Page<>(pageNum,pageSize);
        return prescriptionMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addPrescription(Prescription prescription) {
        return prescriptionMapper.insert(prescription);
    }

    @Override
    public int editPrescription(Prescription prescription) {
        return prescriptionMapper.updateById(prescription);
    }

    @Override
    public Prescription queryPrescriptionById(Integer id) {
        return prescriptionMapper.selectById(id);
    }

    @Override
    public int delPrescriptionById(Integer id) {
        return prescriptionMapper.deleteById(id);
    }

    @Override
    public List<Prescription> queryPrescriptionList() {
        return prescriptionMapper.selectList(null);
    }
}
