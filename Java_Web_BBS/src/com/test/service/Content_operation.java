package com.test.service;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import com.test.util.*;
import com.test.bean.*;
public class Content_operation {
	
	//�г�ȫ������ ����һ��list1
	public ArrayList<Articles> List_all_article(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		ArrayList<Articles> list1 = new ArrayList<Articles>();
		
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from articles order by id";                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				Articles article1 = new Articles();
				article1.setId(st.getInt("id"));
				article1.setContent(st.getString("content"));
				//article1.setComment(st.getString("comment"));
				article1.setAuthor(st.getString("author"));
				list1.add(article1);	
			}
			return list1;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		} 
		return null;
	}
	
	
	//��������id ��ʾ��������
	public Articles find(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		Articles article1 = new Articles();
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from articles where id="+id;                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				
				article1.setId(st.getInt("id"));
				article1.setContent(st.getString("content"));
				//article1.setComment(st.getString("comment"));
				article1.setAuthor(st.getString("author"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return article1;
	}
	
	//����username�����û�����������������
	public ArrayList<Articles> find_by_user(String username) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		ArrayList<Articles> list1 = new ArrayList<Articles>();
		
	
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from articles where author='"+username+"'";                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				Articles article = new Articles();
				article.setId(st.getInt("id"));
				article.setContent(st.getString("content"));
				article.setAuthor(st.getString("author"));
				list1.add(article);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return list1;
}
	
	//��������
	public boolean insert_article(Articles article1) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into articles(content,author)value('"+article1.getContent()+"','"+article1.getAuthor()+"')";                                 
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
	
	//��������idɾ������
	public boolean del_article(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from articles where id="+id;                                 
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
	
	//��������id�޸�����
		public boolean update_article(Articles article1) throws ClassNotFoundException, SQLException {
			Connection conn = null;
			Statement stmt = null;
			ResultSet st  = null;
			boolean flag = true;
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				//Articles article1 = new Articles();
				String sql = "update articles set content='"+article1.getContent()+"' where id="+article1.getId(); 
				
				//out.write(sql);
				//update articles set content="xxx" where id=31;
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


