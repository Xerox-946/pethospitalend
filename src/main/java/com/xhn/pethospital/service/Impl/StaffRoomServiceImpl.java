package com.xhn.pethospital.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.pethospital.entity.StaffRoom;
import com.xhn.pethospital.mapper.StaffRoomMapper;
import com.xhn.pethospital.service.IStaffRoomService;

public class StaffRoomServiceImpl extends ServiceImpl<StaffRoomMapper, StaffRoom> implements IStaffRoomService {
    @Override
    public IPage<StaffRoom> selectStaffRoomPage(int pageNum, int pageSize, String param) {
        return null;
    }

    @Override
    public int addStaffRoom(StaffRoom staffRoom) {
        return 0;
    }

    @Override
    public int editStaffRoom(StaffRoom staffRoom) {
        return 0;
    }

    @Override
    public StaffRoom queryStaffRoomById(Integer id) {
        return null;
    }

    @Override
    public int delStaffRoomById(Integer id) {
        return 0;
    }
}
