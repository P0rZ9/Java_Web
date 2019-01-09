<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.bean.*" %>
<%@ page import="com.test.util.*" %>
<!DOCTYPE html>
<html> 
<head>
<script language="javascript">
	function checkform1(){
		if(document.form1.username.value==""){
			alert("用户名不能为空");
			document.form1.username.focus();//将焦点回到用户名处
			return false;	
		}
		if(document.form1.password.value==""){
			alert("密码不能为空");
			document.form1.password.focus();
			return false;	
		}	
}
</script>
<meta charset="UTF-8">
<title>Java_web 论坛后台管理</title>
<h1 align="center">Java_web 论坛后台管理</h1>
</head>
<body>


<form name="form1" action="../LoginAdminServlet" method="post">
	<table name="table1" align="center">
			<tr>
				<td>用户名</td>  
				<td>                
					<input type="text" name="username" size="14" maxlength="10" placeholder="用户名"></input>
				</td> 
			</tr>
			<tr>
				<td>密码</td>  
				<td>                
					<input type="password" name="password"  maxlength="20" size="14" placeholder="密码"></input>
				</td> 
			</tr>

	</table>
	<p align="center">
		<input type="submit" value="login" name="submit" onclick="return checkform1()">
		<input type="reset" value="reset" name="reset" onclick="window.location.href='login.jsp';">
			
	</p>
</form>
</body>
</html>  


  