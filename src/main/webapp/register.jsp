<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 31.07.2025
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Регистрация</title>
</head>
<body>
<h2>Регистрация</h2>

<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form method="post" action="register">
  <label>Логин: <input type="text" name="username" required></label><br>
  <label>Пароль: <input type="password" name="password" required></label><br>
  <button type="submit">Зарегистрироваться</button>
</form>

<a href="login.jsp">Уже есть аккаунт? Войти</a>
<br/><br/>
<form action="/" method="get" style="display:inline;">
  <button type="submit">Home</button>
</form>
</body>
</html>
