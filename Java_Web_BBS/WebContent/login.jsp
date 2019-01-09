<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./include/header.jsp" flush="true" />

<form name="form1" action="LoginServlet" method="post">
	<table name="table1" align="center">
			<tr>
				<td>用户名</td>  
				<td>                
					<input type="text" name="username" size="14" maxlength="10" placeholder="用户名" />
					
				</td> 
			</tr>
			<tr>
				<td>密码</td>  
				<td>                
					<input type="password" name="password" maxlength="20" size="14" placeholder="密码" />
				</td> 
			</tr>
			
			<tr>
				<td>自动登陆时间</td>  
				<td>                
					<input type="radio" name="autologin" value="${60*60*24*31 }" >一个月</input>
					<input type="radio" name="autologin" value="${60*60*24*31*3 }" >三个月</input>
					<input type="radio" name="autologin" value="${60*60*24*31*6 }" >六个月</input>
				</td> 
			</tr>

	</table>
	<p align="center">
		<input type="submit" value="login" name="submit" onclick="return checkform1()">
		<input type="reset" value="reset" name="reset" onclick="window.location.href='index.jsp';">
			
	</p>
</form>


<jsp:include page="./include/footer.jsp" flush="true" />
</body>
</html>






