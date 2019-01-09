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
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username").getBytes("ISO8859_1"),"utf-8");
		String password = new String(request.getParameter("password").getBytes("ISO8859_1"),"utf-8");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		User_operation user1_op = new User_operation();//初始化用户操作对象
		if(username.equals("admin")){
			User user1;
			try {
				user1 = user1_op.find_user_by_name(username);
				if(password.equals(user1.getPassword())){
					request.getSession().setAttribute("user", user1);
					
					out.println("<script language='javascript'>alert('登录成功！');window.location.href='admin/manage.jsp';</script>");
				}else{
					out.println("<script language='javascript'>alert('密码错误！');window.location.href='admin/login.jsp';</script>");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			out.println("<script language='javascript'>alert('用户名错误！');window.location.href='admin/login.jsp';</script>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
