<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="button" name="home" value="首页" onclick="window.location.href='home.jsp'" />
<input type="button" name="logout" value="注销" onclick="window.location.href='./LogoutServlet'" />
<br />
<jsp:include page='<%="/ShowUserInfo" %>'></jsp:include>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>邮箱</td>
        <td>个人简介</td>
        <td>性别</td>
    </tr>	
	<tr>
		<td>${user.getName() }</td>
		<td>${user.getEmail()}</td>
		<td>${user.getProfile()}</td>
		<td>
			<c:if test="${user.getSex() eq 1}">男</c:if>
            <c:if test="${user.getSex() eq 0}">女</c:if>
        </td>
    </tr>

</table>
---------------------------<br />
发布的文章:
<table border="2">
    <tr>
        <td>文章内容</td>
        <td colspan="2" align="center">文章操作</td>

    </tr>	
<c:forEach var="name" items="${article_list }">
	<tr>
		<td>${name.getContent() }</td>
		<td><a href="DelArticle?id=${name.getId()}">删除</a></td>
		<td><a href="UpdateArticle?id=${name.getId()}">编辑</a></td>
    </tr>
</c:forEach>
</table>
---------------------------<br />
发布的评论:
<table border="2">
    <tr>
    	<td>评论Id</td>
        <td>文章Id</td>
        <td>评论内容</td>
        <td colspan="2" align="center">评论操作</td>

    </tr>	
<c:forEach var="name1" items="${comment_list }">
	<tr>
		<td>${name1.getId() }</td>
		<td>${name1.getArticle_id() }</td>
		<td>${name1.getComment() }</td>
		<td><a href="DelComment?id=${name1.getId()}">删除</a></td>
		<td><a href="UpdateComment?id=${name1.getId()}">编辑</a></td>
		
    </tr>
</c:forEach>
</table>
</body>
</html>