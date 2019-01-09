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
 * Servlet implementation class UpdateComment
 */
@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //使接收的参数值为utf-8格式
		response.setContentType("text/html;charset=utf-8");//返回的信息为utf-8
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			Comment_operation comm_op = new Comment_operation();//操作
			//boolean a = false;
			Comment comment1 = null;
			try {
				comment1 = comm_op.find(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("comment", comment1);
			request.getRequestDispatcher("UpdateComment.jsp").forward(request, response);

		}else{
			out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //使接收的参数值为utf-8格式
		response.setContentType("text/html;charset=utf-8");//返回的信息为utf-8
		PrintWriter out = response.getWriter();
		
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			User user1 = (User) request.getSession().getAttribute("user");
			int id = Integer.parseInt(request.getParameter("id"));
			String comment = request.getParameter("comment");
			String username = user1.getName();
			Comment_operation comm_op = new Comment_operation();
			Comment comment1 = new Comment();
			Comment comment2 = new Comment();
			boolean a = false;
			try {
				comment2 = comm_op.find(id);
				if((username).equals(comment2.getComment_user()) || (username).equals("admin")) {
					comment1.setId(id);
					comment1.setComment(comment);
					a = comm_op.update_comment(comment1);
				}else {
					out.println("<script language='javascript'>alert('不得编辑他人评论!');self.location='myspace.jsp';</script>");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (a){ 
				if(user1.getName().equals("admin")) {
					out.println("<script language='javascript'>alert('修改评论成功!');self.location='admin/content_manage.jsp';</script>");
				}else {
					out.println("<script language='javascript'>alert('修改评论成功!');self.location='myspace.jsp';</script>");
				}
			}else{
				if(user1.getName().equals("admin")) {
					out.println("<script language='javascript'>alert('修改评论失败!');self.location='admin/content_manage.jsp';</script>");
				}else {
					out.println("<script language='javascript'>alert('修改评论失败!');self.location='myspace.jsp';</script>");
				}
			}
			
			
			

		}else{
			out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");

		}
	}}
