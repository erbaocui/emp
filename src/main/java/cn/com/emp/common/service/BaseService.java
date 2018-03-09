package cn.com.emp.common.service;

import cn.com.emp.common.persistence.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author cuijp cuijiapeng@gmail.com
 * @ClassName:BaseService
 * @Description: 基础芳芳
 * @date 2018/3/6 23:33
 */
public abstract class BaseService<T>{

        /**
         * 日志对象
         */
        protected Logger logger = LoggerFactory.getLogger(getClass());

    public abstract BaseDao<T> getBaseDao();

    /**
     * 增加对象
     * @param model
     */
    public void create(T model){
        getBaseDao().addObject(model);
    }

    /**
     * 更新对象
     * @param  obj
     * @return
     */
    public void modify(Object obj){
        getBaseDao().updateObject(obj);
    }

    /**
     *条件查询单个对象
     * @param  obj
     * @return
     */
    public T queryEntityByObject(Object obj){
       return getBaseDao().findObject(obj);
    }

    /**
     *条件查询单个对象
     * @param  map
     * @return
     */
    public T queryEntityByMap(Map<String,Object> map ){
        return getBaseDao().findObject(map);
    }
    /**
     * id查询单个对象
     * @param  id
     * @return
     */
    public T queryEntityById(String id){
        return getBaseDao().findObject(id);
    }
    /**
     * id删除对象
     * @param  id
     * @return
     */
    public void deleteById(String id){
        getBaseDao().delete(id);
    }

    /**
     * 查询列表
     * @param  obj
     * @return
     */
    public List<T> queryListByObject(Object obj){
       return getBaseDao().list(obj);
    }
    /**
     * 查询列表
     * @param  map
     * @return
     */
    public List<T> queryListByMap(Map<String,Object> map){
        return getBaseDao().list(map);
    }

}
