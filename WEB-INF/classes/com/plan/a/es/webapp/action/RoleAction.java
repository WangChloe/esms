package com.plan.a.es.webapp.action;

import java.util.List;

import com.plan.a.es.entity.Role;
import com.plan.a.es.service.RoleService;

/**
 * 角色表 struts2接口类
 * 
 * @author a
 *
 */
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private RoleService roleService;

	/**
	 * 查看所有角色
	 * 
	 * 这个demo方法对应的url地址为： 
	 * http://localhost:8080/esms/role/findAll.do
	 */
	public void findAll() {
		try {
			log.info(">>enter into findAll() ... ");
			List<Role> data = roleService.findAll();
			this.returnSuccessJson(data);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
