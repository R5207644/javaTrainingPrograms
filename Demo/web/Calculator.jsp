<%-- 
    Document   : Calculator
    Created on : 2 Jan 2025, 5:18:59 pm
    Author     : sarvesh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>calculator</title>
    </head>
    <body>
        <%
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            String op = request.getParameter("op");
            int result = 0;
            
            if (op.equals("sum")) {
                result = num1 + num2;
            } else if (op.equals("sub")) {
               result = num1 - num2; 
            } else if (op.equals("mul")) {
               result = num1 * num2; 
            } else if (op.equals("div")) {
               result = num1 / num2; 
            } else {
                out.print("wrong choice");
                return;
            }
            
            out.print("result: " + result);
        %>
    </body>
</html>
