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
 * Servlet implementation class ShowArticleDefault
 */
@WebServlet("/ShowArticleDefault")
public class ShowArticleDefault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleDefault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user1 = (User) request.getSession().getAttribute("user");
		if(request.getSession().getAttribute("user")!=""&&request.getSession().getAttribute("user")!=null){
			String username = user1.getName();
			int id = Integer.parseInt(request.getParameter("id"));
			Content_operation con1_op = new Content_operation();//文章
			Comment_operation comm1_op = new Comment_operation();//评论
			ArrayList<Comment> list2 = null;
			Articles article1 = null;
			try {
				article1 = con1_op.find(id);
				list2 = comm1_op.list_all_comment(id);//得到评论列表
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//得到文章详情
			request.setAttribute("article", article1); //在JSP页面直接用EL表达式获取属性即可
			request.setAttribute("list", list2); //可用<c:foreach>循环获取
			if(user1.getName().equals("admin")){
				request.getRequestDispatcher("admin/comment_manage.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("default.jsp").forward(request, response);
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
