<%-- 
    Document   : Read
    Created on : 6 Mar 2025, 4:52:00 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read From</title>
        <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                out.print("<center><h1>Students Record Table</h1>");
                out.print("<table border='1' width='600' class='table table-hover'>");
                out.print("<tr>");
                out.print("<th>Name</th>");
                out.print("<th>Gender</th>");
                out.print("<th>Course</th>");
                out.print("<th>Username</th>");
                out.print("<th>Password</th>");
                out.print("<th>Update</th>");
                out.print("<th>Delete</th>");
                out.print("</tr>");
                while (rs.next()) {
                    out.print("<tr>");
                    out.print("<td>" + rs.getString(1) + "</td>");
                    out.print("<td>" + rs.getString(2) + "</td>");
                    out.print("<td>" + rs.getString(3) + "</td>");
                    String uname = rs.getString(4);
                    out.print("<td>" + uname + "</td>");
                    out.print("<td>" + rs.getString(5) + "</td>");
                    out.print("<td><a href='Update.jsp?uname=" + uname + "'>UPDATE</a></td>");
                    out.print("<td><a href='DeletePage.jsp?uname=" + uname + "'>DELETE</a></td>");
                    out.print("</tr>");
                }
                out.print("</table>");
                out.print("<a href='index.html'>Back</a>");
                out.print("</center>");

            } catch (Exception ex) {
                out.print(ex);
            }

        %>
    </body>
</html>
