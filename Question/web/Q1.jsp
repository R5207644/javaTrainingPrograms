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
                    <form action="Q1.jsp" method="POST">
                        <h1 class="form-control btn-lg btn-warning">Question 1: Which of the following is true about the <strong>final</strong> keyword in java?</h1>
                        <p class="form-control"><input type="radio" name="Q1" value="a" required="true"> A <b>final</b> class cannot be extended.</p>
                        <p class="form-control"><input type="radio" name="Q1" value="b"> A <b>final</b> method cannot be overridden.</p>
                        <p class="form-control"><input type="radio" name="Q1" value="c"> A <b>final</b> variable cannot be reassigned.</p>
                        <p class="form-control"><input type="radio" name="Q1" value="d"> All of the above.</p>
                        <p><input type="submit" value="Next" class="btn btn-primary"></p>
                    </form>
                </div>
            </div>
        </div>

        <%
            int right = 0, wrong = 0, marks = 0;
            String ans = "";
            if ("POST".equalsIgnoreCase(request.getMethod())) {

                ans = request.getParameter("Q1");

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
                response.sendRedirect("Q2.jsp");
            }
        %>
    </body>
</html>
