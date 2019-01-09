<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<base href="<%= basePath %>" />
<title>default page</title>
</head>
<body>
<form action="UpdateComment" method="post">
	<input type="hidden" value="${comment.getId() }" name="id"/>
	<textarea name="comment">${comment.getComment() }</textarea>
	<input type="submit" value="修改" />
</form>

</body>
</html>