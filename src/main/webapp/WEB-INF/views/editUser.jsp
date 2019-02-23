<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <%-- 引入JQ和Bootstrap --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="include/js/jquery/2.0.0/jquery.min.js"></script>
        <link href="include/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
        <script src="include/js/bootstrap/3.3.6/bootstrap.min.js"></script>
        <link href="include/css/style.css" rel="stylesheet">

    <title>学生管理页面 - 编辑页面</title>
</head>

<body>

<div class="editDIV">

    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">编辑学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="/updateUserP" role="form">
                <table class="editTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="user_id" id="user_id" value="${user.user_id}"
                                   placeholder="请在这里输入学号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="username" id="name" value="${user.username}" placeholder="请在这里输入名字">
                        </td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="age" id="age" value="${user.age}" placeholder="请在这里输入年龄"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" <c:if test="${user.sex == '男'}">checked</c:if> class="radio radio-inline" name="sex" value="男"> 男
                            <input type="radio" <c:if test="${user.sex == '女'}">checked</c:if> class="radio radio-inline" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="birthday" id="birthday" value="${user.birthday}"
                                   placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>

                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>