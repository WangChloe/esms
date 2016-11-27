package com.plan.a.es.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.a.es.entity.OrderBase;

/**
 * 订单表的数据库操作接口
 * 
 * @author a
 *
 */
public interface OrderBaseDao {

	/**
	 * 查看所有订单信息
	 * 
	 * @return
	 */
	List<OrderBase> findAll();

	/**
	 * 根据id查询订单记录
	 * 
	 * @param id
	 * @return
	 */
	OrderBase findById(@Param("id") Long id);
	
	/**
	 * 查看已发布订单信息
	 * 
	 * @param id
	 * @return
	 */
	List<OrderBase> findByEstablish();

	/**
	 * 根据customer查询用户记录
	 * 
	 * @param customerId
	 * @return
	 */
	List<OrderBase> findByCustomerId(@Param("customerId") Long customerId);

	/**
	 * 根据agent查询用户记录
	 * 
	 * @param agentId
	 * @return
	 */
	List<OrderBase> findByAgentId(@Param("agentId") Long agentId);

	/**
	 * 添加代理人id
	 * 
	 * @param orderBase
	 */
	void updateAgentId(@Param("id") Long id, @Param("agentId") Long agentId);

	/**
	 * 根据订单id删除一条订单记录
	 * 
	 * @param orderBase
	 */
	void remove(@Param("id") Long id);

	/**
	 * 插入并返回
	 * 
	 * @param orderBase
	 */
	void save(@Param("orderBase") OrderBase orderBase);
}
