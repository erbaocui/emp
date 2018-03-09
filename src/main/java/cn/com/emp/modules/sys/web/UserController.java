/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.com.emp.modules.sys.web;


import cn.com.emp.common.web.BaseController;
import cn.com.emp.modules.sys.entity.User;
import cn.com.emp.modules.sys.service.SystemService;

import com.cn.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "/sys/user")
public class UserController extends BaseController {

	@Autowired
	private SystemService systemService;

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}


	/**
	 * 用户列表查询
	 * @param
	 *
	 * @return listMenu json
	 */
	@RequestMapping(value = "/list")
	public @ResponseBody
	PageInfo list(@RequestParam(value="page", required=false) String page,
			 @RequestParam(value="rows", required=false) String rows,
			 String loginName,String displayName,String status)throws Exception
	{
		PageHelper.startPage(Integer.valueOf(page) ,Integer.valueOf(rows));
		User user=new User();
		if(StringUtil.isNotEmpty(loginName)){
			user.setLoginName(loginName);
		}

		List<User> list=systemService.queryUserListByEntity(user);

		PageInfo<User> p=new PageInfo<User>(list);
		return p;
	}

}
