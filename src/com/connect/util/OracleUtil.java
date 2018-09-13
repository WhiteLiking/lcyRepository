package com.connect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//这是一个工具类
public class OracleUtil {
	
	//用来连接数据库的工具类,Connection是Java与数据库建立连接的一个接口。
	public static Connection getConnection(){
		Connection conn = null;
		
		//与数据库连接的信息
		String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uname = "scott";
		String password = "tiger";
		
		//第一步，加载驱动
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到所加载的驱动类");
			e.printStackTrace();
		}
		
		//第二步，创建连接。
		try {
			conn = DriverManager.getConnection(url,uname,password);
		} catch (SQLException e) {
			System.out.println("连接不成功！");
			e.printStackTrace();
		}
		//返回Connection的对象conn。
		return conn;
	} 
}
