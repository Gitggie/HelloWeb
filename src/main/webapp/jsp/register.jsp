<%--
  Created by IntelliJ IDEA.
  User: WuLei
  Date: 2018/3/2
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<html>
<head>
    <title>login</title>
</head>
<body>
<%--<fmt:formatDate value="${now}" pattern="yyyy年MM月dd日"/>不知道怎么用--%>
<form id="login" action="${pageContext.request.contextPath}/register" method="post">
    请注册
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
