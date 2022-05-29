package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Pet;
import com.xhn.pethospital.entity.Pet;
import com.xhn.pethospital.mapper.PetMapper;
import com.xhn.pethospital.mapper.PetMapper;
import com.xhn.pethospital.service.IOwnerService;
import com.xhn.pethospital.service.IPetService;
import org.apache.ibatis.annotations.Select;
import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements IPetService {
    @Resource
    private PetMapper petMapper;

    @Override
    public IPage<Pet> selectPetPage(int pageNum, int pageSize, String param, HttpSession session,String type) {
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("pName",param);
        }
        if(StringUtils.isNotEmpty(type)){
            queryWrapper.like("pType",type);
        }
        if(session.getAttribute("loginRole").equals("用户")){
            queryWrapper.eq("oName",session.getAttribute("loginUser"));
        }else{
        }
        Page<Pet> page = new Page<>(pageNum,pageSize);
        return petMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addPet(Pet pet) {
        return petMapper.insert(pet);
    }

    @Override
    public int editPet(Pet pet) {
        return petMapper.updateById(pet);
    }

    @Override
    public Pet queryPetById(Integer id) {
        return petMapper.selectById(id);
    }

    @Override
    public int delPetById(Integer id) {
        return petMapper.deleteById(id);
    }


    @Override
    public List<Pet> queryPetList() {
        return petMapper.selectList(null);
    }

    @Override
    public List<String> queryPetTypeList() {
        return petMapper.getPTypeList();
    }
}
