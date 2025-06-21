<%-- 
    Document   : Logout
    Created on : 15 Feb 2025, 4:59:51 pm
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
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                session.setAttribute("email", "");
                response.sendRedirect("index.html");
            }
        %>
    </body>
</html>
