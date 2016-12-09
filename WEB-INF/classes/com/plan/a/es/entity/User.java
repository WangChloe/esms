package com.plan.a.es.entity;

import java.util.Date;

/**
 * 用户表 实体类对象
 * 
 * @author jimmy.zhou
 *
 */
public class User extends BaseObject {
	private static final long serialVersionUID = 1L;
	
	private Long id;		// 用户id
	private String userNo; 	// 学号
	private String name;	// 姓名
	private String dorm;	// 宿舍楼
	private String mobile;	// 手机
	private String pwd;		// 密码
	private Date crt;		// 创建时间
	private Date upt;		// 更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
		result = prime * result + ((dorm == null) ? 0 : dorm.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((upt == null) ? 0 : upt.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
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
		User other = (User) obj;
		if (crt == null) {
			if (other.crt != null)
				return false;
		} else if (!crt.equals(other.crt))
			return false;
		if (dorm == null) {
			if (other.dorm != null)
				return false;
		} else if (!dorm.equals(other.dorm))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (upt == null) {
			if (other.upt != null)
				return false;
		} else if (!upt.equals(other.upt))
			return false;
		if (userNo == null) {
			if (other.userNo != null)
				return false;
		} else if (!userNo.equals(other.userNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userNo=" + userNo + ", name=" + name + ", dorm=" + dorm + ", mobile=" + mobile
				+ ", pwd=" + pwd + ", crt=" + crt + ", upt=" + upt + "]";
	}
	
}

