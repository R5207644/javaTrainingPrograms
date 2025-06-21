<%-- 
    Document   : Register
    Created on : 2 Jan 2025, 4:34:19 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%
            String uname=request.getParameter("uname");
            String gender = request.getParameter("gender");
            String course = request.getParameter("course");
            
            out.print("<p>name: " + uname + "</p>");
            out.print("<p>gender: " + gender + "</p>");
            out.print("<p>course: " + course + "</p>");
        %>
    </body>
</html>
