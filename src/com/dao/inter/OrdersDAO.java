package com.dao.inter;

import java.util.List;

import com.vo.Orders;

public interface OrdersDAO {
	//��Ӷ���
	public int addOrdres(Orders order);
	//�޸Ķ���
	public int updateOrders(Orders order);
	//�鿴ȫ������
	public List<Orders> selectOrderSBySql(String sql);
	//ɾ������
	public int deleteOrders(Orders order);
}
