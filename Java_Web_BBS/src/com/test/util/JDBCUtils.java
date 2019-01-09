package com.test.util;

import com.test.bean.User;
import java.util.HashMap;
import java.sql.*;
public class JDBCUtils {
	private static JDBCUtils instance = new JDBCUtils();
	
	//定义HashMap集合users   用于模拟数据库
	private static HashMap<String,User> users = new HashMap<String,User>();
	

	
	public static JDBCUtils getInstance() {
		return instance;
	}
	
	//获取数据库(users)中的数据
	public static User getUser(String userName) {
		User user = (User) users.get(userName);
		return user;
	}	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//连接数据库操作
		String driverName="com.mysql.jdbc.Driver";//加载驱动
		String userName="root"; //数据库信息
		String userPasswd="root"; 
		String dbName="bbs"; 
		String tableName="users"; 
		//将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强） 
		String url="jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&password="+userPasswd; 
		Class.forName(driverName); 
		Connection con=DriverManager.getConnection(url); 
		
		
		return con;
		
		//连接数据库
		
		
	}
	//释放资源 rs stat con  
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
