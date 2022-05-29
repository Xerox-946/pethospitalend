package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Staff;
import com.xhn.pethospital.mapper.AdminMapper;
import com.xhn.pethospital.mapper.StaffMapper;
import com.xhn.pethospital.service.IStaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Resource
    private StaffMapper staffMapper;
    @Override
    public IPage<Staff> selectStaffPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("sName",param);
        }
        Page<Staff> page = new Page<>(pageNum,pageSize);
        return staffMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addStaff(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int editStaff(Staff staff) {
        return staffMapper.updateById(staff);
    }

    @Override
    public Staff queryStaffById(Integer id) {
        return staffMapper.selectById(id);
    }

    @Override
    public int delStaffById(Integer id) {
        return staffMapper.deleteById(id);
    }

    @Override
    public Staff queryStaffByAccount(Staff staff) {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("sAccount",staff.getSAccount());
        return staffMapper.selectOne(wrapper);
    }

    @Override
    public List<Staff> queryStaffList() {
        return staffMapper.selectList(null);
    }
}
