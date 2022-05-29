package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Owner;
import com.xhn.pethospital.mapper.OwnerMapper;
import com.xhn.pethospital.service.IOwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements IOwnerService {

    @Resource
    private OwnerMapper ownerMapper;
    @Override
    public IPage<Owner> selectOwnerPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owner> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("oName",param);
        }
        Page<Owner> page = new Page<>(pageNum,pageSize);
        return ownerMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addOwner(Owner owner) {
        return ownerMapper.insert(owner);
    }

    @Override
    public int editOwner(Owner owner) {
        return ownerMapper.updateById(owner);
    }

    @Override
    public Owner queryOwnerById(Integer id) {
        return ownerMapper.selectById(id);
    }

    @Override
    public int delOwnerById(Integer id) {
        return ownerMapper.deleteById(id);
    }

    @Override
    public Owner queryOwnerByAccount(Owner owner) {
        QueryWrapper<Owner> wrapper = new QueryWrapper<>();
        wrapper.eq("oAccount",owner.getOAccount());
        return ownerMapper.selectOne(wrapper);
    }

    @Override
    public List<Owner> queryOwnerList() {
        return ownerMapper.selectList(null);
    }
}
