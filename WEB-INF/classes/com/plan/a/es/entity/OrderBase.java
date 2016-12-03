package com.plan.a.es.entity;

import java.util.Date;

/**
 * 订单表
 * 
 * @author a
 *
 */
public class OrderBase extends BaseObject {

	private static final long serialVersionUID = 1L;

	private Long id; // 订单id
	private Long customerId; // 收件人id
	private Long agentId; // 代理人id
	private Integer inc; // 快递公司
	private Integer typ; // 快递种类
	private String tTime; // 代领时间段
	private String sTime; // 送货时间段
	private Integer price; // 期望价格
	private String notes; // 备注
	private Date crt; // 创建时间
	private Date upt; // 更新时间

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Integer getInc() {
		return inc;
	}

	public void setInc(Integer inc) {
		this.inc = inc;
	}

	public Integer getTyp() {
		return typ;
	}

	public void setTyp(Integer typ) {
		this.typ = typ;
	}

	public String gettTime() {
		return tTime;
	}

	public void settTime(String tTime) {
		this.tTime = tTime;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
		result = prime * result + ((agentId == null) ? 0 : agentId.hashCode());
		result = prime * result + ((crt == null) ? 0 : crt.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + inc;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + price;
		result = prime * result + ((sTime == null) ? 0 : sTime.hashCode());
		result = prime * result + ((tTime == null) ? 0 : tTime.hashCode());
		result = prime * result + typ;
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
		OrderBase other = (OrderBase) obj;
		if (agentId == null) {
			if (other.agentId != null)
				return false;
		} else if (!agentId.equals(other.agentId))
			return false;
		if (crt == null) {
			if (other.crt != null)
				return false;
		} else if (!crt.equals(other.crt))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inc != other.inc)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (price != other.price)
			return false;
		if (sTime == null) {
			if (other.sTime != null)
				return false;
		} else if (!sTime.equals(other.sTime))
			return false;
		if (tTime == null) {
			if (other.tTime != null)
				return false;
		} else if (!tTime.equals(other.tTime))
			return false;
		if (typ != other.typ)
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
		return "OrderBase [id=" + id + ", customerId=" + customerId + ", agentId=" + agentId + ", inc=" + inc + ", typ="
				+ typ + ", tTime=" + tTime + ", sTime=" + sTime + ", price=" + price + ", notes=" + notes + ", crt="
				+ crt + ", upt=" + upt + "]";
	}

}
