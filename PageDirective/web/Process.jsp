<%-- 
    Document   : First
    Created on : 19 Feb 2025, 4:28:47 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Division</title>
    </head>
    <body>
        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                int c = a / b;
                out.print(c);
                response.sendRedirect("..;c.lxcijdscjhhgtvdecswa345678");
            }
        %>
    </body>
</html>
