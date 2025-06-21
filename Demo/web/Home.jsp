<%-- 
    Document   : Home
    Created on : 2 Jan 2025, 4:27:46 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            out.print("verified email " + email);
        %>
    </body>
</html>
