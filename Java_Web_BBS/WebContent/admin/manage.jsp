<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.test.util.*,java.sql.*,com.test.bean.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理页面</title>
	<h1 align="center">后台管理:</h1>
</head>
<body>
<%	
	if(session.getAttribute("user")!=""){
	
%>
<table border="0" align="center">

	<tr>
		<td>
			<a href="user_manage.jsp">用户管理	
		</td>	
		
	</tr>
		
	<tr>
		<td>
			<a href="content_manage.jsp">文章管理	
		</td>	
	</tr>

<%}else{
	out.println("<script language='javascript'>alert('您未登陆！');window.location.href='login.jsp';</script>");

}  %>
</table>
</body>
</html>


