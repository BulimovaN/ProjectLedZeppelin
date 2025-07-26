<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 24.07.2025
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<h2>${question}</h2>

<form method="post" action="next">
    <input type="hidden" name="step" value="${step}">
    <button type="submit" name="answer" value="1">${answer1}</button>
    <button type="submit" name="answer" value="2">${answer2}</button>
</form>
<hr>

<p><strong>Квест:</strong> ${sessionScope.questName}</p>
<p><strong>Текущий шаг:</strong> ${sessionScope.step}</p>
</body>
</html>
