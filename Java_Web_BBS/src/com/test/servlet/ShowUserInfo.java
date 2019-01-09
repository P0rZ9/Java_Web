package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.*;
import com.test.service.*;
/**
 * Servlet implementation class ShowUserInfo
 */
@WebServlet("/ShowUserInfo")
public class ShowUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getSession().getAttribute("user")!=""){
			User user1 = (User) request.getSession().getAttribute("user");
			String username = user1.getName();
			out.println(username+"的个人空间:");
			User_operation user_op = new User_operation();
			User user2 = null;
			try {
				user2 = user_op.find_user_by_name(username);	
			    //out.println("---------------------------<br />");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", user2);

			
		    //根据username返回其写的文章 
		    Content_operation con1_op = new Content_operation();
		    ArrayList<Articles> list2 = null;
			try {
				list2 = con1_op.find_by_user(username);
				request.setAttribute("article_list", list2);
				
			    }
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//根据username返回其写的评论
		    Comment_operation comm_op = new Comment_operation();
		    ArrayList<Comment> list1 = null;
			try {
				list1 = comm_op.find_by_user(username);
				request.setAttribute("comment_list", list1);
				
			    }
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		    

		    
		}else{
			out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
