package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Medicine;
import com.xhn.pethospital.mapper.MedicineMapper;
import com.xhn.pethospital.service.IMedicineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {

    @Resource
    private MedicineMapper medicineMapper;
    @Override
    public IPage<Medicine> selectMedicinePage(int pageNum, int pageSize, String param) {
        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mName",param);
        }
        Page<Medicine> page = new Page<>(pageNum,pageSize);
        return medicineMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addMedicine(Medicine medicine) {
        return medicineMapper.insert(medicine);
    }

    @Override
    public int editMedicine(Medicine medicine) {
        return medicineMapper.updateById(medicine);
    }

    @Override
    public Medicine queryMedicineById(Integer id) {
        return medicineMapper.selectById(id);
    }

    @Override
    public int delMedicineById(Integer id) {
        return medicineMapper.deleteById(id);
    }

//    @Override
//    public Medicine queryMedicineByAccount(Medicine medicine) {
//        QueryWrapper<Medicine> wrapper = new QueryWrapper<>();
//        wrapper.eq("dAccount",medicine.getDAccount());
//        return medicineMapper.selectOne(wrapper);
//    }

    @Override
    public List<Medicine> queryMedicineList() {
        return medicineMapper.selectList(null);
    }
}
