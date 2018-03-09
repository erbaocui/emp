package cn.com.emp.common.persistence;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
/**
 * @author cuijp cuijiapeng@gmail.com
 * @ClassName:BaseDao
 * @Description: BaseDao接口封装
 * @date 2018/3/6 16:55
 */

@SuppressWarnings("rawtypes")
public interface BaseDao<T> {
    /**
     * 新增
     * @param statementName
     * @param model
     * @throws DataAccessException
     */
    void addObject(String statementName, T model) throws DataAccessException;
    void addObject( T model) throws DataAccessException;

    /**
     * 按主键ID删除记录
     * @param statementName
     * @param objId
     * @return
     * @throws DataAccessException
     */
    int delete(String statementName,String objId) throws DataAccessException;
    int delete(String objId) throws DataAccessException;

    /**
     * 删除满足条件的所有记录
     * @param statementName
     * @param map 条件map
     * @return
     * @throws DataAccessException
     */
    int delete(String statementName,Map<String, Object> map) throws DataAccessException;
    int delete(Map<String, Object> map) throws DataAccessException;
    /**
     * 删除满足条件的所有记录
     * @param statementName
     * @param obj
     * @return
     * @throws DataAccessException
     */
    int delete(String statementName,Object obj) throws DataAccessException;
    int delete(Object obj) throws DataAccessException;

    /**
     * 按主键ID进行查找
     * @param statementName
     * @param objId 主键ID
     * @return
     * @throws DataAccessException
     */
     T findObject(String statementName,String objId) throws DataAccessException;
     T findObject(String objId) throws DataAccessException;

    /**
     * 按主键ID进行查找
     * @param statementName
     * @param obj
     * @return
     * @throws DataAccessException
     */
    T findObject(String statementName,Object obj) throws DataAccessException;
    T findObject(Object obj) throws DataAccessException;

    /**
     * 查找符合条件的对象
     * @param statementName
     * @param map 过滤条件map
     * @return
     */
    T findObject(String statementName, Map<String, Object> map);
    T findObject(Map<String, Object> map);


    /**
     * 更新对象
     * @param statementName
     * @param obj 要更新的对象
     * @return
     * @throws DataAccessException
     */
    int updateObject(String statementName,Object obj) throws DataAccessException;
    int updateObject(Object obj) throws DataAccessException;

    /**
     * 更改对象启用/停用状态
     * @param statementName
     * @param map
     * @return
     * @throws DataAccessException
     */
    int updateObject(String statementName,Map<String, Object> map) throws DataAccessException;
    int updateObject(Map<String, Object> map) throws DataAccessException;

    /**
     * 统计符合条件的记录的数目
     * @param statementName
     * @param filter sql过滤语句
     * @return
     */
    int getObjectCount(String statementName, String filter);
    int getObjectCount(String filter);

    /**
     * 统计符合条件的记录的数目
     * @param statementName
     * @param obj
     * @return
     */
    int getObjectCount(String statementName,Object obj);
    int getObjectCount(Object obj);


    /**
     * 统计符合条件的记录的数目
     * @param statementName
     * @param map 过滤条件map
     * @return
     */
    int getObjectCount(String statementName, Map<String, Object> map);
    int getObjectCount(Map<String, Object> map);



   /* *//**
     *分页查询满足给定条件的对象列表
     * @param statementName
     * @param map 过滤条件map
     * @param skipResults 跳过的记录
     * @param pageSize 一页的记录条数
     * @return
     *//*
    List listByPage(String statementName, Map<String, Object> map, int skipResults, int pageSize);

    *//**
     * 分页查询满足给定条件的对象列表
     * @param statementName
     * @param filter sql过滤语句
     * @param skipResults 跳过的记录
     * @param pageSize 一页的记录条数
     * @return
     *//*
    List listByPage(String statementName, String filter, int skipResults, int pageSize);

    *//**
     * 分页查询满足给定条件的对象列表
     * @param statementName
     * @param  obj
     * @param skipResults 跳过的记录
     * @param pageSize 一页的记录条数
     * @return
     *//*
    List listByPage(String statementName, Object obj, int skipResults, int pageSize);

    *//**
     * 查询所有满足给定条件的对象列表
     * @param statementName
     * @param filter sql过滤语句
     * @return
     */
    List<T> list(String statementName, String filter);
    List<T> list(String filter);

    /**
     * 查询所有满足给定条件的对象列表
     * @param statementName
     * @param map 过滤条件map
     * @return
     */
    List<T> list(String statementName, Map<String, Object> map);
    List<T> list( Map<String, Object> map);

    /**
     * 查询所有满足给定条件的对象列表
     * @param statementName
     * @param  obj
     * @return
     */
    List<T> list(String statementName, Object obj);
    List<T> list(Object obj);

}