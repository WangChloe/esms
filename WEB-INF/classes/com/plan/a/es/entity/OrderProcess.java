package com.plan.a.es.entity;

import java.util.Date;

/**
 * 订单流程表
 * 
 * @author a
 *
 */
public class OrderProcess extends BaseObject{
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;       //订单流程id 
	private Long orderId;  //订单id 
	private Integer stat;      //状态
	private Date crt;      //创建时间
	private Date upt;	   //更新时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + stat;
		result = prime * result + ((upt == null) ? 0 : upt.hashCode());
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
		OrderProcess other = (OrderProcess) obj;
		if (crt == null) {
			if (other.crt != null)
				return false;
		} else if (!crt.equals(other.crt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (stat != other.stat)
			return false;
		if (upt == null) {
			if (other.upt != null)
				return false;
		} else if (!upt.equals(other.upt))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderProcess [id=" + id + ", orderId=" + orderId + ", stat=" + stat + ", crt=" + crt + ", upt=" + upt
				+ "]";
	}
	
	


}
