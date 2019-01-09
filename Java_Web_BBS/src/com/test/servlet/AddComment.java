package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.*;
import com.test.service.*;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //使接收的参数值为utf-8格式
		response.setContentType("text/html;charset=utf-8");//返回的信息为utf-8
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("user")!=""){
			String submit = request.getParameter("comment_submit");
			if(submit!=null){
				Comment comment1 = new Comment();
				
				//接收参数
				String comment_author = request.getParameter("comment_author");
				String comment = request.getParameter("comment");
				int aiticle_id=Integer.parseInt(request.getParameter("aiticle_id"));
				
				//向comment1添加属性
				comment1.setComment_user(comment_author);
				comment1.setArticle_id(aiticle_id);
				comment1.setComment(comment);
				
				Comment_operation com_op1 = new Comment_operation();
				boolean a = false;
				try {	
					a = com_op1.insert_comment(comment1);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (a){ 
					out.println("<script language='javascript'>alert('评论成功!');self.location=document.referrer;</script>");
				}else{
					out.println("<script language='javascript'>alert('评论失败!');self.location=document.referrer;</script>");
				}
			}
			
			}
		
	}
		
	}
