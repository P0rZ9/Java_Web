<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册</title>
<script language="javascript">
	function checkform(){
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
		if(document.form1.password.value!=document.form1.passconfirm.value){
			alert("确认密码不相符");
			document.form1.passconfirm.focus();
			return false;
		}
		if(document.form1.email.value==""){
			alert("邮箱不能为空");
			document.form1.email.focus();
			return false;
			
		}
	}
</script>
</head>
<body>
<jsp:include page="./include/header.jsp" flush="true" />
<h1 align="center">个人注册</h1>
<form name="form1" action="RegServlet" method="POST">
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
		
		<tr>
			<td>确认密码:</td>  
			<td>                
				<input type="password" name="passconfirm" maxlength="20" size="14"></input>
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
		<input type="submit" value="注册" onclick="return checkform();">
		<input type="reset" value="返回">
	</p>
</form>
<jsp:include page="./include/footer.jsp" flush="true" />
</body>
</html>