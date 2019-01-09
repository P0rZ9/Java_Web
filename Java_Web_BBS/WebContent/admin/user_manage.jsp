<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>用户管理界面</title>
</head>
<body>
<input type="button" right="20px" name="home" value="首页" onclick="window.location.href='manage.jsp'" />
<input type="button" right="10px" name="logout" value="注销" onclick="window.location.href='../logout.jsp'" />

<jsp:include page='<%="/ShowAllUser" %>'></jsp:include>
   <table border="1" align="center">
    <tr>
        <td>Id</td>
        <td>name</td>
        <td>Email</td>
        <td>Sex</td>
        <td colspan="2" align="center"><a href="user_add.jsp">添加用户</a></td>
    </tr>	
<c:forEach var="name" items="${list }">
	<tr>
		<td>${name.getId()}</td>
		<td>${name.getName()}</td>
		<td>${name.getEmail()}</td>
		<td>
			<c:if test="${name.getSex() eq 1}">男</c:if>
            <c:if test="${name.getSex() eq 0}">女</c:if>
        </td>
		<td><a href="../UpdateUser?id=${name.getId()}">编辑</a></td>
		<td><a href="../DelUser?id=${name.getId()}">删除</a></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
