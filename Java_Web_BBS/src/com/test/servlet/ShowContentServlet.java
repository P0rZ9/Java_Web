package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.*;
import com.test.service.*;
/**
 * Servlet implementation class ShowContentServlet
 */
@WebServlet("/ShowContentServlet")
public class ShowContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			User user1 = (User) request.getSession().getAttribute("user");
			String username = user1.getName();
			
			//�ж��û��Ƿ��½   ��Ϊtrue��Ĳ���

			User_operation user1_op = new User_operation();//��ʼ���û���������

			//��ʾ����
			Content_operation con1_op = new Content_operation();
			ArrayList<Articles> list1 = con1_op.List_all_article();
			request.setAttribute("list", list1);
		}else{
			out.println("<script language='javascript'>alert('��δ��½��');window.location.href='login.jsp';</script>");

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
