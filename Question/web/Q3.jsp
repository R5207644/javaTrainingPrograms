<%-- 
    Document   : Q1
    Created on : 13 Feb 2025, 4:25:25 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Q1</title>
        <link href="Static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Static/css/question.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <div class="top">
                <h1>Online Exam 2025</h1>
            </div>
            <div class="bottom">
                <div class="left">
                    <img src="Static/img/logo.jpg" alt="user"/>
                    <h3>Welcome, <%out.print(session.getAttribute("name"));%></h3>
                </div>
                <div class="container">
                    <form method="POST">
                        <h1 class="form-control btn-lg btn-warning">What is the default access modifier for a class in java</h1>
                        <p class="form-control"><input type="radio" name="Q3" value="a" required="true"> public</p>
                        <p class="form-control"><input type="radio" name="Q3" value="b"> private</p>
                        <p class="form-control"><input type="radio" name="Q3" value="c"> protected</p>
                        <p class="form-control"><input type="radio" name="Q3" value="d"> Package-private(no modifier)</p>
                        <p><input type="submit" value="Next" class="btn btn-primary"></p>
                    </form>
                </div>
            </div>
        </div>

        <%
            int right, wrong, marks;
            String ans;
            right = (Integer) session.getAttribute("right");
            wrong = (Integer) session.getAttribute("wrong");
            marks = (Integer) session.getAttribute("marks");
            if ("POST".equalsIgnoreCase(request.getMethod())) {

                ans = request.getParameter("Q3");

                if (ans.equals("d")) {
                    right++;
                    marks = marks + 5;
                } else {
                    wrong++;
                    marks = marks - 1;
                }

                session.setAttribute("right", right);
                session.setAttribute("wrong", wrong);
                session.setAttribute("marks", marks);
                response.sendRedirect("Q4.jsp");
            }
        %>
    </body>
</html>
