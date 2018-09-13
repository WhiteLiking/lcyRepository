package com.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connect.util.OracleUtil;
import com.dao.inter.CategoryDAO;
import com.vo.Category;

public class TestImple {
	
		//����һ��Connection���͵�˽�����ԣ��Ա��ڸ�����ʹ��Connection�ӿ��еķ���
		private Connection conn;
		
		//ͨ���������Ը����Խ��г�ʼ������
		public TestImple(){
			//���������ݿ����Ӷ���
			conn = OracleUtil.getConnection();
		}

		/* ����ͨ��������ͨ����Ҫ��������
		 * 1 PreparedStatement,Ԥ����ͨ������Statement������,ͨ������ִ����ͬsql����ʱ��
		 * 2 Statement,��ͨͨ��
		 * 3
		 * */
		//ʵ�����ӵķ���
		public int add(Test test) {
			int acount = -1;
			//����ͨ��
			String sql = "insert into test values(?,?)";//�������sql�����ַ��� 
			PreparedStatement preparedStatement = null;//���preparedStatement��������
			try {
				preparedStatement = conn.prepareStatement(sql);//����ͨ��
				//������
				preparedStatement.setString(1,test.getName());//����1������ֵ
				preparedStatement.setString(2,test.getPs());//����1������ֵ
				
				
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
		
		public Test selectTestById(String name) {
			//����
			Test test = new Test();
			String sql = "select * from test where name=?";//���sql���
			PreparedStatement pst = null;//���������
			ResultSet rs = null;
			//����ͨ��
			try {
				pst =conn.prepareStatement(sql);
				//������
				pst.setString(1,name);
			} catch (SQLException e) {
				System.out.println("����Ԥ����ͨ��ʧ��");
				e.printStackTrace();
			}
			//ִ�в���
			try {
				rs = pst.executeQuery();
				conn.setAutoCommit(true);
				if(rs==null){
					System.out.println("δ�鵽��Ʒ��");
				}else{
					System.out.println("ͨ��id��ѯ��Ʒ�ɹ���");
					//����ѯ�����������
					while(rs.next()){
						test.setName(rs.getString("name"));
						test.setPs(rs.getString("ps"));
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
			return test;
		}
		public static void main(String[] args) {
			TestImple test = new TestImple();
			Test te = test.selectTestById("binbin");
			System.out.println(te);
//			
	}
}
