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
			<input type="button" name="home" value="首页" onclick="window.location.href='home.jsp'" />			
		</td>
		<td>
			<input type="button" name="logout" value="注销" onclick="window.location.href='./LogoutServlet'" />
		</td>
	</tr>

</table>


<p style="color: red;">${article.getAuthor() }的文章:${article.getContent() }<br /></p>
<table border="10" align="left">
    <tr>
    	<td>评论ID</td>
        <td>评论作者</td>
        <td>评论内容</td>
    </tr>
<c:forEach var="name" items="${list }">
	<tr>
		<td>${name.getId()}</td>
		<td>${name.getComment_user()}</td>
		<td>${name.getComment()}</td>
	</tr>
</c:forEach>
</table>
<br />
<form name="form" action="AddComment" method="post">
	<input type="hidden" name="comment_author" value="${sessionScope.user.name} " />
	<input type="hidden" name="aiticle_id" value="${article.getId() }" />
	<input type="text" name="comment" size="30" maxlength="30" placeholder="评论内容" />
	<input type="submit" name="comment_submit" value="发布" />
</form>
</body>
</html>










