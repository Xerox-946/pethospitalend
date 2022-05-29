package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.StaffRoom;

public interface IStaffRoomService extends IService<StaffRoom> {
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<StaffRoom> selectStaffRoomPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息信息
     * @param staffRoom
     */
    public int addStaffRoom(StaffRoom staffRoom);

    /**
     * 修改一条账单信息信息
     * @param staffRoom
     */
    public int editStaffRoom(StaffRoom staffRoom);

    /**
     * 根据主键id查询一个账单信息对象
     * @param id
     * @return
     */
    public StaffRoom queryStaffRoomById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int delStaffRoomById(Integer id);
}
