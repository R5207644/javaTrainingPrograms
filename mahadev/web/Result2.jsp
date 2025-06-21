<%-- 
    Document   : Result2
    Created on : 13 Feb 2025, 4:51:32 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Result</title>

    </head>
    <body>
        <%
            int right, wrong, marks;
            right = (Integer)session.getAttribute("right");
            wrong = (Integer)session.getAttribute("wrong");
            marks = (Integer)session.getAttribute("marks");
        %>
        <div class="container">
                <table class="table table-hover">
                    <tr>
                        <h3 align="center">Result</h3>
                    </tr>
                    <tr>
                        <td>Right</td>
                        <td><%out.print(right);%></td>
                    </tr>
                    <tr>
                        <td>Wrong</td>
                        <td><%out.print(wrong);%></td>
                    </tr>
                    <tr>
                        <td>Marks</td>
                        <td><%out.print(marks);%></td>
                    </tr>
                </table>
            </div>
      
    </body>
</html>
