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
//实现Category接口，实现此接口的所有方法，达到操作数据库数据的目的
public class DaoImple implements CategoryDAO{
	//创建一个Connection类型的私有属性，以便在该类中使用Connection接口中的方法
	private Connection conn;
	
	//通过构造器对该属性进行初始化操作
	public DaoImple(){
		//返回与数据库连接对象
		conn = OracleUtil.getConnection();
	}

	/* 建立通道。建立通道主要有三个：
	 * 1 PreparedStatement,预编译通道，是Statement的子类,通常用于执行相同sql语句的时候
	 * 2 Statement,普通通道
	 * 3
	 * */
	
	//实现增加的方法
	public int addCategory(Category category) {
		int acount = -1;
		//建立通道
		String sql = "insert into category values(seq_category.nextval,?,?,?,?,?,?,?)";//用来存放sql语句的字符串 
		PreparedStatement preparedStatement = null;//提高preparedStatement的作用域
		try {
			preparedStatement = conn.prepareStatement(sql);//建立通道
			//传参数
			preparedStatement.setString(1,category.getCname());//给第1个？传值
			preparedStatement.setString(2,category.getCdec());//给第2个？传值
			preparedStatement.setInt(3,category.getPrice());//给第3个？传值
			preparedStatement.setString(4,category.getVersion());//给第4个？传值
			preparedStatement.setInt(5,category.getGround());
			preparedStatement.setInt(6,category.getQuantity());
			preparedStatement.setString(7,category.getPsPath());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("建立通道失败");//异常处理
			e.printStackTrace();
		}
		
		try {
			//执行并返回结果集，主要执行DDL和DML语句，对于DDL语句，返回的是受影响的行数，
			//其他没有没有返回类型，例如DDL返回0
			acount = preparedStatement.executeUpdate();
			//添加事务,相当于不自动提交,若开启事务，不能关闭通道和连接。回滚：conn.rollback();
			//conn.setAutoCommit(false);
			if(acount>=1){
				System.out.println("添加商品成功！");
			}else{
				System.out.println("没有添加任何商品！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("执行语句失败");
			e.printStackTrace();
		}finally{
			
			//关闭通道（PreparedStatement，connection）
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭conn通道失败");
				}
			}
		}
		return acount;
	}
/*********************************************************************************************/
	 //删除商品
	public int deleteCategory(Category category) {
		int count = -1;
		// 3.建立通道
		String sql = "delete from category where cid=?";
		// 获得了一个预编译的通道 相当于IO通道 可以用它来发送sql语句
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, category.getCid());

			// 4.执行并返回结果集
			
			count = pstmt.executeUpdate();// 可以执行除了DQL以外所有的语句 DML 返回的是受影响的行数
			System.out.println(count);							// DCL或DDL语句 返回值是0

