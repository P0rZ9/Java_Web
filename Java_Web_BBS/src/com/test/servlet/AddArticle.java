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
 * Servlet implementation class AddArticle
 */
@WebServlet("/AddArticle")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //使接收的参数值为utf-8格式
		response.setContentType("text/html;charset=utf-8");//返回的信息为utf-8
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("user")!=""){
			String submit = request.getParameter("article_submit");
			if(submit!=null){
				Articles article1 = new Articles();
				String article_content = request.getParameter("article_content");
				String author = request.getParameter("author");
				article1.setAuthor(author);
				article1.setContent(article_content);
				Content_operation con_op1 = new Content_operation();
				boolean a = false;
				try {
					
					a = con_op1.insert_article(article1);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				User user1 = (User) request.getSession().getAttribute("user");
				if (a){ 
					
					if((user1.getName().equals("admin"))) {
						out.println("<script language='javascript'>alert('新增文章成功!');self.location='admin/content_manage.jsp';</script>");
					}
					else {
					out.println("<script language='javascript'>alert('发布成功!');window.location.href='home.jsp';</script>");
					
				}}else{
					if(user1.getName().equals("admin")) {
						out.println("<script language='javascript'>alert('新增文章失败!');self.location='admin/content_manage.jsp';</script>");
					}
					else {
						out.println("<script language='javascript'>alert('发布失败!');window.location.href='home.jsp';</script>");

				}}
			}
			
			}
		
	}
		
	}

