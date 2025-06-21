<%-- 
    Document   : declaration
    Created on : 7 Jan 2025, 4:37:06 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaration tag</title>
    </head>
    <body>
        <%! String name = "Sarvesh Kumar"; %>
        Welcome, <%= name %>
        
        <br>
        
        <%!
            int cube(int x) {
            return x * x * x;
        }
        %>
        
        cube = <%= cube(5)%>
    </body>
</html>
