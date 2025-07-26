<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 26.07.2025
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h1>Добро пожаловать в игру!</h1>
<p>Выберите квест:</p>
<form action="startQuest" method="post">
    <input type="radio" id="ufo" name="quest" value="ufo" checked>
    <label for="ufo">Контакт с НЛО</label><br>

<%--    <input type="radio" id="space" name="quest" value="space">--%>
<%--    <label for="space">Космическое приключение</label><br>--%>

    <button type="submit">Начать выбранный квест</button>
</form>
</body>
</html>
