package com.dao.imple;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.util.OracleUtil;
import com.dao.inter.UserDao;

import com.vo.User;


public class UserDaoImpl implements UserDao {
	 private Connection conn;
	 public UserDaoImpl(){
		 conn=OracleUtil.getConnection();
	 }

	@Override
	public User findUserByUsreName(String um) throws SQLException {
		
		return null;
	}

	@Override
	public void userRegist(User user) throws Exception {
		String sql="insert into user_table values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=null;
		//����ͨ��
		 try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,user.getUserno() );
			stmt.setString(2,user.getUsername() );
			stmt.setString(3,user.getPassword() );
			stmt.setInt(4,user.getAge() );
			stmt.setString(5,user.getSex() );
			stmt.setString(6,user.getEmail() );
			stmt.setString(7,user.getTelephone() );
			stmt.setInt(8,user.getState() );
			stmt.setString(9,user.getCode() );
			stmt.executeUpdate();
		} catch (SQLException e) {
			 System.out.println("���ݿ�����û���¼ʧ��");
			e.printStackTrace();
			throw new Exception("�û�ע��ʧ��");
		}finally {
			if(stmt!=null){
				try {
					stmt.close();
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
		
	}
	@Override
	public User userActive(String code) throws Exception{
		String sql ="select * from user_table where code=?";
		User user =new User();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		//�˽�ͨ��
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,code);
			rs=stmt.executeQuery();
			while(rs.next()){
				user.setUserno(rs.getString("userno"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
			}
			
		} catch (SQLException e) {
			System.out.println("�û����������ݿɲ�ѯʧ��");
			e.printStackTrace();
			throw new Exception("�û�����ʧ�ܣ������¼���");
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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
		 
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception  {
		// TODO Auto-generated method stub
		String sql="update user_table set state=?,code=? where userno=?";
		System.out.println(user);
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, user.getState());
			stmt.setString(2, user.getCode());
			stmt.setString(3, user.getUserno());
			   stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("����״̬����ռ�����ʧ��");
			e.printStackTrace();
			throw new Exception("�û�����ʧ�ܣ������¼���");
		}finally{
			
			if(stmt!=null){
				try {
					stmt.close();
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
	}

	@Override
	public User userLogin(User user)  {
		String sql="select * from user_table where username=? and password=?";
		User user1= new User();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		 
			  //�������ݿ�����
			try {
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				//  ִ��SQL���
				rs=stmt.executeQuery();
				while(rs.next()){
					user1.setUserno(rs.getString("userno"));
					user1.setUsername(rs.getString("username"));
					user1.setPassword(rs.getString("password"));
					user1.setAge(rs.getInt("age"));
					user1.setSex(rs.getString("sex"));
					user1.setEmail(rs.getString("email"));
					user1.setTelephone(rs.getString("telephone"));
					user1.setState(rs.getInt("state"));
					user1.setCode(rs.getString("code"));
					System.out.println(user1.getState());
				}
			} catch (SQLException e) {
				System.out.println("���ݲ�ѯ��½ʧ��");
				e.printStackTrace();
			}finally{
			//���������
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("�ر�ͨ��ʧ��");
					}	
				}
				if(stmt!=null){
					try {
						stmt.close();
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
				
		return user1;  
	}

	@Override
	//��ѯ�Ƿ���ڸ��û�
	public User fandUserByName(String username) {
		String sql="select * from user_table where username=?";
		PreparedStatement stmt=null;
		User user=new User();
		ResultSet rs=null;
		  try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			while(rs.next()){
				user.setUserno(rs.getString("userno"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�û���ʧ��");
			
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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
   return user;
	}

	@Override
	public int getTotalRecordSum(String sql) throws Exception {		
		int totalRecordSum = -1;
		
		ResultSet rs = null;
		Statement stmt = null;
		// 3.����ͨ��
		try {
			stmt = conn.createStatement();
			// 4.ִ�в����ؽ����
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				totalRecordSum = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����ѯ�����ʧ��");
			e.printStackTrace();
			
			throw new Exception("��ѯ�û��ܼ�¼��ʧ��");//�쳣ת��
		} finally {
			// 5.�ر�
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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

		return totalRecordSum;
	}

	@Override
	public List<User> getPageQuer(String sql) throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		ResultSet rs = null;
		Statement stmt = null;
		// 3.����ͨ��
		try {
			stmt = conn.createStatement();
			// 4.ִ�в����ؽ����
			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				user = new User();

				user.setUserno(rs.getString("userno"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));

				list.add(user);

			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����ѯ�����ʧ��");
			e.printStackTrace();
			
			throw new Exception("��ѯ�û�ʧ��");//�쳣ת��
		} finally {
			// 5.�ر�
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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

		return list;
	}

	@Override
	public List<User> getPageByQuery(String sql) throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		ResultSet rs = null;
		Statement stmt = null;
		// 3.����ͨ��
		try {
			stmt = conn.createStatement();
			// 4.ִ�в����ؽ����
			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				user = new User();

				user.setUserno(rs.getString("userno"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));

				list.add(user);

			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����ѯ�����ʧ��");
			e.printStackTrace();
			
			throw new Exception("������ѯ�û�ʧ��");//�쳣ת��
		} finally {
			// 5.�ر�
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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

		return list;
	}

	@Override
	public void deleteUser(String userno) throws Exception {
	   String sql="delete from user_table where userno=?";
	   System.out.println(sql);
		// 3.����ͨ��				
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userno);
			// 4.ִ�в����ؽ����
			pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
											// DCL��DDL��� ����ֵ��0
		} catch (SQLException e) {
			System.out.println("����ͨ����ɾ���û�ʧ��");
			e.printStackTrace();
			
			throw new Exception("ɾ���û�ʧ��");
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
		
	}

	@Override
	public User getUserById(String userno)throws Exception  {
		String sql="select * from user_table where userno=?";
		PreparedStatement stmt=null;
		User user=new User();
		ResultSet rs=null;
		  try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, userno);
			rs=stmt.executeQuery();
			while(rs.next()){
				user.setUserno(rs.getString("userno"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setState(rs.getInt("state"));
				user.setCode(rs.getString("code"));
			}
		} catch (SQLException e) {
			System.out.println("��ѯ�û���ʧ��");
	        throw new Exception("��ѯ�����û�ʧ��");
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�ر�ͨ��ʧ��");
				}	
			}
			if(stmt!=null){
				try {
					stmt.close();
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
		  return user;
	}

	@Override
	public void update(User user) throws Exception {
		String sql="update user_table set username=?,password=?,age=?,sex=?,email=?,telephone=? where userno=?";
		PreparedStatement stmt=null;
		//����ͨ��
		 try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1,user.getUsername() );
			stmt.setString(2,user.getPassword() );
			stmt.setInt(3,user.getAge() );
			stmt.setString(4,user.getSex() );
			stmt.setString(5,user.getEmail() );
			stmt.setString(6,user.getTelephone() );
			stmt.setString(7,user.getUserno() );
			stmt.executeUpdate();
		} catch (SQLException e) {
			 System.out.println("���ݿ�����û���¼ʧ��");
			e.printStackTrace();
			throw new Exception("�û�����ʧ��");
		}finally {
			if(stmt!=null){
				try {
					stmt.close();
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
	}
 
	

}
