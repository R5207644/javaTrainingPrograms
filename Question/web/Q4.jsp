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
                        <h1 class="form-control btn-lg btn-warning">Which of the following is true about java's <b>try-catch-finally</b> block?</h1>
                        <p class="form-control"><input type="radio" name="Q4" value="a" required="true"> The finally block is always executed, regardless of wheater an eception thrown.</p>
                        <p class="form-control"><input type="radio" name="Q4" value="b"> the <em>catch</em> block is optional.</p>
                        <p class="form-control"><input type="radio" name="Q4" value="c"> The try blovk can exist without a <em>catch</em> or finally block.</p>
                        <p class="form-control"><input type="radio" name="Q4" value="d"> The finally block is executed only if an exeption thrown.</p>
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

                ans = request.getParameter("Q4");

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
                response.sendRedirect("Q5.jsp");
            }
        %>
    </body>
</html>
