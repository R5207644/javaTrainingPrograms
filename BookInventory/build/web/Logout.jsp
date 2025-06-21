<%-- 
    Document   : Logout
    Created on : 19 Apr 2025, 12:18:08 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session.removeAttribute("uname");
            response.sendRedirect("home.jsp");
        %>
    </body>
</html>
