package com.plan.a.es.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.a.es.entity.User;

/**
 * 用户表的数据库操作接口
 * 
 * @author jimmy.zhou
 *
 */
public interface UserDao {
	
	/**
	 * 根据id查询用户记录
	 * 
	 * @param id
	 * @return
	 */
	List<User> findById(@Param("id") Long id);
	

	/**
	 * 根据userNo查询用户记录
	 * 
	 * @param id
	 * @return
	 */
	User findByUserNo(@Param("userNo") String userNo);
	
	/**
	 * 根据mobile查询用户记录
	 * 
	 * @param id
	 * @return
	 */
	User findByMobile(@Param("mobile") String mobile);
	
	/**
	 * 新建一条用户记录
	 * 
	 * @param user
	 */
	void save(@Param("user") User user);
	
	/**
	 * 更改 密码信息
	 * 
	 * @param user
	 */
	void updatePwd(@Param("id") Long id, @Param("pwd") String pwd);
	
}
