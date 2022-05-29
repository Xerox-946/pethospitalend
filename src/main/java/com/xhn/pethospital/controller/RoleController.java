package com.xhn.pethospital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.LayuiTreeTool;
import com.xhn.pethospital.entity.Menu;
import com.xhn.pethospital.entity.Role;
import com.xhn.pethospital.service.IAdminService;
import com.xhn.pethospital.service.IRoleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 角色相关的controller
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IAdminService adminService;

    /**
     * 转向角色页面
     */
    @RequestMapping
    public String role(){
        return "/role";
    }

    /**
     * 分页查询角色列表
     */
    @RequestMapping(value = "/roleQueryPage")
    @ResponseBody
    public Object roleQueryPage(String param, @RequestParam(value = "page",defaultValue = "1")int pageNum,@RequestParam(value = "limit",defaultValue = "10")int pageSize){
        try{
            IPage<Role> iPage = roleService.selectRolePage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向角色新增页面
     */
    @RequestMapping(value = "/rolePage")
    public String rolePage(){
        return "/rolePage";
    }

    /**
     * 添加一个角色
     */
    @RequestMapping(value = "/roleAdd")
    @ResponseBody
    public Object roleAdd(Role role){
        try{
            int i = roleService.addRole(role);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }


    @RequestMapping(value = "/roleQueryById")
    @ResponseBody
    public ResultMapUtil roleQueryById(@RequestParam(name = "id",required = true)Integer id){
        List<Menu> menuList=adminService.listAdminMenuTreeByRole(id);
        List<HashMap<String,Object>> result =new ArrayList<>();
        System.out.println(result);
        return ResultMapUtil.ok(fun(menuList,result));
    }
    private Object fun(List<Menu> menuList,List<HashMap<String,Object>> result){
            for(Menu m : menuList){
                HashMap<String, Object> map = new HashMap<>();
                map.put("id", m.getId());
                map.put("title", m.getMenuname());
                map.put("field",m.getMenuname());

                List<HashMap<String, Object>> result1 = new ArrayList<>();
                //这里可以根据自己需求判断节点默认选中
                if(m.getChildMenu()!=null){
                    List<Menu> children = m.getChildMenu();    //下级菜单
                    map.put("children", fun(children, result1));
                }else{
                    map.put("children",null);
                }
                if(m.getStatus() == "true" || "true".equals(m.getStatus())){
                    map.put("checked", true);    //设置为选中状态
                }else{
                    map.put("checked", false);    //设置为选中状态
                }
                map.put("spread", true);      //设置是否展开
                result.add(map);
            }
        System.out.println(result);
        return result;
    }


    /**
     * 修改一个角色
     */
    @RequestMapping(value = "/roleEdit")
    @ResponseBody
    public Object roleEdit(Role role){
        try{
            int i = roleService.editRole(role);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个角色
     */
    @RequestMapping(value = "/roleDelById")
    @ResponseBody
    public Object roleDelById(Integer id){
        try{
            int i = roleService.delRoleById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有角色
     */
    @RequestMapping(value = "/roleList")
    @ResponseBody
    public Object roleList(){
        List<Role> roleList = roleService.queryRoleList();
        return ResultMapUtil.getHashMapList(roleList);
    }

    @RequestMapping(value = "/roleInfo")
    public String RoleInfo(){
        return "/roleInfo";
    }


    @RequestMapping(value = "/roleQuery")
    @ResponseBody
    public Role roleQuery(HttpSession session){
        Role role = roleService.queryRoleById((Integer)session.getAttribute("loginId"));
        return role;
    }

    @PostMapping("/updateTree")
    @ResponseBody
    public Object updateTree(@RequestBody List<LayuiTreeTool> jsonParam,Integer id){
        List<Map<String,Object>> list=new ArrayList<>();
        int count = 0;
        try{
        if(!jsonParam.isEmpty()) {
            for(int i=0;i<jsonParam.size();i++){
                Map<String,Object> map=new HashMap<>();
                map.put("role_id",id);
                map.put("menu_id",jsonParam.get(i).getId());
                System.out.println(jsonParam.get(i).getId());
                list.add(map);
                if(!jsonParam.get(i).getChildren().isEmpty()){
                    for(int j = 0; j<jsonParam.get(i).getChildren().size(); j++){
                        Map<String,Object> map1=new HashMap<>();
                        map1.put("role_id",id);
                        map1.put("menu_id",jsonParam.get(i).getChildren().get(j).getId());
                        System.out.println(jsonParam.get(i).getChildren().get(j).getId());
                        list.add(map1);
                    }
                }
            }

            if(roleService.setFalse(id)!=0){
                for(int i=0;i<list.size();i++){
                    count=roleService.updateTree((int)list.get(i).get("role_id"),(int)list.get(i).get("menu_id"));
                }
            }

        }
        return ResultMapUtil.getHashMapSave(count);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
}





















