package com.plan.a.es.dao;

import java.util.List;

import com.plan.a.es.entity.Role;

/**
 * 角色表的数据库操作接口
 * 
 * @author jimmy.zhou
 *
 */
public interface RoleDao {
	
	/**
	 * 查询所有角色信息
	 * 
	 * @return
	 */
	List<Role> findAll();
	
	
}
