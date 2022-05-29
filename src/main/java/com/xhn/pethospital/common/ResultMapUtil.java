package com.xhn.pethospital.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.pethospital.entity.Menu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 给前端返回的json格式数据
 */
public class ResultMapUtil <T> implements Serializable {

    /**
     * 请求成功
     */
    public static final int SUCCESS = 200;

    private int code;

    private String msg;

    private T data;

    private Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 服务器内部错误
     */
    public static final int DEFAULT_ERROR = 400;

    /**
     * 登录返回结果
     */
    public static HashMap<String,Object> getHashMapLogin(String msg,String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",3);
        }
        resultMap.put("anim",4);
        resultMap.put("username","");
        return resultMap;
    }

    /**
     * 分页查询结果
     */
    public static HashMap<String,Object> getHashMapMysqlPage(IPage<?> object){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.getTotal());
        resultMap.put("data",object.getRecords());
        return resultMap;
    }

    /**
     * 异常数据统一处理
     */
    public static HashMap<String,Object> getHashMapException(Exception e){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",e.getMessage());
        return resultMap;
    }

    /**
     * 保存成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapSave(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","保存失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","保存成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }
    public static HashMap<String,Object> getHashMapGH(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","挂号失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","挂号成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * 删除成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapDel(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }
    public static HashMap<String,Object> getHashMapChange(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","检查失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","检查成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * List返回格式
     */
    public static HashMap<String,Object> getHashMapList(List<?> list){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        if(list!=null&&list.size()>0){
            resultMap.put("msg","");
        }else {
            resultMap.put("msg","没有查询到数据！");
        }
        resultMap.put("data",list);
        return resultMap;
    }

    public static <T> ResultMapUtil<T> ok(T data){
        ResultMapUtil<T> ok = ok();
        ok.setData(data);
        return ok;
    }

    public static <T> ResultMapUtil<T> ok(T data,Object object){
        ResultMapUtil<T> ok = ok();
        ok.setData(data);
        ok.setObject(object);
        return ok;
    }

    public static <T> ResultMapUtil<T> ok(){
        ResultMapUtil<T> resultMap = new ResultMapUtil<>();
        resultMap.setCode(SUCCESS);
        resultMap.setMsg("success");
        return resultMap;
    }

    public static <T> ResultMapUtil<T> error(){
        ResultMapUtil<T> resultMap = new ResultMapUtil<>();
        resultMap.setCode(DEFAULT_ERROR);
        resultMap.setMsg("error");
        return  resultMap;
    }
    public static <T> ResultMapUtil<T> error(T data){
        ResultMapUtil<T> error = error();
        if (data instanceof String){
            error.setMsg((String) data);
        }
        error.setData(data);
        return error;
    }

    /**
     * 自定义错误码错误
     * @param data T
     * @param code code   403
     * @param <T> data
     * @return ResultMapUtil<T>
     */
    public static <T> ResultMapUtil<T> error(T data, int code){
        ResultMapUtil<T> error = error();
        error.setCode(code);
        error.setData(data);
        return error;
    }

}




















