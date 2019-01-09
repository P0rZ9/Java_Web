<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.util.*,java.util.ArrayList,com.test.bean.*,java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>新增用户</title>
</head>
<body>
<h3 align="center">新增用户信息</h3>
<form name="form" action="../RegServlet" method="POST">
	<table border="0" align="center">
		<tr>
			<td>用户名:</td>  
			<td>                
				<input type="text" name="username" size="14" maxlength="10" ></input>
			</td> 
		</tr>
		<tr>
			<td>密码:</td>  
			<td>                
				<input type="password" name="password" maxlength="20" size="14" ></input>
			</td> 
		</tr>

		

		<tr>
			<td>E-mail:</td>  
			<td>                
				<input type="email" name="email" size="30"></input>
			</td> 
		</tr>
		
		<tr>
			<td>性别:</td>  
			<td>                
				<input type="radio" name="sex" value="0" checked="checked">girl
				<input type="radio" name="sex" value="1">boy
			</td> 
		</tr>

		<tr>
			<td>个人简介:</td>  
			<td>                
				<textarea name="add_message" cols="20" rows="5" wrap="soft"></textarea>
			</td> 
		</tr>
	</table>
	<p style="text-align: center;">
		<input type="submit" value="add" name="submit">
		<input type="reset" value="reset">
	</p>
</form>
</body>
</html>

