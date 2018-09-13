package com.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.util.OracleUtil;
import com.vo.Category;
import com.vo.Manager;

public class ManagerDaoImple{
	//����
	Connection conn;
	//������
	public ManagerDaoImple(){
		conn = OracleUtil.getConnection();
	}

	//���
	public int addManager(Manager manager) {
		int acount = -1;
		//����ͨ��
		String sql = "insert into manager values(seq_manager.nextval,?,?,?)";//�������sql�����ַ��� 
		PreparedStatement preparedStatement = null;//���preparedStatement��������
		try {
			preparedStatement = conn.prepareStatement(sql);//����ͨ��
			//������
			preparedStatement.setString(1,manager.getCname());//����1������ֵ
			preparedStatement.setString(2,manager.getCpassword());//����2������ֵ
			preparedStatement.setInt(3,manager.getState());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ͨ��ʧ��");//�쳣����
			e.printStackTrace();
		}
		
		try {
			//ִ�в����ؽ��������Ҫִ��DDL��DML��䣬����DDL��䣬���ص�����Ӱ���������
			//����û��û�з������ͣ�����DDL����0
			acount = preparedStatement.executeUpdate();
			if(acount>=1){
				System.out.println("��ӳɹ���");
			}else{
				System.out.println("�����쳣���û��޷����");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ִ��������ʧ��");
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

//   ɾ���û�
	public int deleteManager(Manager customer) {
		int count = -1;
		// 3.����ͨ��
		String sql = "delete from manager where cid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, customer.getCid());

			// 4.ִ�в����ؽ����
			
			count = pstmt.executeUpdate();
			if (count >= 1) {
				System.out.println("�û�ɾ���ɹ�!");
			} else {
				System.out.println("�����쳣�޷�ɾ���û�!");
			}
		} catch (SQLException e) {
			System.out.println("����ͨ����ɾ���û�ʧ�ܣ�");
			e.printStackTrace();
			
		} finally {
			// 5.�ر�
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر�ʧ��");
				}
			}
		}

		return count;
	}

	public int updateManager(Manager customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�鿴�û�
	public Manager selectManagerById(int id) {
		//����
		Manager customer = new Manager(); 
		String sql = "select mid,acount,passward,state from manager where mid = ?";//���sql���
		PreparedStatement pst = null;//���������
		ResultSet rs = null;
		//����ͨ��
		try {
			pst =conn.prepareStatement(sql);
			//������
			pst.setInt(1,id);
		} catch (SQLException e) {
			System.out.println("����Ԥ����ͨ��ʧ��");
			e.printStackTrace();
		}
		//ִ�в���
		try {
			rs = pst.executeQuery();
			if(rs==null){
				System.out.println("δ�鵽�û�");
			}else{
				System.out.println("ͨ��id��ѯ�û��ɹ���");
				//����ѯ�����������
				if(rs.next()){
					customer.setCid(rs.getInt("mid"));
					customer.setCname(rs.getString("acount"));
					customer.setCpassword(rs.getString("passward"));
					customer.setState(rs.getInt("state"));
				}
			}
		} catch (SQLException e) {
			System.out.println("ִ�в�ѯ����ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			//�ر�ͨ��
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("�ر�ͨ��ʧ��");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("�����ݿ�����ӹر�ʧ��");
					e.printStackTrace();
				}
			}
		}
		return customer;
	}
	
	//ͨ��sql����ѯ
	//ͨ��sql����ѯ��Ʒ
		public List<Manager> selectManagerBySQL(String sql) {
			//����
			List<Manager> list = new ArrayList<Manager>();
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
					System.out.println("ͨ通过语句失败");
				}else{
					
					System.out.println("ͨ执行语句成功！");
					//���������������
					while(rs.next()){
						Manager manager = new Manager();
						manager.setCid(rs.getInt("mid"));
						manager.setCname(rs.getString("acount"));
						manager.setCpassword(rs.getString("passward"));
						manager.setState(rs.getInt("State"));
						list.add(manager);
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
			return list;
		}
		

	public static void main(String[] args) {
//		Manager a = new Manager();
//		a.setCname("干干干干干干");
//		a.setCpassword("ldkkfjg");
//		a.setState(1);
		
		ManagerDaoImple b = new ManagerDaoImple();
		//b.addManager(a);
		
		System.out.println(b.selectManagerBySQL("select * from manager"));
		
	}

/******************************************************************/

}
