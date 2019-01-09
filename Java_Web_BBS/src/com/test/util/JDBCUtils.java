package com.test.util;

import com.test.bean.User;
import java.util.HashMap;
import java.sql.*;
public class JDBCUtils {
	private static JDBCUtils instance = new JDBCUtils();
	
	//����HashMap����users   ����ģ�����ݿ�
	private static HashMap<String,User> users = new HashMap<String,User>();
	

	
	public static JDBCUtils getInstance() {
		return instance;
	}
	
	//��ȡ���ݿ�(users)�е�����
	public static User getUser(String userName) {
		User user = (User) users.get(userName);
		return user;
	}	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//�������ݿ����
		String driverName="com.mysql.jdbc.Driver";//��������
		String userName="root"; //���ݿ���Ϣ
		String userPasswd="root"; 
		String dbName="bbs"; 
		String tableName="users"; 
		//�����ݿ���Ϣ�ַ������ӳ�Ϊһ��������url��Ҳ����ֱ��д��url���ֿ�д�����˿�ά����ǿ�� 
		String url="jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&password="+userPasswd; 
		Class.forName(driverName); 
		Connection con=DriverManager.getConnection(url); 
		
		
		return con;
		
		//�������ݿ�
		
		
	}
	//�ͷ���Դ rs stat con  
	public static void release(ResultSet rs, Statement stat, Connection con) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		rs = null;
		}
		
		if(stat != null) {
			try {
				stat.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		stat = null;
		}
		
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		con = null;
		}
	}
	
}
