package com.plan.a.es.webapp.action;

import com.plan.a.es.service.OrderProcessService;

/**
 * 流程表 struts2接口类
 * 
 * @author a
 *
 */
public class OrderProcessAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private OrderProcessService orderProcessService;

	private Long orderId;

	/**
	 * 取消申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderProcess/remove.do?orderId=1
	 */
	public void remove() {
		try {
			log.info(">>enter into remove(), orderId : " + orderId);
			
			orderProcessService.remove(orderId);
			
			this.returnSuccessJson("取消申请单成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 完成申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderProcess/finish.do?orderId=1
	 */
	public void finish() {
		try {
			log.info(">>enter into finish(), orderId : " + orderId);

			orderProcessService.finish(orderId);

			this.returnSuccessJson("完成申请单成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 申请单过期
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderProcess/overdue.do?orderId=1
	 */
	public void overdue() {
		try {
			log.info(">>enter into overdue(), orderId : " + orderId);

			orderProcessService.overdue(orderId);

			this.returnSuccessJson("申请单过期成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	public OrderProcessService getOrderProcessService() {
		return orderProcessService;
	}

	public void setOrderProcessService(OrderProcessService orderProcessService) {
		this.orderProcessService = orderProcessService;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
