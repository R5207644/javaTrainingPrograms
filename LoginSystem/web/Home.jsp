<%-- 
    Document   : Home
    Created on : 10 Mar 2025, 5:19:02 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file="nav.html" %>
        <%
            String email = request.getParameter("email");
        %>
        <h1 class="text-center">welcome, <%out.print(email);%></h1>
        <p class="text-center"><a href="ChangePassword.jsp">ChangePassword</a></p>
    </body>
</html>
