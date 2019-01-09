<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<center><img src="./images/logo.jpg"></center>
	<TABLE cellSpacing="0" cellPadding="0" width="100%" bgColor="#0089cf" border="0" align="center">
	<TR>
	<TD>
	<TABLE cellSpacing="1" cellPadding="4" width="100%" border="0">
	<TR bgColor="#ccccff"></tr>
	<TR bgColor=#ffffff>
	<TD align="left" valign="top" width=<%= request.getParameter("width") %>>
</body>
</html>