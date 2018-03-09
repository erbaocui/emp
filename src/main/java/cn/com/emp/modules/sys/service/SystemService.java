/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.emp.modules.sys.service;



import cn.com.emp.modules.sys.dao.UserDao;
import cn.com.emp.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService  {
	
	public static final String HASH_ALGORITHM = "SHA-1";

	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public List<User> queryUserListByEntity(User user){
     return  userDao.list(user);
	}






}
