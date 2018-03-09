package cn.com.emp.common.persistence.impl;
import java.util.List;
import java.util.Map;

import cn.com.emp.common.persistence.BaseDao;
import cn.com.emp.common.util.GenericsUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
/**
 * @author cuijp cuijiapeng@gmail.com
 * @ClassName:${CLASS_NAME}
 * @Description: 封装实现类
 * @date 2018/3/6 16:55
 */
@SuppressWarnings("rawtypes")
public class BaseDaoImpl<T>  extends SqlSessionDaoSupport implements BaseDao<T> {

    private Logger logger = Logger.getLogger(BaseDaoImpl.class);
    protected Class<T> entityClass;
    protected String sqlMapNamespace;

    //使用sqlSessionFactory
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
    {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public static final String POSTFIX_SELECT_OBJECT = "Dao.selectObject";
    public static final String POSTFIX_SELECT_COUNT = "Dao.selectCount";
    public static final String POSTFIX_SELECT_LIST= "Dao.selectList";
    public static final String POSTFIX_INSERT = "Dao.insert";
    public static final String POSTFIX_UPDATE = "Dao.update";
    public static final String POSTFIX_DELETE = "Dao.delete";

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = GenericsUtils.getSuperClassGenricType(getClass());
        sqlMapNamespace = entityClass.getName();
    }
    //add
    @Override
    public void addObject(String statementName, T model)
            throws DataAccessException {
        getSqlSession().insert(statementName,model);
    }
    @Override
    public void addObject(T model)
            throws DataAccessException {
        getSqlSession().insert(sqlMapNamespace+POSTFIX_INSERT,model);
    }

    @Override
    public int delete(String statementName, String objId)
            throws DataAccessException {
        return getSqlSession().delete(statementName, objId);
    }
    @Override
    public int delete( String objId)
            throws DataAccessException {
        return getSqlSession().delete(sqlMapNamespace+POSTFIX_DELETE, objId);
    }

    @Override
    public int delete(String statementName,Map<String, Object> map) throws DataAccessException {
        return getSqlSession().delete(statementName, map);
    }
    @Override
    public int delete(Map<String, Object> map) throws DataAccessException {
        return getSqlSession().delete(sqlMapNamespace+POSTFIX_DELETE, map);
    }

    @Override
    public int delete(String statementName, Object obj) throws DataAccessException {
        return getSqlSession().delete(statementName,obj);
    }
    @Override
    public int delete(Object obj) throws DataAccessException {
        return getSqlSession().delete(sqlMapNamespace+POSTFIX_DELETE,obj);
    }


    @Override
    public T findObject(String statementName, String objId)
            throws DataAccessException {
        return getSqlSession().selectOne(statementName , objId);
    }
    @Override
    public T findObject(String objId)
            throws DataAccessException {
        return getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_OBJECT , objId);
    }

    @Override
    public T findObject(String statementName, Object obj) throws DataAccessException {
        return getSqlSession().selectOne(statementName, obj);
    }
    @Override
    public T findObject( Object obj) throws DataAccessException {
        return getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_OBJECT, obj);
    }
    @Override
    public T findObject(String statementName, Map<String, Object> map) {
        return getSqlSession().selectOne(statementName, map);
    }
    @Override
    public T findObject(Map<String, Object> map) {
        return getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_OBJECT, map);
    }


    @Override
    public int updateObject(String statementName, Object obj)
            throws DataAccessException {
        return getSqlSession().update(statementName,  obj);
    }
    @Override
    public int updateObject( Object obj)
            throws DataAccessException {
        return getSqlSession().update(sqlMapNamespace+POSTFIX_UPDATE,  obj);
    }


    @Override
    public int updateObject(String statementName, Map<String, Object> map) throws DataAccessException {
        return getSqlSession().update( statementName, map);
    }
    @Override
    public int updateObject(Map<String, Object> map) throws DataAccessException {
        return getSqlSession().update(sqlMapNamespace+POSTFIX_UPDATE, map);
    }




    @Override
    public int getObjectCount(String statementName, String filter) {
        Long result = getSqlSession().selectOne(statementName, filter);
        return  result.intValue();
    }
    @Override
    public int getObjectCount(String filter) {
        Long result = getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_COUNT, filter);
        return  result.intValue();
    }

    @Override
    public int getObjectCount(String statementName, Map<String,Object> map) {
        Long result = getSqlSession().selectOne(statementName, map);
        return  result.intValue();
    }
    @Override
    public int getObjectCount( Map<String,Object> map) {
        Long result = getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_COUNT, map);
        return  result.intValue();
    }
    @Override
    public int getObjectCount(String statementName, Object obj) {
        Long result = getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_COUNT, obj);
        return result.intValue();
    }
    @Override
    public int getObjectCount(Object obj) {
        Long result = getSqlSession().selectOne(sqlMapNamespace+POSTFIX_SELECT_COUNT, obj);
        return result.intValue();
    }
   /*
    * 不要用 begin 加分页
   *//*
    @Override
    public List listByPage(String statementName, Map<String, Object> map,
                           int skipResults, int pageSize) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST, map, new RowBounds(skipResults, pageSize));
    }

    @Override
    public List listByPage(String statementName, String filter, int skipResults, int pageSize) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST, filter, new RowBounds(skipResults, pageSize));
    }
    @Override
    public List listByPage(String statementName, Object obj, int skipResults, int pageSize) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST, obj, new RowBounds(skipResults, pageSize));
    }
   *//*
    * 不要用 end
   */

    @Override
    public List<T> list(String statementName, String filter) {
        return (List<T>)getSqlSession().selectList(statementName, filter);
    }
    @Override
    public List<T> list(String filter) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST, filter);
    }

    @Override
    public List<T> list(String statementName, Map<String, Object> map) {
        return getSqlSession().selectList(statementName, map);
    }
    @Override
    public List<T> list(Map<String, Object> map) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST, map);
    }

    @Override
    public  List<T> list(String statementName, Object obj) {
        return getSqlSession().selectList(statementName,obj);
    }
    @Override
    public List<T> list(Object obj) {
        return getSqlSession().selectList(sqlMapNamespace+POSTFIX_SELECT_LIST,obj);
    }
}