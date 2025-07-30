<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
  <title>Создание квеста</title>
</head>
<body>
<h1>Создать новый квест</h1>

<form action="create" method="post">
  <label>Название квеста:</label><br>
  <input type="text" name="name" required><br><br>

  <!-- Шаг 1 -->
  <h3>Шаг 1</h3>
  <label>Вопрос:</label><br>
  <input type="text" name="q1" required><br>
  <label>Ответ 1:</label><br>
  <input type="text" name="a1" required><br>
  <label>Ответ 2:</label><br>
  <input type="text" name="a2" required><br>
  <label>Правильный ответ:</label><br>
  <select name="correct1">
    <option value="1">Ответ 1</option>
    <option value="2">Ответ 2</option>
  </select><br><br>

  <!-- Шаг 2 -->
  <h3>Шаг 2</h3>
  <label>Вопрос:</label><br>
  <input type="text" name="q2" required><br>
  <label>Ответ 1:</label><br>
  <input type="text" name="b1" required><br>
  <label>Ответ 2:</label><br>
  <input type="text" name="b2" required><br>
  <label>Правильный ответ:</label><br>
  <select name="correct2">
    <option value="1">Ответ 1</option>
    <option value="2">Ответ 2</option>
  </select><br><br>

  <!-- Шаг 3 -->
  <h3>Шаг 3</h3>
  <label>Вопрос:</label><br>
  <input type="text" name="q3" required><br>
  <label>Ответ 1:</label><br>
  <input type="text" name="c1" required><br>
  <label>Ответ 2:</label><br>
  <input type="text" name="c2" required><br>
  <label>Правильный ответ:</label><br>
  <select name="correct3">
    <option value="1">Ответ 1</option>
    <option value="2">Ответ 2</option>
  </select><br><br>

  <button type="submit">Создать квест</button>
</form>

<a href="home">Вернуться</a>
</body>
</html>