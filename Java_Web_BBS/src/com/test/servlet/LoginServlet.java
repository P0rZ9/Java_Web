package com.test.servlet;
import java.sql.*;
import com.test.bean.*;
import com.test.service.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		User_operation user1_op = new User_operation();//��ʼ���û���������
		boolean x = false;
		try {
			x = user1_op.user_exist(username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}//�ж��û����Ƿ����
		request.setCharacterEncoding("utf-8");//��ֹ�����������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(x){//���ڴ��û���
			
			User user1 = null;
			try {
				user1 = user1_op.find_user_by_name(username);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(password.equals(user1.getPassword())){	
				request.getSession().setAttribute("user", user1);
				String autoLogin = request.getParameter("autoLogin");
				if(autoLogin != null) {
					Cookie cookie = new Cookie("autoLogin",username+"-"+password);
					cookie.setMaxAge(Integer.parseInt(autoLogin));
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
				
				
				out.println("<script language='javascript'>alert('��¼�ɹ���');window.location.href='home.jsp';</script>");
			}else{
				//request.setAttribute("errerMsg", "�û����������");
				
				
				out.println("<script language='javascript'>alert('�������');window.location.href='login.jsp';</script>");
			}
			
		}else{
			out.println("<script language='javascript'>alert('�û��������ڣ�');window.location.href='login.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
