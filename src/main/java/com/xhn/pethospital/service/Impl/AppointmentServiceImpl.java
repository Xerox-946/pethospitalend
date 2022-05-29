package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Appointment;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.entity.Pet;
import com.xhn.pethospital.mapper.AppointmentMapper;
import com.xhn.pethospital.mapper.PetMapper;
import com.xhn.pethospital.service.IAppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private PetMapper petMapper;
    @Override
    public IPage<Appointment> selectAppointmentPage(int pageNum, int pageSize, String param,String diagnosised,HttpSession session,String dName) {
        QueryWrapper<Appointment> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("pName",param).or().like("oName",param).or().
                    like("dName",param).or().
                    like("aoperator",param).or().
                    like("asymptoms",param);
        }
        if(StringUtils.isNotEmpty(dName)){
            queryWrapper.eq("dName",dName);
        }
        if(StringUtils.isNotEmpty(diagnosised)){
            if(diagnosised.equals("已诊断")){
                queryWrapper.eq("status",1);
            }else if (diagnosised.equals("未诊断")){
                queryWrapper.eq("status",-1);
            }else{
            }
        }

        if(session.getAttribute("loginRole").equals("医生")){
            queryWrapper.eq("dName",session.getAttribute("loginUser"));
        }else if(session.getAttribute("loginRole").equals("用户")){
            queryWrapper.eq("oName",session.getAttribute("loginUser"));
        }else{
        }
        Page<Appointment> page = new Page<>(pageNum,pageSize);
        return appointmentMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addAppointment(Appointment appointment) {
        Pet pet=new Pet();
        pet.setOName(appointment.getOName());
        pet.setPName(appointment.getPName());
        pet.setPType(appointment.getPType());
        if(petMapper.existPet(appointment.getPName(),appointment.getOName())==0){
            petMapper.insert(pet);
        }
        return appointmentMapper.insert(appointment);
    }

    @Override
    public int editAppointment(Appointment appointment) {
        return appointmentMapper.updateById(appointment);
    }

    @Override
    public Appointment queryAppointmentById(Integer id) {
        return appointmentMapper.selectById(id);
    }

    @Override
    public int delAppointmentById(Integer id) {
        return appointmentMapper.deleteById(id);
    }


    @Override
    public List<Appointment> queryAppointmentList() {
        return appointmentMapper.selectList(null);
    }
}
