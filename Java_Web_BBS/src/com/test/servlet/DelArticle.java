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
 * Servlet implementation class DelArticle
 */
@WebServlet("/DelArticle")
public class DelArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			User user1 = (User) request.getSession().getAttribute("user");
			int id = Integer.parseInt(request.getParameter("id"));
			String username = user1.getName();
			Content_operation con1_op = new Content_operation();//文章操作
			Articles article1 = new Articles();
			boolean a = false;
			try {
				//a = con1_op.del_article(id);
				article1 = con1_op.find(id);
				if((username).equals(article1.getAuthor()) || (username).equals("admin")) {
					a = con1_op.del_article(id);
				}else {
					out.println("<script language='javascript'>alert('不得删除他人文章!');self.location='myspace.jsp';</script>");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (a){ 
				out.println("<script language='javascript'>alert('删除文章成功!');self.location=document.referrer;</script>");
				
			}else{
				out.println("<script language='javascript'>alert('删除文章失败!');self.location=document.referrer;</script>");

			}

		}else{
			out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");

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
