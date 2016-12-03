package com.plan.a.es.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.plan.a.es.dao.OrderBaseDao;
import com.plan.a.es.dao.OrderProcessDao;
import com.plan.a.es.entity.OrderBase;
import com.plan.a.es.entity.OrderProcess;

/**
 * 订单表 相关的 业务逻辑实现
 * 
 * @author a
 *
 */
public class OrderBaseService {
	Logger log = Logger.getLogger(getClass());

	private OrderBaseDao orderBaseDao;
	private OrderProcessDao orderProcessDao;

	public OrderBaseDao getOrderBaseDao() {
		return orderBaseDao;
	}

	public void setOrderBaseDao(OrderBaseDao orderBaseDao) {
		this.orderBaseDao = orderBaseDao;
	}

	public OrderProcessDao getOrderProcessDao() {
		return orderProcessDao;
	}

	public void setOrderProcessDao(OrderProcessDao orderProcessDao) {
		this.orderProcessDao = orderProcessDao;
	}

	/**
	 * 创建申请单
	 * 
	 * @param orderBase
	 * @return
	 */
	public void establish(OrderBase orderBase) {
		// 检查参数orderBase 是否为空
		Assert.notNull(orderBase, "订单信息不存在.");

		// 检查参数 收件人Id 快递公司 快递种类 代领时间 送货时间 期望价格 备注 是否为空
		Long customerId = orderBase.getCustomerId();
		String tTime = orderBase.gettTime();
		String sTime = orderBase.getsTime();
		String notes = orderBase.getNotes();

		Assert.notNull(orderBase.getInc(), "快递公司为空");
		Assert.notNull(orderBase.getTyp(), "快递种类为空");
		Assert.notNull(orderBase.getPrice(), "期望价格为空");
		Assert.isTrue(StringUtils.isNotBlank(notes), "备注为空");
		// Assert.isTrue(StringUtils.isNotBlank(tTime), "代领时间为空");
		Assert.isTrue(StringUtils.isNotBlank(sTime), "送货时间为空");
		Assert.isTrue(StringUtils.isNotBlank(customerId + ""), "收件人为空");

		// 创建申请单
		orderBaseDao.save(orderBase);
		Long id = orderBase.getId();
		// 发布申请单
		OrderProcess orderProcess = new OrderProcess();
		orderProcess.setOrderId(id);
		orderProcessDao.save(orderProcess);
	}

	/**
	 * 查看我发布的申请单
	 * 
	 * @param customerId
	 * @return
	 */
	public List<OrderBase> findByCustomerId(Long customerId) {
		// Long customerId = orderBase.getCustomerId();
		return orderBaseDao.findByCustomerId(customerId);
	}

	/**
	 * 查看所有已发布的申请单
	 * 
	 * @return
	 */
	public List<OrderBase> findByEstablish() {
		return orderBaseDao.findByEstablish();
	}

	/**
	 * 接受申请单
	 * 
	 * @param id,agentId
	 * @return
	 */
	public void updateAgentId(Long id, Long agentId) {
		orderBaseDao.updateAgentId(id, agentId);
		orderProcessDao.updateStat(id, 2);
	}

	/**
	 * 查看我接受的申请单
	 * 
	 * 
	 */
	public List<OrderBase> findByAgentId(Long agentId) {
		return orderBaseDao.findByAgentId(agentId);
	}

	/**
	 * 查询当前所有申请单
	 * 
	 * 
	 */
	public List<OrderBase> findAll() {
		return orderBaseDao.findAll();
	}
}
