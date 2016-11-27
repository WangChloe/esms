package com.plan.a.es.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.plan.a.es.dao.RoleDao;
import com.plan.a.es.entity.Role;

/**
 * 角色表 相关的 业务逻辑实现
 * 
 * @author jimmy.zhou
 *
 */
public class RoleService {
	Logger log = Logger.getLogger(getClass());

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * 查询所有角色信息
	 * 
	 * @return
	 */
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}
