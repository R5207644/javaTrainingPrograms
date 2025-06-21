<%-- 
    Document   : Register
    Created on : 13 Dec 2024, 12:58:15 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>scriptlet</title>
    </head>
    <body>
        <%
            String name,email;
            name = request.getParameter("uname");
            email = request.getParameter("email");
            out.print("Name= " + name);
            out.print("<br>email = "+email);
        %>
    </body>
</html>
