package com.test.service;
import java.sql.*;
import java.util.ArrayList;

import com.test.util.*;
import com.test.bean.*;
public class User_operation {
	
	//�г�ȫ���û�  ��ǰ�˷���һ��table
	public ArrayList<User> list_all_user() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		
		ArrayList<User> list = new ArrayList<User>();
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from users";                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				User user1 = new User();
				user1.setId(st.getInt("id"));
				user1.setName(st.getString("username"));
				user1.setPassword(st.getString("pwd"));
				user1.setProfile(st.getString("profile"));
				user1.setSex(st.getInt("sex"));
				user1.setEmail(st.getString("email"));
				list.add(user1);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return null;
	}

	
	
	//�����û�  ����boolean��Ϣ
	public boolean insert(User user) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into users(username,pwd,email,sex,profile)value('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"',"+user.getSex()+",'"+user.getProfile()+"')";                                 
			//insert into users(username,pwd)value('name1','pwd1')
			//System.out.println(sql);
			int num = stmt.executeUpdate(sql);
			if(num>0) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return flag;
	}
	
	//���ݴ����usernameɾ���û�  ����msg(String)��Ϣ
	public String delete(String username) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		String msg = "";
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from users where username='"+username+"'";                                 
			//insert into users(username,pwd)value('name1','pwd1')
			//System.out.println(sql);
			int num = stmt.executeUpdate(sql);
			if(num>0) {
				msg = "<script language='javascript'>alert('ɾ���ɹ���');window.history.back()</script>";
			}else {
				msg = "<script language='javascript'>alert('ɾ��ʧ�ܣ�');window.history.back()</script>";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return msg;
	}
	
	//���ݴ����id �����û���Ϣ  
	public User find(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		User user1 = new User();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from users where id="+id;                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				
				user1.setId(st.getInt("id"));
				user1.setName(st.getString("username"));
				user1.setPassword(st.getString("pwd"));
				user1.setProfile(st.getString("profile"));
				user1.setSex(st.getInt("sex"));
				//user1.setPassword(st.getString("pwd"));
				user1.setEmail(st.getString("email"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return user1;
	}
	
	//���ݴ����username �����û���Ϣ  
	public User find_user_by_name(String username) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		User user1 = new User();
		try{
			conn = JDBCUtils.getConnection();  //
			stmt = conn.createStatement();
			String sql = "select * from users where username='"+username+"'";                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				
				user1.setId(st.getInt("id"));
				user1.setName(st.getString("username"));
				user1.setPassword(st.getString("pwd"));
				user1.setProfile(st.getString("profile"));
				user1.setSex(st.getInt("sex"));
				//user1.setPassword(st.getString("pwd"));
				user1.setEmail(st.getString("email"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return user1;
	}
	
	//�жϵ�ǰ�û����Ƿ����
	public boolean user_exist(String username) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		String msg = "";
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from users where username='"+username+"'";                                 
			//insert into users(username,pwd)value('name1','pwd1')
			//System.out.println(sql);
			st = stmt.executeQuery(sql);
			while(st.next()) {
				return true;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return false;
	}
	
	
	//�����û�idɾ���û�
	public boolean del_user(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from users where id="+id;                                 
			int num = stmt.executeUpdate(sql);
			if(num>0) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return flag;
	}
	
	
	//��������id�޸��û���Ϣ
	public boolean update_user_info(User user) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			//Articles article1 = new Articles();
			String sql = "update users set pwd='"+user.getPassword()+"',email='"+user.getEmail()+"',profile='"+user.getProfile()+"' where id="+user.getId(); 
			//дsql���

			int num = stmt.executeUpdate(sql);
			if(num>0) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return flag;
	}
	
	

}
