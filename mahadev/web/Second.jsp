<%-- 
    Document   : Second
    Created on : 11 Feb 2025, 5:05:21 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="icon" href="static/img/logo.jpg"/>
    </head>
    <body>
        <h2>Second page</h2>
        <%
            String email = (String)session.getAttribute("email");
            out.print("Welcome " + email);
        %>
    </body>
</html>
