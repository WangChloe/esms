package com.plan.a.es.entity;

import java.util.Date;

/**
 * 用户与角色关系表
 * @author a
 *
 */
public class UserRole extends BaseObject{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private Long userID;  //用户id 
	private Long roleID;  //角色id
	private Date crt;	  //创建时间
	private Date upt;     //更新时间 
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
	public Date getCrt() {
		return crt;
	}
	public void setCrt(Date crt) {
		this.crt = crt;
	}
	public Date getUpt() {
		return upt;
	}
	public void setUpt(Date upt) {
		this.upt = upt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crt == null) ? 0 : crt.hashCode());
		result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
		result = prime * result + ((upt == null) ? 0 : upt.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (crt == null) {
			if (other.crt != null)
				return false;
		} else if (!crt.equals(other.crt))
			return false;
		if (roleID == null) {
			if (other.roleID != null)
				return false;
		} else if (!roleID.equals(other.roleID))
			return false;
		if (upt == null) {
			if (other.upt != null)
				return false;
		} else if (!upt.equals(other.upt))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserRole [userID=" + userID + ", roleID=" + roleID + ", crt=" + crt + ", upt=" + upt + "]";
	}
	
	
}
