<%-- 
    Document   : sum
    Created on : 10 Feb 2025, 4:26:03 pm
    Author     : Sarvesh Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum</title>
        <link href="static/css/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="static/css/js/bootstrap.min.js"></script>
    </head>
    <body>
        <form action="sum.jsp" method="post">
        <table class="container">
            <tr>
                <td>First No.</td>
                <td><input type="text" name="num1"></td>
            </tr>
            <tr>
                <td>Second No.</td>
                <td><input type="text" name="num2"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Sum" name="sum"></td>
            </tr>
              <%
            int sum=0, num1, num2;
            if("POST".equalsIgnoreCase(request.getMethod())) {
                num1 = Integer.parseInt(request.getParameter("num1"));
                num2 = Integer.parseInt(request.getParameter("num2"));
                 sum = num1 + num2;
            }
          %>
            <tr>
                <td>Result</td>
                <td><input type="text" value="<% out.print(sum);%>"></td>
            </tr>
        </table>
      </form>
            <a href="#" class="btn btn-success btn-lg">Click me</a>
      
    </body>
</html>
