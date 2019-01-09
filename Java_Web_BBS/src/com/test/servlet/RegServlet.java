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
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//接收post过来的数据:
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int sex=Integer.parseInt(request.getParameter("sex"));
		//Date da = 
		String profile = request.getParameter("add_message");


		User_operation user1_op = new User_operation();//初始化用户操作对象
		boolean x = false;
		try {
			x = user1_op.user_exist(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(x){
			out.println("<script language='javascript'>alert('用户名已存在!');self.location=document.referrer;</script>");
		}else{
			User user1 = new User();
			user1.setName(username);
			user1.setPassword(password);
			user1.setEmail(email);
			user1.setSex(sex);
			user1.setProfile(profile);
			boolean a = false;
			try {
				a = user1_op.insert(user1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//使用insert插入对象
			if(a){
				if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null) {
					User user2 = (User) request.getSession().getAttribute("user");
					if(user2.getName().equals("admin")) {
						out.println("<script language='javascript'>alert('新增用户成功!');window.location.href='admin/user_manage.jsp';</script>");
					}
					}
				else {
					out.println("<script language='javascript'>alert('注册成功!');window.location.href='login.jsp';</script>");
			}}else{
				User user3 = (User) request.getSession().getAttribute("user");
				if(user3.getName().equals("admin")) {
					out.println("<script language='javascript'>alert('新增用户失败!');window.location.href='admin/user_manage.jsp';</script>");
				}else {
				out.println("<script language='javascript'>alert('注册失败!');window.location.href='reg.jsp';</script>");

			}}
		}
	}

}
