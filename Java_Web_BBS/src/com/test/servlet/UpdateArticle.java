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
 * Servlet implementation class UpdateArticle
 */
@WebServlet("/UpdateArticle")
public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //ʹ���յĲ���ֵΪutf-8��ʽ
		response.setContentType("text/html;charset=utf-8");//���ص���ϢΪutf-8
		PrintWriter out = response.getWriter();
		User user1 = (User) request.getSession().getAttribute("user");
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			Content_operation con1_op = new Content_operation();//���²���
			//boolean a = false;
			Articles article1 = null;
			try {
				article1 = con1_op.find(id);
				//a = con1_op.update_article(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("article", article1);
			request.getRequestDispatcher("UpdateArticle.jsp").forward(request, response);

		}else{
			out.println("<script language='javascript'>alert('��δ��½��');window.location.href='login.jsp';</script>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //ʹ���յĲ���ֵΪutf-8��ʽ
		response.setContentType("text/html;charset=utf-8");//���ص���ϢΪutf-8
		PrintWriter out = response.getWriter();
		
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			User user1 = (User) request.getSession().getAttribute("user");
			String username = user1.getName();
			String article_content = request.getParameter("article_content");//�õ�content
			Content_operation con2_op = new Content_operation();//���²���
			Articles article2 = new Articles();
			Articles article3 = new Articles();
			boolean a = false;
			try {
				article3 = con2_op.find(id);
				if((username).equals(article3.getAuthor()) || (username).equals("admin")) {
					article2.setId(id);
					article2.setContent(article_content);
					a = con2_op.update_article(article2);
				}else {
					out.println("<script language='javascript'>alert('���ñ༭��������!');self.location='myspace.jsp';</script>");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (a){ 
				if(user1.getName().equals("admin")) {
					out.println("<script language='javascript'>alert('�޸����³ɹ�!');self.location='admin/content_manage.jsp';</script>");
				}
				else {
				out.println("<script language='javascript'>alert('�޸����³ɹ�!');self.location='myspace.jsp';</script>");
				
			}}else{
				if(user1.getName().equals("admin")) {
					out.println("<script language='javascript'>alert('�޸�����ʧ��!');self.location='admin/content_manage.jsp';</script>");
				}else {
				out.println("<script language='javascript'>alert('�޸�����ʧ��!');self.location='myspace.jsp';</script>");

			}}
			
			
			

		}else{
			out.println("<script language='javascript'>alert('��δ��½��');window.location.href='login.jsp';</script>");

		}
	}}
