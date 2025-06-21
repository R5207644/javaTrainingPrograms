<%-- 
    Document   : Dashboard
    Created on : 15 Feb 2025, 5:11:57 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Dashboard</title>
        <style>
            .top {
                background-image: url("static/img/car.jpg");
                width: 100%;
                height: 300px;
                background-color: gray;
                color: blueviolet;
            }
            .heading {
                display: flex;
                justify-content: space-evenly;
                background-color: gray;
                color: white;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");

            if (email == null || email.equals("")) {
                out.print("<script>alert('You Are Logged Out')</script>");
                response.sendRedirect("index.html");
            }
        %>
        <div class="heading">
            <h1>Welcome, <% out.print(email);%></h1>

            <form action="Logout.jsp" method="POST">
                <input type="submit" value="Logout" class="btn-danger">
            </form>
        </div>
            
            <div>
                <div class="top">
                    <h1>Finance your Next Car in Minutes</h1>
                    <p>We Sell Best Quality of Car</p>
                    <p>Please Purchase From us</p>
                    <p><input type="button" value="Buy Now" class="btn-primary"></p>
                </div>
                <div>
                    Its Easy as 1-2-3</div>
                <p>We provide you best emi plans!!</p>
            </div>
    </body>
</html>
