<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 30.07.2025
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Login</title></head>
<body>
<h2>Вход</h2>
<form action="login" method="post">
    <label>Логин: <input type="text" name="username"/></label><br/>
    <label>Пароль: <input type="password" name="password"/></label><br/>
    <input type="submit" value="Войти"/>
</form>
<% if (request.getAttribute("error") != null) { %>
<p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
<a href="register.jsp">Нет аккаунта? Зарегистрироваться</a>
<br/><br/>
<form action="/" method="get" style="display:inline;">
    <button type="submit">Home</button>
</form>
</body>
</html>
