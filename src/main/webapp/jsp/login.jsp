<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2018/3/2
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form id="login" action="${pageContext.request.contextPath}/login" method="post">
    请登录
    <table>
        <tr>
            <td>name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <input type="submit" value="submit">
        </tr>
    </table>
</form>

</body>
</html>
