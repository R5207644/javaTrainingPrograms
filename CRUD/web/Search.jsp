<%-- 
    Document   : Search
    Created on : 7 Mar 2025, 4:31:39 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.html" %>
        <form action="Search.jsp" method="POST">
            <table width="600" class="table">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="uname" class="form-control"></td>
                    <td><input type="submit" value="Search" class="btn"></td>
                </tr>
            </table>
        </form>
        <%
            String uname;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                uname = request.getParameter("uname");
               
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE uname='" + uname + "'");
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
                        String temp = rs.getString(4);
                        out.print("<td>" + temp + "</td>");
                        out.print("<td>" + rs.getString(5) + "</td>");
                        out.print("<td><a href='Update.jsp?uname="+temp+"'>UPDATE</a></td>");
                        out.print("<td><a href='DeletePage.jsp?uname="+temp+"'>DELETE</a></td>");
                        out.print("</tr>");
                    }

                    out.print("</table>");
                    out.print("<a href='index.html'>Back</a>");
                    out.print("</center>");

                } catch (Exception ex) {
                    out.print(ex);
                }

            }
        %>
        <a href='index.html' class="btn btn-primary">Back</a>
    </body>
</html>
