package com.plan.a.es.entity;

import java.util.Date;

/**
 * 订单评价表
 * @author a
 *
 */
public class OrderEvaluate extends BaseObject{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;         //id
	private Long orderId;    //订单id
	private Long owner;		 //评价方
	private Long target;	 //目标方
	private String message;  //评价
	private Integer score;		 //评分
	private Date crt;		 //创建时间
	private Date upt;		 //更新时间
	
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
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	public Long getTarget() {
		return target;
	}
	public void setTarget(Long target) {
		this.target = target;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + score;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		OrderEvaluate other = (OrderEvaluate) obj;
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
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (score != other.score)
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
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
		return "OrderEvaluate [id=" + id + ", orderId=" + orderId + ", owner=" + owner + ", target=" + target
				+ ", message=" + message + ", score=" + score + ", crt=" + crt + ", upt=" + upt + "]";
	}
	
	
	
	
}
