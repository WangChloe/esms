package com.plan.a.es.dto;

import java.io.Serializable;

/**
 * 前端交互接口，返回对象格式封装
 * 
 * @author jimmy.zhou
 *
 */
public class BaseResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;	// 状态编。0表示成功，1表示失败
	private String msg;		// 状态信息。文字
	private Object data;	// 数据信息。
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
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
		BaseResult other = (BaseResult) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseResult [code=" + code + ", msg=" + msg + ", data=" + data
				+ "]";
	}
}
