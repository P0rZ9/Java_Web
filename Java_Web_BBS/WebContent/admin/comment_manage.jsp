<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
<script type="text/javascript">
</script>
</head>
<body>
<table>
	<tr>
		<td>
			<input type="button" name="home" value="首页" onclick="window.location.href='admin/manage.jsp'" />			
		</td>
		<td>
			<input type="button" name="logout" value="注销" onclick="window.location.href='./LogoutServlet'" />
		</td>
	</tr>

</table>
<p style="color: red;">${article.getAuthor() }的文章:${article.getContent() }<br /></p>

<table border="2">
    <tr>
    	<td>评论Id</td>
        <td>文章Id</td>
        <td>评论内容</td>
        <td colspan="2" align="center">评论操作</td>

    </tr>	
<c:forEach var="name1" items="${list }">
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
<br />
<form name="form" action="AddComment" method="post">
	<input type="hidden" name="comment_author" value="${sessionScope.user.name}" />
	<input type="hidden" name="aiticle_id" value="${article.getId() }" />
	<input type="text" name="comment" size="30" maxlength="30" placeholder="评论内容" />
	<input type="submit" name="comment_submit" value="发布" />
</form>
</body>
</html>










