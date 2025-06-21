<%-- 
    Document   : NewUser
    Created on : 10 Mar 2025, 5:18:37 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
       
    </head>
    <body>
        <%@include file="nav.html" %>
            
                <table class="container" width="400">
                    <form method="POST">
                    <%
                        String text = request.getParameter("msg");
                        if (text == null) {
                            out.print("<h1 class='text-center text-info'>Register</h1>");
                        } else {
                            out.print("<h1 class='text-center text-success'>" + text + "</h1>");
                        }
                    %>
                    <tr class="form-group">
                        <td>Email</td>
                        <td><input type="text" name="email" class="form-control" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Password</td>
                        <td><input type="text" name="pass" class="form-control" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Confirm Password</td>
                        <td><input type="text" name="confirmPass" class="form-control" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Mobile</td>
                        <td><input type="text" name="number" max="9999999999" min="6666666666" class="form-control" required></td>
                    </tr>
                    <tr class="text-center">
                        <td colspan="2"><input type="submit" value="Register" class="btn btn-primary"></td>
                    </tr>
                    <tr class="text-center">
                        <td colspan="2">
                            <a href="index.html">Already Registered</a>
                        </td>
                    </tr>
                      </form>
                </table>

          
      
        <%
            String email, pass, confirmPass, mobile, msg;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                email = request.getParameter("email");
                pass = request.getParameter("pass");
                confirmPass = request.getParameter("confirmPass");
                mobile = request.getParameter("mobile");
                if (!pass.equals(confirmPass)) {
                    msg = "Password not Match with Confirm Pass";
                    response.sendRedirect("NewUser.jsp?msg='" + msg + "'");
                }
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsystem", "root", "");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO users VALUES (?, ?, ?)");
                    stmt.setString(1, email);
                    stmt.setString(2, pass);
                    stmt.setString(3, mobile);
                    int i = stmt.executeUpdate();
                    if (i > 0) {
                        msg = "SuccessFully Registered!! Continue to <a href='index.html'>login</a> page";
                    } else {
                        msg = "Not Registered, some error have occured!";
                    }
                    con.close();
                    response.sendRedirect("NewUser.jsp?msg='" + msg + "'");
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
    </body>
</html>
