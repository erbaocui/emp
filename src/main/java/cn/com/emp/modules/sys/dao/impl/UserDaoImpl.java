package cn.com.emp.modules.sys.dao.impl;

import cn.com.emp.common.persistence.impl.BaseDaoImpl;
import cn.com.emp.modules.sys.dao.UserDao;
import cn.com.emp.modules.sys.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author cuijp cuijiapeng@gmail.com
 * @ClassName:${CLASS_NAME}
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2018/3/7 12:43
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
