package com.plan.a.es.webapp.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.plan.a.es.entity.OrderBase;
import com.plan.a.es.service.OrderBaseService;

/**
 * 订单表 struts2接口类
 * 
 * @author a
 *
 */
public class OrderBaseAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private OrderBaseService orderBaseService;

	private OrderBase orderBase;
	private Long customerId;
	private Long agentId;
	private Long id;

	/**
	 * 创建一个申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderBase/establish.do?orderBase.customerId=1& ...
	 * 
	 */
	public void establish() {
		try {
			log.info(">>enter into establish(), orderBase : " + orderBase);
			Assert.notNull(orderBase, "参数错误：orderBase 为空");

			Assert.notNull(orderBase.getInc(), "参数错误：快递公司为空");
			Assert.notNull(orderBase.getTyp(), "参数错误：快递种类为空");
			Assert.notNull(orderBase.getPrice(), "参数错误：期望价格为空");
//			Assert.isTrue(StringUtils.isNotBlank(orderBase.gettTime()), "参数错误：代领时间为空");
//			Assert.isTrue(StringUtils.isNotBlank(orderBase.getsTime()), "参数错误：送货时间为空");
			Assert.isTrue(StringUtils.isNotBlank(orderBase.getNotes()), "参数错误：备注为空");
			Assert.isTrue(StringUtils.isNotBlank(orderBase.getCustomerId() + ""), "参数错误：收件人为空");

			orderBaseService.establish(orderBase);

			this.returnSuccessJson("创建申请单成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 查看我发布的申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderBase/findByCustomerId.do?customerId=1
	 * 
	 */
	public void findByCustomerId() {
		try {
			log.info(">>enter into findByCustomerId(), customerId : " + customerId);

			Assert.notNull(customerId, "参数错误：收件人为空");
			
			List<OrderBase> data = orderBaseService.findByCustomerId(customerId);
			
			this.returnSuccessJson(data);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 查看所有已发布的申请单
	 * 
	 * 这个demo方法对应的url地址为： 
	 * http://localhost:8080/esms/orderBase/findByEstablish.do
	 */
	public void findByEstablish() {
		try {
			log.info(">>enter into findByEstablish() ... ");

			List<OrderBase> data = orderBaseService.findByEstablish();

			this.returnSuccessJson(data);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 接受申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderBase/updateAgentId.do?id=1&agentId=2
	 * 
	 */
	public void updateAgentId() {
		try {
			log.info(">>enter into updateAgentId(), id : " + id + ", agentId : " + agentId);
			
			Assert.notNull(agentId, "参数错误：agentId为空");
			Assert.notNull(id, "参数错误：id 为空");
			
			orderBaseService.updateAgentId(id, agentId);

			this.returnSuccessJson("接受申请单成功", null);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 查看我接受的申请单
	 * 
	 * 这个demo方法对应的url地址为：
	 * http://localhost:8080/esms/orderBase/findByAgentId.do?agentId=1
	 */
	public void findByAgentId() {
		try {
			log.info(">>enter into findByAgentId(), agentId : " + agentId);
			
			Assert.notNull(agentId, "参数错误：agentId为空");
			
			List<OrderBase> data = orderBaseService.findByAgentId(agentId);
			
			this.returnSuccessJson(data);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	/**
	 * 查看所有申请单
	 * 
	 * 这个demo方法对应的url地址为： 
	 * http://localhost:8080/esms/orderBase/findAll.do
	 */
	public void findAll() {
		try {
			log.info(">>enter into findAll() ... ");

			List<OrderBase> data = orderBaseService.findAll();
			
			this.returnSuccessJson(data);
		} catch (Exception e) {
			log.error(e, e);
			returnExceptionJson(e);
		}
	}

	public OrderBaseService getOrderBaseService() {
		return orderBaseService;
	}

	public void setOrderBaseService(OrderBaseService orderBaseService) {
		this.orderBaseService = orderBaseService;
	}

	public OrderBase getOrderBase() {
		return orderBase;
	}

	public void setOrderBase(OrderBase orderBase) {
		this.orderBase = orderBase;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
