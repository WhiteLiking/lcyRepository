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
	//添加订单
	public int addOrdres(Orders o) {
		int acount = -1;
		//建立通道
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";//用来存放sql语句的字符串 
		PreparedStatement preparedStatement = null;//提高preparedStatement的作用域
		try {
			preparedStatement = conn.prepareStatement(sql);//建立通道
			//传参数
			preparedStatement.setInt(1,o.getOid());//给第1个？传值
			preparedStatement.setString(2,o.getOname());//给第2个？传值
			preparedStatement.setFloat(3,o.getPrice());//给第3个？传值
			preparedStatement.setInt(4,o.getPsum());//给第4个？传值
			preparedStatement.setString(5,o.getName());
			preparedStatement.setString(6,o.getTelephone());
			preparedStatement.setString(7,o.getAderss());
			preparedStatement.setString(8,o.getUserno());
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

	//修改订单
	public int updateOrders(Orders o) {
		int count = 0;
		// 3.建立通道
		String sql = "update orders set pname=?,price=?,psum=?,name=?,telephone=?,adress=?,userno=? where oid=?";
		// 获得了一个预编译的通道 相当于IO通道 可以用它来发送sql语句
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
			// 4.执行并返回结果集
			count = pstmt.executeUpdate();// 可以执行除了DQL以外所有的语句 DML 返回的是受影响的行数
											// DCL或DDL语句 返回值是0
			if (count >= 1) {
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			System.out.println("建立通道或修改失败");
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

	public List<Orders> selectOrderSBySql(String sql) {
		//属性
		List<Orders> listOrders = new ArrayList<Orders>();
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
		return listOrders;
	}
	
	//删除订单
	public int deleteOrders(Orders order){
		int count = -1;
		// 3.建立通道
		String sql = "delete from Orders where oid=?";
		// 获得了一个预编译的通道 相当于IO通道 可以用它来发送sql语句
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, order.getOid());

			// 4.执行并返回结果集
			
			count = pstmt.executeUpdate();// 可以执行除了DQL以外所有的语句 DML 返回的是受影响的行数
			System.out.println(count);							// DCL或DDL语句 返回值是0

			if (count >= 1) {
				System.out.println("删除成功!");
			} else {
				System.out.println("没有删除!");
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
	
	
	
	
	public static void main(String[] args) {
		Orders order = new Orders();
		OrderDaoImple dao = new OrderDaoImple();
		order.setOid(0);
		System.out.println(dao.deleteOrders(order));
		
	}
}
