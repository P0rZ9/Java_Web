package com.test.service;
import java.util.ArrayList;
import java.sql.*;

import com.test.bean.*;
import com.test.service.*;
import com.test.util.*;
import java.util.ArrayList;

public class Comment_operation {
	public ArrayList<Comment> list_all_comment(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from comments where article_id="+id;                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				Comment comment = new Comment();
				comment.setId(st.getInt("id"));
				comment.setComment_user(st.getString("comment_user"));
				comment.setArticle_id(st.getInt("article_id"));
				comment.setComment(st.getString("comment"));
				list.add(comment);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return list;
	}
	
	//新增评论
	public boolean insert_comment(Comment comment1) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into Comments(article_id,comment_user,comment)value('"+comment1.getArticle_id()+"','"+comment1.getComment_user()+"','"+comment1.getComment()+"')";                                 
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
	
	
	//根据username返回用户的评论
	public ArrayList<Comment> find_by_user(String username) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		ArrayList<Comment> list1 = new ArrayList<Comment>();
		
	
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from comments where comment_user='"+username+"'";                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				Comment comment = new Comment();
				comment.setId(st.getInt("id"));
				comment.setArticle_id(st.getInt("article_id"));
				comment.setComment(st.getString("comment"));
				list1.add(comment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return list1;
}
	
	
	//根据评论id删除评论
	public boolean del_comment(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from comments where id="+id;                                 
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
	
	//根据评论id 显示评论详情
	public Comment find(int id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		Comment comment1 = new Comment();
		
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from comments where id="+id;                                 
			st = stmt.executeQuery(sql);
			while(st.next()) {
				comment1.setComment_user(st.getString("comment_user"));
				comment1.setId(st.getInt("id"));
				comment1.setComment(st.getString("comment"));
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(st, stmt, conn);
		}
		return comment1;
	}
	
	//根据评论id修改评论
	public boolean update_comment(Comment comment) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet st  = null;
		boolean flag = true;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			//Articles article1 = new Articles();
			String sql = "update comments set comment='"+comment.getComment()+"' where id="+comment.getId(); 
			
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
