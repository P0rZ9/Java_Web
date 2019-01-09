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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //修改为user类型的
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //使接收的参数值为utf-8格式
		response.setContentType("text/html;charset=utf-8");//返回的信息为utf-8
		PrintWriter out = response.getWriter();
		User user1 = (User) request.getSession().getAttribute("user");
		if(user1.getName().equals("admin")){
			int id = Integer.parseInt(request.getParameter("id"));
			User_operation user_op = new User_operation();//操作
			User user2 = null;
			try {
				user2 = user_op.find(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", user2);
			request.getRequestDispatcher("admin/UpdateUser.jsp").forward(request, response);

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
		User user2 = (User) request.getSession().getAttribute("user");
		if(user2.getName().equals("admin")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String profile = request.getParameter("message"); //个人信息
			User_operation user_op = new User_operation();
			User user1 = new User();
			boolean a = false;
			try {
				user1.setId(id);
				user1.setName(name);
				user1.setPassword(pwd);
				user1.setEmail(email);
				user1.setProfile(profile);
				
				a = user_op.update_user_info(user1);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (a){ 
				out.println("<script language='javascript'>alert('修改用户信息成功!');self.location='admin/user_manage.jsp';</script>");
				
			}else{
				out.println("<script language='javascript'>alert('修改用户信息失败!');self.location='admin/user_manage.jsp';</script>");

			}
			
			
			

		}else{
			out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");

		}
	}}