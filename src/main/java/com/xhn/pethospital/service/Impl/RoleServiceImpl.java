package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Role;
import com.xhn.pethospital.mapper.RoleMapper;
import com.xhn.pethospital.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;
    @Override
    public IPage<Role> selectRolePage(int pageNum, int pageSize, String param) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("description",param);
        }
        Page<Role> page = new Page<>(pageNum,pageSize);
        return roleMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int editRole(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public Role queryRoleById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int delRoleById(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public List<Role> queryRoleList() {
        return roleMapper.selectList(null);
    }

    @Override
    public int setFalse(int rid) {
        return roleMapper.setFalse(rid);
    }

    @Override
    public int updateTree(int rid,int mid) {
        return roleMapper.updateTree(rid,mid);
    }
}