			if (count >= 1) {
				System.out.println("删除商品种类成功!");
			} else {
				System.out.println("没有删除任何商品种类!");
			}
		} catch (SQLException e) {
			System.out.println("建立通道或删除商品种类失败");
			e.printStackTrace();
			
		} finally {
			// 5.关闭
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭通道失败");
				}	
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭失败");
				}
			}
		}

		return count;
	}
	
	//修改商品种类
	public int updateCategory(Category category) {
		int count = 0;
		// 3.建立通道
		String sql = "update category set cname=?,cdec=?,price=?,version=?,ground=?,quantity=?,pspath=? where cid=?";
		// 获得了一个预编译的通道 相当于IO通道 可以用它来发送sql语句
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
			// 4.执行并返回结果集
			count = pstmt.executeUpdate();// 可以执行除了DQL以外所有的语句 DML 返回的是受影响的行数
											// DCL或DDL语句 返回值是0

			if (count >= 1) {
				System.out.println("修改商品种类成功!");
			} else {
				System.out.println("没有修改任何商品种类!");
			}
		} catch (SQLException e) {
			System.out.println("建立通道或修改商品种类失败");
			e.printStackTrace();
		}finally{
			//关闭通道和连接
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("由于关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("由于异常无法关闭与数据库的连接");
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	//通过Id查询
	public Category selectCategoryById(int id) {
		//属性
		Category category = new Category();
		String sql = "select cid,cname,cdec,price,version,ground,quantity,pspath from category where cid = ?";//存放sql语句
		PreparedStatement pst = null;//提高作用域
		ResultSet rs = null;
		//创建通道
		try {
			pst =conn.prepareStatement(sql);
			//传参数
			pst.setInt(1,id);
		} catch (SQLException e) {
			System.out.println("建立预编译通道失败");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);
			if(rs==null){
				System.out.println("未查到商品！");
			}else{
				System.out.println("通过id查询商品成功！");
				//将查询结果迭代出来
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
			System.out.println("执行查询操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败");
					e.printStackTrace();
				}
			}
		}
		return category;
	}

	//通过sql语句查询商品
	public List<Category> selectCategoryBySQL(String sql) {
		//属性
		List<Category> listCategory = new ArrayList<Category>();
		//Category category = null;
		ResultSet rs = null;
		Statement st = null;
		//建立通道
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("建立通道失败！");
			e.printStackTrace();
		}
		//执行操作
	
		try {
			rs = st.executeQuery(sql);
			if(rs==null){
				System.out.println("通过sql语句查询失败！可能语句不合法");
			}else{
				
				System.out.println("通过sql语句查询成功！");
				//将结果集迭代出来
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
			System.out.println("执行操作失败！");
			e.printStackTrace();
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败！");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败！");
					e.printStackTrace();
				}
			}
		}
		return listCategory;
	}
	
	//查看商品总记录
	public int selectTotalRecordBySQL(String sql) {
		//属性
		int totalRecord = -1;
		Statement st = null;
		ResultSet rs = null;
		//建立通道
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("建立通道失败！");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = st.executeQuery(sql);
			if(rs==null){
				System.out.println("未查到任何商品");
			}else{
				System.out.println("查询总记录成功");
				//将查询到的结果集取出来
				while(rs.next()){
					totalRecord = rs.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("执行操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("建立通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败！");
					e.printStackTrace();
				}
			}
		}
		
		return totalRecord;
	}
	
	//查询两个Id之间的记录
	public List<Category> selectCategoryBy2Id(int id1,int id2){
		//属性
		List<Category> listCategory = new ArrayList<Category>();
		String sql = "select * from (select e.*,rownum r from category e) t where r>=? and r<=?";//存放sql语句
		PreparedStatement pst = null;//提高作用域
		ResultSet rs = null;
		//创建通道
		try {
			pst =conn.prepareStatement(sql);
			//传参数
			pst.setInt(1,id1);
			pst.setInt(2,id2);
		} catch (SQLException e) {
			System.out.println("建立预编译通道失败");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);//事务自动提交
			if(rs==null){
				System.out.println("未查到商品！");
			}else{
				System.out.println("通过id查询商品成功！");
				//将查询结果迭代出来
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
			System.out.println("执行查询操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败");
					e.printStackTrace();
				}
			}
		}
		return listCategory;
		
	}
	
	//通过商品名称查询
	public List<Category> selectCategoryByName(String cname) {
		//属性
		List<Category> listCategory = new <Category>ArrayList();
		String sql = "select * from category where cname = ?";//存放sql语句
		PreparedStatement pst = null;//提高作用域
		ResultSet rs = null;
		//创建通道
		try {
			pst =conn.prepareStatement(sql);
			//传参数
			pst.setString(1,cname);
		} catch (SQLException e) {
			System.out.println("建立预编译通道失败");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);
			if(rs==null){
				System.out.println("未查到商品！");
			}else{
				System.out.println("通过商品名称查询商品成功！");
				//将查询结果迭代出来
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
			System.out.println("执行查询操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败");
					e.printStackTrace();
				}
			}
		}
		return listCategory;
	}
	
	//通过商品描述查询
	public List<Category> selectCategoryByCdec(String cdec) {
		//属性
		List<Category> listCategory = new <Category>ArrayList();
		String sql = "select * from category where cdec = ?";//存放sql语句
		PreparedStatement pst = null;//提高作用域
		ResultSet rs = null;
		//创建通道
		try {
			pst =conn.prepareStatement(sql);
			//传参数
			pst.setString(1,cdec);
		} catch (SQLException e) {
			System.out.println("建立预编译通道失败");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);
			if(rs==null){
				System.out.println("未查到商品！");
			}else{
				System.out.println("通过商品名称查询商品成功！");
				//将查询结果迭代出来
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
			System.out.println("执行查询操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败");
					e.printStackTrace();
				}
			}
		}
		return listCategory;
	}
	
	//查询大于某一个Id的所有商品
	public List<Category> selectCategoryByBigId(int id) {
		//属性
		List<Category> listCategory = new ArrayList<Category>();
		String sql = "select * from category where cid>= ?";//存放sql语句
		PreparedStatement pst = null;//提高作用域
		ResultSet rs = null;
		//创建通道
		try {
			pst =conn.prepareStatement(sql);
			//传参数
			pst.setInt(1,id);
		} catch (SQLException e) {
			System.out.println("建立预编译通道失败");
			e.printStackTrace();
		}
		//执行操作
		try {
			rs = pst.executeQuery();
			conn.setAutoCommit(true);//事务自动提交
			if(rs==null){
				System.out.println("未查到商品！");
			}else{
				System.out.println("通过id查询商品成功！");
				//将查询结果迭代出来
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
			System.out.println("执行查询操作失败！");
			e.printStackTrace();
		}finally{
			//关闭通道
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					System.out.println("关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("与数据库的连接关闭失败");
					e.printStackTrace();
				}
			}
		}
		return listCategory;
	}
	
	//通过Cid修改id
	public int updateCategoryById(int id) {
		int count = 0;
		// 3.建立通道
		String sql = "update category set cid=? where cid=?";
		// 获得了一个预编译的通道 相当于IO通道 可以用它来发送sql语句
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setInt(2, id+1);
			// 4.执行并返回结果集
			count = pstmt.executeUpdate();// 可以执行除了DQL以外所有的语句 DML 返回的是受影响的行数
											// DCL或DDL语句 返回值是0

			if (count >= 1) {
				System.out.println("修改商品种类成功!");
			} else {
				System.out.println("没有修改任何商品种类!");
			}
		} catch (SQLException e) {
			System.out.println("建立通道或修改商品种类失败");
			e.printStackTrace();
		}finally{
			//关闭通道和连接
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("由于关闭通道失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("由于异常无法关闭与数据库的连接");
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
	//利用一个主方法测试各业务是否能成功执行
	public static void main(String[] args) {
		DaoImple dao = new DaoImple();
		System.out.println(dao.selectCategoryBy2Id(1,3));	
	}
}
