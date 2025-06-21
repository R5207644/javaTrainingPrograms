<%-- 
    Document   : email
    Created on : 7 Jan 2025, 4:26:57 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>email page</title>
    </head>
    <body>
        <p>Welcome, <%= request.getParameter("email") %></p>
    </body>
</html>
