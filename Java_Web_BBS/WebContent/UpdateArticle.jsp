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
<title>编辑文章</title>
</head>
<body>

<%
//接收参数 显示修改文章
%>

<form action="UpdateArticle" method="post">
	<input type="hidden" value="${article.getId() }" name="id"/>
	<textarea name="article_content">${article.getContent() }</textarea>
	<input type="submit" value="修改" />
</form>


</body>
</html>