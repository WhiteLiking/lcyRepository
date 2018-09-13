package com.connect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//����һ��������
public class OracleUtil {
	
	//�����������ݿ�Ĺ�����,Connection��Java�����ݿ⽨�����ӵ�һ���ӿڡ�
	public static Connection getConnection(){
		Connection conn = null;
		
		//�����ݿ����ӵ���Ϣ
		String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uname = "scott";
		String password = "tiger";
		
		//��һ������������
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("�Ҳ��������ص�������");
			e.printStackTrace();
		}
		
		//�ڶ������������ӡ�
		try {
			conn = DriverManager.getConnection(url,uname,password);
		} catch (SQLException e) {
			System.out.println("���Ӳ��ɹ���");
			e.printStackTrace();
		}
		//����Connection�Ķ���conn��
		return conn;
	} 
}
