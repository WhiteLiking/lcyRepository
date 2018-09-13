package com.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.util.OracleUtil;
import com.dao.inter.OrdersDAO;
import com.vo.Category;
import com.vo.Orders;

public class OrderDaoImple implements OrdersDAO {
	private Connection conn;

	public OrderDaoImple() {
		conn = OracleUtil.getConnection();
	}
	//��Ӷ���
	public int addOrdres(Orders o) {
		int acount = -1;
		//����ͨ��
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";//�������sql�����ַ��� 
		PreparedStatement preparedStatement = null;//���preparedStatement��������
		try {
			preparedStatement = conn.prepareStatement(sql);//����ͨ��
			//������
			preparedStatement.setInt(1,o.getOid());//����1������ֵ
			preparedStatement.setString(2,o.getOname());//����2������ֵ
			preparedStatement.setFloat(3,o.getPrice());//����3������ֵ
			preparedStatement.setInt(4,o.getPsum());//����4������ֵ
			preparedStatement.setString(5,o.getName());
			preparedStatement.setString(6,o.getTelephone());
			preparedStatement.setString(7,o.getAderss());
			preparedStatement.setString(8,o.getUserno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ͨ��ʧ��");//�쳣����
			e.printStackTrace();
		}
		
		try {
			//ִ�в����ؽ��������Ҫִ��DDL��DML��䣬����DDL��䣬���ص�����Ӱ���������
			//����û��û�з������ͣ�����DDL����0
			acount = preparedStatement.executeUpdate();
			//�������,�൱�ڲ��Զ��ύ,���������񣬲��ܹر�ͨ�������ӡ��ع���conn.rollback();
			//conn.setAutoCommit(false);
			if(acount>=1){
				System.out.println("�����Ʒ�ɹ���");
			}else{
				System.out.println("û������κ���Ʒ��");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ִ�����ʧ��");
			e.printStackTrace();
		}finally{
			
			//�ر�ͨ����PreparedStatement��connection��
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("�ر�ͨ��ʧ��");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�connͨ��ʧ��");
				}
			}
		}
		return acount;
	}

	//�޸Ķ���
	public int updateOrders(Orders o) {
		int count = 0;
		// 3.����ͨ��
		String sql = "update orders set pname=?,price=?,psum=?,name=?,telephone=?,adress=?,userno=? where oid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, o.getOname());
			pstmt.setInt(2, o.getPrice());
			pstmt.setInt(3, o.getPsum());
			pstmt.setString(4, o.getName());
			pstmt.setString(5, o.getTelephone());
			pstmt.setString(6,o.getAderss());
			pstmt.setString(7, o.getUserno());
			pstmt.setInt(8, o.getOid());
			// 4.ִ�в����ؽ����
			count = pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
											// DCL��DDL��� ����ֵ��0
			if (count >= 1) {
				System.out.println("�޸ĳɹ�!");
			} else {
				System.out.println("�޸�ʧ��!");
			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����޸�ʧ��");
			e.printStackTrace();
		}finally{
			//�ر�ͨ��������
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("���ڹر�ͨ��ʧ��");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("�����쳣�޷��ر������ݿ������");
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	public List<Orders> selectOrderSBySql(String sql) {
		//����
		List<Orders> listOrders = new ArrayList<Orders>();
		//Category category = null;
		ResultSet rs = null;
		Statement st = null;
		//����ͨ��
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("����ͨ��ʧ�ܣ�");
			e.printStackTrace();
		}
		//ִ�в���
	
		try {
			rs = st.executeQuery(sql);
			if(rs==null){
				System.out.println("ͨ��sql����ѯʧ�ܣ�������䲻�Ϸ�");
			}else{
				
				System.out.println("ͨ��sql����ѯ�ɹ���");
				//���������������
				while(rs.next()){
					Orders o = new Orders();
					o.setOid(rs.getInt("oid"));
					o.setOname(rs.getString("pname"));
					o.setPrice(rs.getInt("price"));
					o.setPsum(rs.getInt("psum"));
					o.setName(rs.getString("name"));
					o.setTelephone(rs.getString("telephone"));
					o.setAderss(rs.getString("adress"));
					o.setUserno(rs.getString("userno"));
					listOrders.add(o);
					
				}
			}
		} catch (SQLException e) {
			System.out.println("ִ�в���ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("�ر�ͨ��ʧ�ܣ�");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("�����ݿ�����ӹر�ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
		return listOrders;
	}
	
	//ɾ������
	public int deleteOrders(Orders order){
		int count = -1;
		// 3.����ͨ��
		String sql = "delete from Orders where oid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, order.getOid());

			// 4.ִ�в����ؽ����
			
			count = pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
			System.out.println(count);							// DCL��DDL��� ����ֵ��0

			if (count >= 1) {
				System.out.println("ɾ���ɹ�!");
			} else {
				System.out.println("û��ɾ��!");
			}
		} catch (SQLException e) {
			System.out.println("����ͨ����ɾ����Ʒ����ʧ��");
			e.printStackTrace();
			
		} finally {
			// 5.�ر�
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ʧ��");
				}
			}
		}

		return count;
	}
	
	
	
	
	public static void main(String[] args) {
		Orders order = new Orders();
		OrderDaoImple dao = new OrderDaoImple();
		order.setOid(0);
		System.out.println(dao.deleteOrders(order));
		
	}
}
