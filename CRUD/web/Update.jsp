<%-- 
    Document   : Update
    Created on : 8 Mar 2025, 5:33:56 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String name, gender, course, uname, passwd, temp;
                name = request.getParameter("name");
                gender = request.getParameter("gender");
                course = request.getParameter("course");
                uname = request.getParameter("uname");
                passwd = request.getParameter("passwd");
                temp = request.getParameter("temp");

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                PreparedStatement stmt = con.prepareStatement("UPDATE students SET name='" + name + "', gender='" + gender + "', course='" + course + "', uname='" + uname + "', passwd='" + passwd + "' WHERE uname='" + temp + "'");
                int i = stmt.executeUpdate();
                if (i > 0) {
                    out.print("<p>updated!</p>");
                } else {
                    out.print("<h1>Not updated</h1>");
                }
            } else {
                String temp = request.getParameter("uname"), name, gender, course, uname, passwd;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE uname='" + temp + "'");
                    while (rs.next()) {
                        name = rs.getString(1);
                        gender = rs.getString(2);
                        course = rs.getString(3);
                        uname = rs.getString(4);
                        passwd = rs.getString(5);
                        out.print("<form action='Update.jsp' method='POST' class='container'>");
                        out.print("<table width='800' class='table'>");
                        out.print("<tr>");
                        out.print("<td>Name: </td>");
                        out.print("<td><input type='text' name='name' class='form-control' value='" + name + "'></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Gender</td>");
                        out.print("<td><input type='text' name='gender' class='form-control' value='" + gender + "'></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Course</td>");
                        out.print("<td><input type='text' name='course' class='form-control' value='" + course + "'></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Username</td>");
                        out.print("<input type='text' value='" + uname + "' hidden name='temp'>");
                        out.print("<td><input type='text' name='uname' class='form-control' value='" + uname + "'></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Password</td>");
                        out.print("<td><input type='text' name='passwd' class='form-control' value='" + passwd + "'></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td colspan='2'><input type='submit' value='update' class='btn-primary'></td>");
                        out.print("</tr>");
                        out.print("</table>");
                        out.print("</form>");
                    }
                    con.close();
                } catch (Exception ex) {
                    out.print(ex);
                }
            }

        %>
        <a href='Read.jsp'>back to read page</a>

    </body>
</html>
