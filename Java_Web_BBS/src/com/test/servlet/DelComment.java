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
 * Servlet implementation class DelComment
 */
@WebServlet("/DelComment")
public class DelComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelComment() {
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
			User user = (User) request.getSession().getAttribute("user");
			int id = Integer.parseInt(request.getParameter("id"));
			Comment_operation comm_op = new Comment_operation();
			Comment com1 = new Comment();
			boolean a = false;
			try {
				//在删除之前进行权限判断
				com1 = comm_op.find(id);
				String username = user.getName();
				if((username).equals(com1.getComment_user()) || (username).equals("admin")) {
					a = comm_op.del_comment(id);
				}else {
					out.println("<script language='javascript'>alert('不得删除他人评论!');self.location='myspace.jsp';</script>");
				}

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			if (a){ 
					out.println("<script language='javascript'>alert('删除评论成功!');self.location=document.referrer;</script>");

			}else{
					out.println("<script language='javascript'>alert('删除评论失败!');self.location=document.referrer;</script>");
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
