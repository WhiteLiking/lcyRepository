package com.dao.imple;
import com.connect.util.*;
import com.dao.inter.*;
import com.connect.util.*;
import com.vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//ʵ��Category�ӿڣ�ʵ�ִ˽ӿڵ����з������ﵽ�������ݿ����ݵ�Ŀ��
public class DaoImple implements CategoryDAO{
	//����һ��Connection���͵�˽�����ԣ��Ա��ڸ�����ʹ��Connection�ӿ��еķ���
	private Connection conn;
	
	//ͨ���������Ը����Խ��г�ʼ������
	public DaoImple(){
		//���������ݿ����Ӷ���
		conn = OracleUtil.getConnection();
	}

	/* ����ͨ��������ͨ����Ҫ��������
	 * 1 PreparedStatement,Ԥ����ͨ������Statement������,ͨ������ִ����ͬsql����ʱ��
	 * 2 Statement,��ͨͨ��
	 * 3
	 * */
	
	//ʵ�����ӵķ���
	public int addCategory(Category category) {
		int acount = -1;
		//����ͨ��
		String sql = "insert into category values(seq_category.nextval,?,?,?,?,?,?,?)";//�������sql�����ַ��� 
		PreparedStatement preparedStatement = null;//���preparedStatement��������
		try {
			preparedStatement = conn.prepareStatement(sql);//����ͨ��
			//������
			preparedStatement.setString(1,category.getCname());//����1������ֵ
			preparedStatement.setString(2,category.getCdec());//����2������ֵ
			preparedStatement.setInt(3,category.getPrice());//����3������ֵ
			preparedStatement.setString(4,category.getVersion());//����4������ֵ
			preparedStatement.setInt(5,category.getGround());
			preparedStatement.setInt(6,category.getQuantity());
			preparedStatement.setString(7,category.getPsPath());
			
			
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
/*********************************************************************************************/
	 //ɾ����Ʒ
	public int deleteCategory(Category category) {
		int count = -1;
		// 3.����ͨ��
		String sql = "delete from category where cid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, category.getCid());

			// 4.ִ�в����ؽ����
			
			count = pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
			System.out.println(count);							// DCL��DDL��� ����ֵ��0

			if (count >= 1) {
				System.out.println("ɾ����Ʒ����ɹ�!");
			} else {
				System.out.println("û��ɾ���κ���Ʒ����!");
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
	
	//�޸���Ʒ����
	public int updateCategory(Category category) {
		int count = 0;
		// 3.����ͨ��
		String sql = "update category set cname=?,cdec=?,price=?,version=?,ground=?,quantity=?,pspath=? where cid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, category.getCname());
			pstmt.setString(2, category.getCdec());
			pstmt.setInt(3, category.getPrice());
			pstmt.setString(4, category.getVersion());
			pstmt.setInt(5, category.getGround());
			pstmt.setInt(6, category.getQuantity());
			pstmt.setString(7,category.getPsPath());
			pstmt.setInt(8, category.getCid());
			// 4.ִ�в����ؽ����
			count = pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
											// DCL��DDL��� ����ֵ��0

			if (count >= 1) {
				System.out.println("�޸���Ʒ����ɹ�!");
			} else {
				System.out.println("û���޸��κ���Ʒ����!");
			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����޸���Ʒ����ʧ��");
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

	//ͨ��Id��ѯ
	public Category selectCategoryById(int id) {
		//����
		Category category = new Category();
		String sql = "select cid,cname,cdec,price,version,ground,quantity,pspath from category where cid = ?";//���sql���
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
			conn.setAutoCommit(true);
			if(rs==null){
				System.out.println("δ�鵽��Ʒ��");
			}else{
				System.out.println("ͨ��id��ѯ��Ʒ�ɹ���");
				//����ѯ�����������
				while(rs.next()){
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					
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
		return category;
	}

	//ͨ��sql����ѯ��Ʒ
	public List<Category> selectCategoryBySQL(String sql) {
		//����
		List<Category> listCategory = new ArrayList<Category>();
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
					Category category = new Category();
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					listCategory.add(category);
					
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
		return listCategory;
	}
	
	//�鿴��Ʒ�ܼ�¼
	public int selectTotalRecordBySQL(String sql) {
		//����
		int totalRecord = -1;
		Statement st = null;
		ResultSet rs = null;
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
				System.out.println("δ�鵽�κ���Ʒ");
			}else{
				System.out.println("��ѯ�ܼ�¼�ɹ�");
				//����ѯ���Ľ����ȡ����
				while(rs.next()){
					totalRecord = rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("ִ�в���ʧ�ܣ�");
			e.printStackTrace();
		}finally{
			//�ر�ͨ��
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("����ͨ��ʧ��");
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
		
		return totalRecord;
	}
	
	//��ѯ����Id֮��ļ�¼
	public List<Category> selectCategoryBy2Id(int id1,int id2){
		//����
		List<Category> listCategory = new ArrayList<Category>();
		String sql = "select * from (select e.*,rownum r from category e) t where r>=? and r<=?";//���sql���
		PreparedStatement pst = null;//���������
		ResultSet rs = null;
		//����ͨ��
		try {
			pst =conn.prepareStatement(sql);
			//������
			pst.setInt(1,id1);
			pst.setInt(2,id2);
		} catch (SQLException e) {
			System.out.println("����Ԥ����ͨ��ʧ��");
			e.printStackTrace();
		}
		//ִ�в���
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);//�����Զ��ύ
			if(rs==null){
				System.out.println("δ�鵽��Ʒ��");
			}else{
				System.out.println("ͨ��id��ѯ��Ʒ�ɹ���");
				//����ѯ�����������
				while(rs.next()){
					Category category = new Category();
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					listCategory.add(category);
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
		return listCategory;
		
	}
	
	//ͨ����Ʒ���Ʋ�ѯ
	public List<Category> selectCategoryByName(String cname) {
		//����
		List<Category> listCategory = new <Category>ArrayList();
		String sql = "select * from category where cname = ?";//���sql���
		PreparedStatement pst = null;//���������
		ResultSet rs = null;
		//����ͨ��
		try {
			pst =conn.prepareStatement(sql);
			//������
			pst.setString(1,cname);
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
				System.out.println("ͨ����Ʒ���Ʋ�ѯ��Ʒ�ɹ���");
				//����ѯ�����������
				while(rs.next()){
					Category category = new Category();
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					listCategory.add(category);
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
		return listCategory;
	}
	
	//ͨ����Ʒ������ѯ
	public List<Category> selectCategoryByCdec(String cdec) {
		//����
		List<Category> listCategory = new <Category>ArrayList();
		String sql = "select * from category where cdec = ?";//���sql���
		PreparedStatement pst = null;//���������
		ResultSet rs = null;
		//����ͨ��
		try {
			pst =conn.prepareStatement(sql);
			//������
			pst.setString(1,cdec);
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
				System.out.println("ͨ����Ʒ���Ʋ�ѯ��Ʒ�ɹ���");
				//����ѯ�����������
				while(rs.next()){
					Category category = new Category();
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					listCategory.add(category);
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
		return listCategory;
	}
	
	//��ѯ����ĳһ��Id��������Ʒ
	public List<Category> selectCategoryByBigId(int id) {
		//����
		List<Category> listCategory = new ArrayList<Category>();
		String sql = "select * from category where cid>= ?";//���sql���
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
			conn.setAutoCommit(true);//�����Զ��ύ
			if(rs==null){
				System.out.println("δ�鵽��Ʒ��");
			}else{
				System.out.println("ͨ��id��ѯ��Ʒ�ɹ���");
				//����ѯ�����������
				while(rs.next()){
					Category category = new Category();
					category.setCid(rs.getInt("cid"));
					category.setCname(rs.getString("cname"));
					category.setCdec(rs.getString("cdec"));
					category.setPrice(rs.getInt("price"));
					category.setVersion(rs.getString("version"));
					category.setGround(rs.getInt("ground"));
					category.setQuantity(rs.getInt("quantity"));
					category.setPsPath(rs.getString("pspath"));
					listCategory.add(category);
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
		return listCategory;
	}
	
	//ͨ��Cid�޸�id
	public int updateCategoryById(int id) {
		int count = 0;
		// 3.����ͨ��
		String sql = "update category set cid=? where cid=?";
		// �����һ��Ԥ�����ͨ�� �൱��IOͨ�� ��������������sql���
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setInt(2, id+1);
			// 4.ִ�в����ؽ����
			count = pstmt.executeUpdate();// ����ִ�г���DQL�������е���� DML ���ص�����Ӱ�������
											// DCL��DDL��� ����ֵ��0

			if (count >= 1) {
				System.out.println("�޸���Ʒ����ɹ�!");
			} else {
				System.out.println("û���޸��κ���Ʒ����!");
			}
		} catch (SQLException e) {
			System.out.println("����ͨ�����޸���Ʒ����ʧ��");
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
	
	
	//����һ�����������Ը�ҵ���Ƿ��ܳɹ�ִ��
	public static void main(String[] args) {
		DaoImple dao = new DaoImple();
		System.out.println(dao.selectCategoryBy2Id(1,3));	
	}
}
