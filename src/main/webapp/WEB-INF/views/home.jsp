<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9 0009
  Time: 下午 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spitrr</title>
</head>
<body>
    <h1>Welcome to Spittr</h1>
    <a href="<c:url value='/spittle'/>">Spittle</a> |
    <a href="<c:url value='/spitter/register'/>">Register</a>
    <form action="/spittle/register" method="post">
        <input placeholder="请输入用户名"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
