<%-- 
    Document   : ForgetPassword
    Created on : 10 Mar 2025, 5:18:52 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password</title>
    </head>
    <body>
        <%@include file="nav.html" %>
        <%
            String email, mobile, pass = null;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                email = request.getParameter("email");
                mobile = request.getParameter("mobile");
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsystem", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT pass FROM users WHERE email='" + email + "' and mobile='" + mobile + "'");
                    if (rs.next()) {
                        pass = rs.getString(1);
                    } else {
                        out.print("<p class='text-center text-danger'>Record Not matched</p>");
                    }
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
        <form method="POST" class="text-center">
                <table class="container">
                    <tr class="form-group">
                        <td>Email</td>
                        <td><input type="text" name="email" class="form-control"></td>
                    </tr>
                    <tr class="form-group">
                        <td>mobile</td>
                        <td><input type="text" name="mobile" class="form-control"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="getPassword" class="btn btn-primary"></td>
                    </tr>
                </table>
                <h1 class="text-success"><%
                if (pass == null) {

                } else {
                    out.print(pass);
                }
                %></h1>
            </form>
    </body>
</html>
