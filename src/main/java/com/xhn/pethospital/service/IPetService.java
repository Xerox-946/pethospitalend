package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.common.ResultMapUtil;
import com.xhn.pethospital.entity.Pet;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IPetService extends IService<Pet> {
    /**
     * 分页查询宠物信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-宠物信息名称
     * @return
     */
    public IPage<Pet> selectPetPage(int pageNum, int pageSize, String param, HttpSession session,String type);

    /**
     * 新增一条宠物信息信息
     * @param pet
     */
    public int addPet(Pet pet);

    /**
     * 修改一条宠物信息信息
     * @param pet
     */
    public int editPet(Pet pet);

    /**
     * 根据主键id查询一个宠物信息对象
     * @param id
     * @return
     */
    public Pet queryPetById(Integer id);

    /**
     * 根据主键id删除一个宠物信息对象
     * @param id
     * @return
     */
    public int delPetById(Integer id);


    public List<Pet> queryPetList();

    public List queryPetTypeList();
}
