package com.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connect.util.OracleUtil;
import com.dao.inter.CategoryDAO;
import com.vo.Category;

public class TestImple {
	
		//创建一个Connection类型的私有属性，以便在该类中使用Connection接口中的方法
		private Connection conn;
		
		//通过构造器对该属性进行初始化操作
		public TestImple(){
			//返回与数据库连接对象
			conn = OracleUtil.getConnection();
		}

		/* 建立通道。建立通道主要有三个：
		 * 1 PreparedStatement,预编译通道，是Statement的子类,通常用于执行相同sql语句的时候
		 * 2 Statement,普通通道
		 * 3
		 * */
		//实现增加的方法
		public int add(Test test) {
			int acount = -1;
			//建立通道
			String sql = "insert into test values(?,?)";//用来存放sql语句的字符串 
			PreparedStatement preparedStatement = null;//提高preparedStatement的作用域
			try {
				preparedStatement = conn.prepareStatement(sql);//建立通道
				//传参数
				preparedStatement.setString(1,test.getName());//给第1个？传值
				preparedStatement.setString(2,test.getPs());//给第1个？传值
				
				
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
		
		public Test selectTestById(String name) {
			//属性
			Test test = new Test();
			String sql = "select * from test where name=?";//存放sql语句
			PreparedStatement pst = null;//提高作用域
			ResultSet rs = null;
			//创建通道
			try {
				pst =conn.prepareStatement(sql);
				//传参数
				pst.setString(1,name);
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
						test.setName(rs.getString("name"));
						test.setPs(rs.getString("ps"));
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
			return test;
		}
		public static void main(String[] args) {
			TestImple test = new TestImple();
			Test te = test.selectTestById("binbin");
			System.out.println(te);
//			
	}
}
