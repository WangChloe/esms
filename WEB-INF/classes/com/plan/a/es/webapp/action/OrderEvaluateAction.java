package com.plan.a.es.webapp.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.plan.a.es.entity.OrderEvaluate;
import com.plan.a.es.service.OrderEvaluateService;

/**
 * 评价表 struts2接口类
 * 
 * @author a
 *
 */
public class OrderEvaluateAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private OrderEvaluateService orderEvaluateService;

	private OrderEvaluate orderEvaluate;

	/**
	 * 创建评价单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderEvaluate/evaluate.do?orderEvaluate.
	 * orderId=1&orderEvaluate.owner=1&orderEvaluate.target=1&orderEvaluate.
	 * score=1& orderEvaluate.message=s
	 */
	public void evaluate() {
		try {
			log.info(">>enter into evaluate(), orderEvaluate : " + orderEvaluate);
			Assert.notNull(orderEvaluate, "参数错误：orderEvaluate 为空");

			Assert.isTrue(StringUtils.isNotBlank(orderEvaluate.getOrderId() + ""), "参数错误：订单编号为空");
			Assert.isTrue(StringUtils.isNotBlank(orderEvaluate.getOwner() + ""), "参数错误：评价方为空");
			Assert.isTrue(StringUtils.isNotBlank(orderEvaluate.getTarget() + ""), "参数错误：目标方为空");
			Assert.isTrue(StringUtils.isNotBlank(orderEvaluate.getScore() + ""), "参数错误：评分为空");
			Assert.notNull(orderEvaluate.getMessage(), "参数错误：评价为空");

			orderEvaluateService.evaluate(orderEvaluate);

			this.returnSuccessJson("创建评价单成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	public OrderEvaluateService getOrderEvaluateService() {
		return orderEvaluateService;
	}

	public void setOrderEvaluateService(OrderEvaluateService orderEvaluateService) {
		this.orderEvaluateService = orderEvaluateService;
	}

	public OrderEvaluate getOrderEvaluate() {
		return orderEvaluate;
	}

	public void setOrderEvaluate(OrderEvaluate orderEvaluate) {
		this.orderEvaluate = orderEvaluate;
	}

}
