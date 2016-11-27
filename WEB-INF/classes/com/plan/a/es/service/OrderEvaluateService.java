package com.plan.a.es.service;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.plan.a.es.dao.OrderEvaluateDao;
import com.plan.a.es.dao.OrderProcessDao;
import com.plan.a.es.entity.OrderEvaluate;

public class OrderEvaluateService {
	Logger log = Logger.getLogger(getClass());

	private OrderEvaluateDao orderEvaluateDao;
	private OrderProcessDao orderProcessDao;

	public OrderEvaluateDao getOrderEvaluateDao() {
		return orderEvaluateDao;
	}

	public void setOrderEvaluateDao(OrderEvaluateDao orderEvaluateDao) {
		this.orderEvaluateDao = orderEvaluateDao;
	}

	public OrderProcessDao getOrderProcessDao() {
		return orderProcessDao;
	}

	public void setOrderProcessDao(OrderProcessDao orderProcessDao) {
		this.orderProcessDao = orderProcessDao;
	}

	/**
	 * 创建评价表
	 * 
	 * @param orderEvaluate
	 * @return
	 */
	public void evaluate(OrderEvaluate orderEvaluate) {
		// 检查参数orderEvaluate 是否为空
		Assert.notNull(orderEvaluate, "订单信息不存在.");

		// 检查参数 订单编号 评价方 目标方 评价 评分 是否为空
		Long orderId = orderEvaluate.getOrderId();
		Long owner = orderEvaluate.getOwner();
		Long target = orderEvaluate.getTarget();
		int score = orderEvaluate.getScore();

		Assert.isTrue(StringUtils.isNotBlank(orderId + ""), "订单编号为空");
		Assert.isTrue(StringUtils.isNotBlank(owner + ""), "评价方为空");
		Assert.isTrue(StringUtils.isNotBlank(target + ""), "目标方为空");
		Assert.isTrue(StringUtils.isNotBlank(score + ""), "评分为空");
		Assert.notNull(orderEvaluate.getMessage(), "评价为空");

		// 创建评价表
		orderEvaluateDao.save(orderEvaluate);
		// 申请单评价
		orderProcessDao.updateStat(orderId, 5);
	}
}
