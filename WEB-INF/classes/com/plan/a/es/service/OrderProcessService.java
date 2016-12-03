package com.plan.a.es.service;

import org.apache.log4j.Logger;

import com.plan.a.es.dao.OrderProcessDao;

public class OrderProcessService {
	Logger log = Logger.getLogger(getClass());

	private OrderProcessDao orderProcessDao;

	public OrderProcessDao getOrderProcessDao() {
		return orderProcessDao;
	}

	public void setOrderProcessDao(OrderProcessDao orderProcessDao) {
		this.orderProcessDao = orderProcessDao;
	}

	/**
	 * 取消申请单
	 * 
	 * @param id
	 * @return
	 */
	public void remove(Long orderId) {
		orderProcessDao.updateStat(orderId, 3);
	}

	/**
	 * 完成申请单
	 * 
	 * @param id
	 * @return
	 */
	public void finish(Long orderId) {
		orderProcessDao.updateStat(orderId, 4);
	}

	/**
	 * 申请单过期
	 * 
	 * @param id
	 * @return
	 */
	// TODO 如何判断过期？如何刷新过期字段？这儿没那么简单。还要再设计和编码。但是，这个功能可以暂缓。
	public void overdue(Long orderId) {
		orderProcessDao.updateStat(orderId, 5);
	}
}
