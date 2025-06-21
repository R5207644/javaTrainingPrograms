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
        <title>Q3</title>
        <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form action="Q3.jsp" method="POST">
            <h1 class="form-control btn-lg btn-info">Most Famous Play in the world</h1>
            <p class="form-control"><input type="radio" name="Q3" value="a"> Cricket</p>
            <p class="form-control"><input type="radio" name="Q3" value="b"> Football</p>
            <p class="form-control"><input type="radio" name="Q3" value="c"> Chess</p>
            <p class="form-control"><input type="radio" name="Q3" value="d"> Boxing</p>
            <p><input type="submit" value="Next" class="btn btn-primary"></p>
        </form>
        </div>
        
        <%
            int right, wrong, marks;
            String ans = "";
            right = (Integer) session.getAttribute("right");
            wrong = (Integer) session.getAttribute("wrong");
            marks = (Integer) session.getAttribute("marks");
            if ("POST".equalsIgnoreCase(request.getMethod())) {

                ans = request.getParameter("Q3");

                if (ans.equals("b")) {
                    right++;
                    marks = marks + 5;
                } else {
                    wrong++;
                    marks = marks - 1;
                }

                session.setAttribute("right", right);
                session.setAttribute("wrong", wrong);
                session.setAttribute("marks", marks);
                response.sendRedirect("Result2.jsp");
            }
        %>

    </body>
</html>
