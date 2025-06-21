<%-- 
    Document   : Student
    Created on : 29 Apr 2025, 12:45:31 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name, grade, gender;
            int age;
            if ("POST".equalsIgnoreCase(request.getMethod())){
                name = request.getParameter("name");
                grade = request.getParameter("grade");
                gender = request.getParameter("gender");
                age = Integer.parseInt(request.getParameter("age"));
                session.setMaxInactiveInterval(30);
                Student s = new Student();
                s.setName(name);
                s.setGrade(grade);
                s.setGender(gender);
                s.setAge(age);
                
                session.setAttribute("s", s);
                response.sendRedirect("PrintDetails.jsp");
            }
        %>
    </body>
</html>
