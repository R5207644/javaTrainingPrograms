<%-- 
    Document   : Login
    Created on : 15 Feb 2025, 4:52:19 pm
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
            String email;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                email = request.getParameter("email");
                if (email.equals("")) {
                    response.sendRedirect("index.html");
                }
                session.setAttribute("email", email);
                session.setMaxInactiveInterval(60);
                response.sendRedirect("Dashboard.jsp");
            }
        %>
        
        
    </body>
</html>
