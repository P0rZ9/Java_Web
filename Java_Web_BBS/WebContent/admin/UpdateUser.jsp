<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="<%= basePath %>" />
<title>编辑用户信息</title>
</head>
<body>


<h4>正在编辑用户${user.getName() }的个人信息</h4>

<form action="UpdateUser" method="post">
	<table>
		<input type="hidden" value="${user.getId() }" name="id"/><br />
		<tr>
			<td>用户名:</td>  
			<td>                
				<input type="text" value="${user.getName() }" name="name" readonly/><br />
			</td> 
		</tr>
		<tr>
			<td>密码:</td>  
			<td>                
				<input type="text" value="${user.getPassword() }" name="pwd"/>			</td> 
		</tr>
		
		<tr>
			<td>邮箱:</td>  
			<td>                
				<input type="text" value="${user.getEmail() }" name="email"/>
			</td> 
		</tr>
		
		<tr>
			<td>性别:</td>  
			<td>
				<c:if test="${user.getSex() eq 1}">男</c:if>
            	<c:if test="${user.getSex() eq 0}">女</c:if>
        	</td>
		</tr>
		
		<tr>
			<td>个人简介:</td>  
			<td>                
				<textarea name="message" cols="20" rows="5" wrap="soft">${user.getProfile() }</textarea>
			</td> 
		</tr>
		
		
		
		<tr>
			<td>
				<input type="submit" value="修改" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>