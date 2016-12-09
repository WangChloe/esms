package com.plan.a.es.webapp.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.plan.a.es.entity.User;
import com.plan.a.es.service.UserService;

/**
 * 用户表 struts2接口类
 * 
 * @author jimmy.zhou
 *
 */
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	private User user;

	/**
	 * 注册一个用户
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/user/register.do?user.mobile=111&user.name=aaa
	 * &user.pwd=3 &user.dorm=aaa&user.user_no=111
	 */
	public void register() {
		try {
			log.info(">>enter into register(), user : " + user);
			Assert.notNull(user, "参数错误：user 为空");

			Assert.isTrue(StringUtils.isNotBlank(user.getUserNo()), "参数错误：user.userNo 为空");
			Assert.isTrue(StringUtils.isNotBlank(user.getName()), "参数错误：user.name 为空");
			Assert.isTrue(StringUtils.isNotBlank(user.getDorm()), "参数错误：user.dorm 为空");
			Assert.isTrue(StringUtils.isNotBlank(user.getMobile()), "参数错误：user.mobile 为空");
			Assert.isTrue(StringUtils.isNotBlank(user.getPwd()), "参数错误：user.pwd 为空");

			userService.register(user);
			
			this.returnSuccessJson("添加账户 成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 用户登录 
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/user/login.do?user.mobile=111&user.pwd=3
	 */
	public void login() {
		try {
			log.info(">>enter into login(), user : " + user);
			Assert.notNull(user, "参数错误：user 为空");

			Assert.isTrue(StringUtils.isNotBlank(user.getMobile()), "参数错误：user.mobile 为空");
			Assert.isTrue(StringUtils.isNotBlank(user.getPwd()), "参数错误：user.pwd 为空");

			boolean b = userService.login(user);

			if (b) {
				this.returnSuccessJson("登录成功", null);
			} else {
				this.returnSuccessJson("登录失败，用户名或密码错误", null);
			}
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	// getter and setter ------------------------------
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}