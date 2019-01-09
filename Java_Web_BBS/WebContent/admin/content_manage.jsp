<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>文章管理</title>
</head>
<body>

<form name="form2" action="../AddArticle" method="post">
	<table name="article_table">
		<tr>
			<td>
				<input type="hidden" name="author" value="${sessionScope.user.name}" />
				<input type="text" name="article_content" size="50" maxlength="50" placeholder="文章内容" />
				<input type="submit" name="article_submit" value="发布" />
			</td>	
		</tr>
	</table>
</form>

<jsp:include page='<%="/ShowContentServlet" %>'></jsp:include>
<table border="1" align="center">
    <tr>
        <td>序号</td>
        <td>文章内容</td>
        <td>作者</td>
        <td>详情</td>
        <td colspan="2" align="center">文章操作</td>
    </tr>	
<c:forEach var="name" items="${list }">
	<tr>
		<td>${name.getId()}</td>
		<td>${name.getContent()}</td>
		<td>${name.getAuthor()}</td>
		<td><a href="../ShowArticleDefault?id=${name.getId()}">详情</a></td>
		<td><a href="../DelArticle?id=${name.getId()}">删除</a></td>
		<td><a href="../UpdateArticle?id=${name.getId()}">编辑</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>








