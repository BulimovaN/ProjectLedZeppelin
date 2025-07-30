<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 24.07.2025
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>Квест</title>
</head>
<body>
<h2>${question}</h2>

<form method="post" action="next">
    <button type="submit" name="answer" value="1">${answer1}</button>
    <button type="submit" name="answer" value="2">${answer2}</button>
</form>

<hr>

<p><strong>Квест:</strong> ${sessionScope.questName}</p>
<p><strong>Текущий шаг:</strong> ${sessionScope.stepNumber}</p>
</body>
</html>
