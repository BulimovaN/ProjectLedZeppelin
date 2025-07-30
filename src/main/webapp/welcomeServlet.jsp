<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 30.07.2025
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%

    String user = (session != null) ? (String) session.getAttribute("user") : null;
%>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h1>Добро пожаловать в квест!</h1>

<% if (user != null) { %>
<h3>Привет, <%= user %>!</h3>
<% } %>

<% if (user == null) { %>
<form action="login.jsp" method="get">
    <button type="submit">Войти</button>
</form>
<form action="register.jsp" method="get">
    <button type="submit">Регистрация</button>
</form>
<% } else { %>
<form action="home" method="get">
    <button type="submit">Перейти к квестам</button>
</form>
<form action="logout" method="get">
    <button type="submit">Выход</button>
</form>
<% } %>
</body>
</html>
