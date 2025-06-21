<%-- 
    Document   : Start
    Created on : 14 Feb 2025, 5:13:14 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Exam</title>
        <link href="Static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Static/css/question.css" rel="stylesheet" type="text/css"/>
        <style>
            p input {
                border: 2px solid green;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>

        <div class="main">
            <div class="top">
                <h1>Online Exam 2025</h1>
            </div>
            <div class="bottom">
                <div class="left">
                    <img src="Static/img/logo.jpg" alt="user"/>
                </div>
                <div class="container" style="margin-top: 40px;">
                    <form action="Start.jsp" method="post">
                        <p class="form-control " >
                           <strong> Enter Your name</strong>
                            <input type="text" name="name" >
                        
                        </p>
                        <input type="submit" value="Start Test" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>




        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String name = request.getParameter("name");
                session.setAttribute("name", name);
                response.sendRedirect("Q1.jsp");
            }
        %>
    </body>
</html>
