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
        <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/question..css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <div class="top">
                <h1>Online Exam 2025</h1>
            </div>
            <div class="bottom">
                <div class="left">
                    <img src="static/img/logo.jpg" alt="user"/>
                </div>
                <div class="container">
                    <form action="Q1.jsp" method="POST">
                        <h1 class="form-control btn-lg btn-warning">Who is the president of america</h1>
                        <p class="form-control"><input type="radio" name="Q1" value="a" required="true"> Donald Trump</p>
                        <p class="form-control"><input type="radio" name="Q1" value="b"> Jo Biden</p>
                        <p class="form-control"><input type="radio" name="Q1" value="c"> Abrahm linken</p>
                        <p class="form-control"><input type="radio" name="Q1" value="d"> Rajiv Gandhi</p>
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

                if (ans.equals("a")) {
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
