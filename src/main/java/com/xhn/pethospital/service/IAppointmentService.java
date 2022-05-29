package com.xhn.pethospital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.pethospital.entity.Appointment;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IAppointmentService extends IService<Appointment> {
    /**
     * 分页查询挂号单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-挂号单信息名称
     * @return
     */
    public IPage<Appointment> selectAppointmentPage(int pageNum, int pageSize, String param,String diagnosised, HttpSession session,String dName);

    /**
     * 新增一条挂号单信息信息
     * @param appointment
     */
    public int addAppointment(Appointment appointment);

    /**
     * 修改一条挂号单信息信息
     * @param appointment
     */
    public int editAppointment(Appointment appointment);

    /**
     * 根据主键id查询一个挂号单信息对象
     * @param id
     * @return
     */
    public Appointment queryAppointmentById(Integer id);

    /**
     * 根据主键id删除一个挂号单信息对象
     * @param id
     * @return
     */
    public int delAppointmentById(Integer id);


    public List<Appointment> queryAppointmentList();
}
