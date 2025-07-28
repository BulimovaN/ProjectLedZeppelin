<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javarush.bulimova.quest.Quest" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h1>Выбор квеста</h1>

<form action="createQuest.jsp" method="get">
    <button type="submit">Создать новый квест</button>
</form>

<h2>Доступные квесты:</h2>
<ul>
    <%
        List<Quest> quests = (List<Quest>) request.getAttribute("quests");
        if (quests != null && !quests.isEmpty()) {
            for (int i = 0; i < quests.size(); i++) {
    %>
    <li>
        <form action="start" method="get">
            <input type="hidden" name="questIndex" value="<%=i%>">
            <button type="submit"><%=quests.get(i).getName()%></button>
        </form>
    </li>
    <%
        }
    } else {
    %>
    <li>Квестов пока нет</li>
    <%
        }
    %>
</ul>
</body>
</html>