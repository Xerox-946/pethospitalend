package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.Admin;
import com.xhn.pethospital.entity.Menu;
import com.xhn.pethospital.mapper.AdminMapper;
import com.xhn.pethospital.mapper.MenuMapper;
import com.xhn.pethospital.service.IAdminService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private MenuMapper menuMapper;
    @Override
    public IPage<Admin> selectAdminPage(int pageNum, int pageSize, String param) {
        return null;
    }

    @Override
    public int addAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int editAdmin(Admin admin) {
        return 0;
    }

    @Override
    public Admin queryAdminByAdAccount(Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("adAccount",admin.getAdAccount());
        return adminMapper.selectOne(wrapper);
    }

    @Override
    public int delAdminById(Integer id) {
        return 0;
    }

    @Override
    @Cacheable(value = "menu", key = "'listAdminMenuByRole'+#p0")
    public List<Menu> listAdminMenuByRole(Integer roleId) {
        List<Menu> menuList;
        List<Menu> newMenuList = new ArrayList<>();
        try {
            //1、根据角色获得所有的菜单（包括一级和二级）
            menuList = menuMapper.listMenuByRoleId(roleId);
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                List<Menu> childMenuList = new ArrayList<>();
                //2、拼装二级菜单
                if (menu.getPid() == 0) {
                    for (int j = 0; j < menuList.size(); j++) {
                        if (Objects.equals(menu.getId(), menuList.get(j).getPid())) {
                            childMenuList.add(menuList.get(j));
                        }
                    }
                    menu.setChildMenu(childMenuList);
                    newMenuList.add(menu);
                }
            }
        } catch (Exception e) {
            log.error("【后台菜单获取失败】，cause:{}", e);
        }
        return newMenuList;
    }
    @Override
//    @Cacheable(value = "menu", key = "'listAdminMenuTreeByRole'+#p0")
    public List<Menu> listAdminMenuTreeByRole(Integer roleId) {
        List<Menu> menuList;
        List<Menu> newMenuList = new ArrayList<>();
        try {
            //1、根据角色获得所有的菜单（包括一级和二级）
            menuList = menuMapper.listMenuTreeByRoleId(roleId);
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                List<Menu> childMenuList = new ArrayList<>();
                //2、拼装二级菜单
                if (menu.getPid() == 0) {
                    for (int j = 0; j < menuList.size(); j++) {
                        if (Objects.equals(menu.getId(), menuList.get(j).getPid())) {
                            childMenuList.add(menuList.get(j));
                        }
                    }
                    menu.setChildMenu(childMenuList);
                    newMenuList.add(menu);
                }
            }
        } catch (Exception e) {
            log.error("【后台菜单获取失败】，cause:{}", e);
        }
        return newMenuList;
    }
}
