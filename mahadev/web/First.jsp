<%-- 
    Document   : First
    Created on : 11 Feb 2025, 5:05:02 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First</title>
        <link rel="icon" href="static/img/logo.jpg"/>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(10);
            out.print("Welcome " + email);
        %>
        <a href="Second.jsp">visit second</a>
    </body>
</html>
