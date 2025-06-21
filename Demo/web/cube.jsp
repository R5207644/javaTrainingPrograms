<%-- 
    Document   : cube
    Created on : 7 Jan 2025, 4:50:03 pm
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
        <%!
            int cube(int x) {
            return x * x * x;
        }
        %>
        
        cube = <%
            int n = Integer.parseInt(request.getParameter("n"));
            out.print(cube(n));
        %>
    </body>
</html>
