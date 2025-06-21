<%-- 
    Document   : bookDetails
    Created on : 21 Mar 2025, 5:14:37 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Books</title>
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background-image: url("static/img/lib-background.jpg");
                background-size: cover;
            }
            .container {
                margin-top: 25px;
                min-height: 90vh;
                box-shadow: 1px 1px 5px 5px #fff;
                background-color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="container">
        <h1 class="text-center">Available Books in Library</h1>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                
                out.print("<table class='table table-hover'>");
                out.print("<tr> <th>Book Id</th>");
                out.print("<th>Book Name</th>");
                out.print("<th>Author name</th>");
                out.print("<th>Edition</th>");
                out.print("<th>Status</th>");
                out.print("<th>Quantity</th>");
                out.print("<th>Department</th></tr>");
                while (rs.next()) {
                    out.print("<tr>");
                    out.print("<td>" + rs.getString(1) + "</td>");
                    out.print("<td>" + rs.getString(2) + "</td>");
                    out.print("<td>" + rs.getString(3) + "</td>");
                    out.print("<td>" + rs.getString(4) + "</td>");
                    out.print("<td>" + rs.getString(5) + "</td>");
                    out.print("<td>" + rs.getString(6) + "</td>");
                    out.print("<td>" + rs.getString(7) + "</td>");
                    out.print("</tr>");

                }
                out.print("</table>");
            } catch (Exception ex) {
                out.print(ex);
            }
        %>
        </div>
    </body>
</html>
