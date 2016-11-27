package com.plan.a.es.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.plan.a.es.dao.UserDao;
import com.plan.a.es.entity.User;

/**
 * 用户表 相关的 业务逻辑实现
 * 
 * @author jimmy.zhou
 *
 */
public class UserService {
	Logger log = Logger.getLogger(getClass());

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public void register(User user) {
		// 检查参数user 是否为空
		Assert.notNull(user, "用户信息不存在。");

		// 检查参数 手机号 学号 姓名 宿舍楼 密码 是否为空
		String mobile = user.getMobile();
		String userNo = user.getUserNo();
		String name = user.getName();
		String dorm = user.getDorm();
		String pwd = user.getPwd();

		Assert.isTrue(StringUtils.isNotBlank(mobile), "手机号为空");
		Assert.isTrue(StringUtils.isNotBlank(userNo), "学号为空");
		Assert.isTrue(StringUtils.isNotBlank(name), "姓名为空");
		Assert.isTrue(StringUtils.isNotBlank(dorm), "宿舍为空");
		Assert.isTrue(StringUtils.isNotBlank(pwd), "密码为空");

		// 判断，在数据库中，是否存在了相同手机号的用户
		User existsMobile = userDao.findByMobile(mobile);
		Assert.isNull(existsMobile, "手机号已经被使用");

		// 判断，在数据库中，是否存在了相同学号的用户
		User existsUserNo = userDao.findByUserNo(userNo);
		Assert.isNull(existsUserNo, "学号已经被使用");

		// 注册
		userDao.save(user);
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public boolean login(User user) {
		// 检查参数user 是否为空
		Assert.notNull(user, "用户信息不存在。");

		// 检查参数 手机号 和 学号 是否为空
		String mobile = user.getMobile();
		String pwd = user.getPwd();

		Assert.isTrue(StringUtils.isNotBlank(mobile), "手机号为空");
		Assert.isTrue(StringUtils.isNotBlank(pwd), "密码为空");

		// 判断，在数据库中，是否存在了相同手机号的用户
		User existsMobile = userDao.findByMobile(mobile);
		if (existsMobile != null) {
			if (pwd.equals(existsMobile.getPwd())) {
				log.info("登录成功");
				return true;
			} else {
				log.info("密码输入错误");
				return false;
			}

		}
		return false;

	}
}
