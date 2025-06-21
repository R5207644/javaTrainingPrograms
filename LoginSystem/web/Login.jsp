<%-- 
    Document   : Login
    Created on : 10 Mar 2025, 5:18:24 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <%
            String email, pass;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                email = request.getParameter("email");
                pass = request.getParameter("pass");
                if (email == null || pass == null) {
                    response.sendRedirect("index.html");
                }
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsystem", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE email='" + email + "'");
                    while (rs.next()) {
                        if (pass.equals(rs.getString(2))) {
                            response.sendRedirect("Home.jsp?email='" + email + "'");
                        } else {
                            out.print("<h1 class='text-danger'>Wrong password or user</h1>");
                            out.print("<a href='index.html'>Login</a>");
                        }
                    }
                    con.close();
                } catch (Exception ex) {
                    out.print(ex);
                }
            } else {
                response.sendRedirect("index.html");
            }
        %>

    </body>
</html>
