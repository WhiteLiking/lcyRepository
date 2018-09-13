package com.dao.inter;

import java.util.List;

import com.vo.Orders;

public interface OrdersDAO {
	//添加订单
	public int addOrdres(Orders order);
	//修改订单
	public int updateOrders(Orders order);
	//查看全部订单
	public List<Orders> selectOrderSBySql(String sql);
	//删除订单
	public int deleteOrders(Orders order);
}
