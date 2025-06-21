<%-- 
    Document   : PrintDetails
    Created on : 29 Apr 2025, 5:12:04 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Details</title>
    </head>
    <body>
        <%
            Student s = (Student)session.getAttribute("s");
        %>
        <p>Name: <%=s.getName()%></p>
        <p>Grade: <%=s.getGrade()%></p>
        <p>Gender: <%=s.getGender()%></p>
        <p>Age: <%=s.getAge()%></p>
    </body>
</html>
