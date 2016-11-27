package com.plan.a.es.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plan.a.es.entity.OrderProcess;

/**
 * 订单流程表的数据库操作接口
 * 
 * @author a
 *
 */
public interface OrderProcessDao {
	/**
	 * 查看所有订单流程信息
	 * 
	 * @return
	 */
	List<OrderProcess> findAll();

	/**
	 * 根据订单流程id查询订单记录
	 * 
	 * @param id
	 * @return
	 */
	OrderProcess findById(@Param("id") Long id);
	/**
	 * 根据订单id查询订单记录
	 * 
	 * @param orderId
	 * @return
	 */
	OrderProcess findByOrderId(@Param("orderId") Long orderId);
	/**
	 * 根据订单状态查询订单记录
	 * 
	 * @param stat
	 * @return
	 */
	
	List<OrderProcess> findByStat(@Param("stat") int stat);
	/**
	 * 新建一条订单流程记录
	 * 
	 * @param orderProcess
	 */
	void save(@Param("orderProcess") OrderProcess orderProcess);
	/**
	 * 更改订单流程状态
	 * 
	 * @param orderProcess
	 */
	void updateStat(@Param("orderId") Long orderId, @Param("stat") int stat);

	
}
