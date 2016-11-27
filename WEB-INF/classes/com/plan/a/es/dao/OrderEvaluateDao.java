package com.plan.a.es.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.a.es.entity.OrderEvaluate;

/**
 * 订单评价表的数据库操作接口
 * 
 * @author a
 *
 */
public interface OrderEvaluateDao {
	/**
	 * 查看所有订单流程信息
	 * 
	 * @return
	 */
	List<OrderEvaluate> findAll();

	/**
	 * 根据订单评价id查询订单记录
	 * 
	 * @param id
	 * @return
	 */
	OrderEvaluate findById(@Param("id") Long id);
	/**
	 * 根据订单id查询订单记录
	 * 
	 * @param order_id
	 * @return
	 */
	OrderEvaluate findByOrderId(@Param("orderId") Long orderId);
	/**
	 * 根据owner查询用户记录
	 * 
	 * @param owner
	 * @return
	 */
	List<OrderEvaluate> findByOwner(@Param("owner") Long owner);

	/**
	 * 根据target查询用户记录
	 * 
	 * @param target
	 * @return
	 */
	List<OrderEvaluate> findByTarget(@Param("target") Long target);
	/**
	 * 新建一条订单评价记录
	 * 
	 * @param orderBase
	 */
	void save(@Param("orderEvaluate") OrderEvaluate orderEvaluate);
	

}
