<%--
  Created by IntelliJ IDEA.
  User: n.bulimova
  Date: 30.07.2025
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
  HttpSession currentSession = request.getSession(false);
  String uri = request.getRequestURI();

  if (currentSession == null || currentSession.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
    return;
  }

  String user = (String) currentSession.getAttribute("user");
%>

<nav>
  <span> <%= user %></span>

  <form action="/" method="get" style="display:inline;">
    <button type="submit">Home</button>
  </form>
  <form action="logout" method="get" style="display:inline;">
    <button type="submit">Logout</button>
  </form>
</nav>
<hr/>