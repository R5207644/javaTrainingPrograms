<%-- 
    Document   : Home
    Created on : 11 Feb 2025, 4:23:23 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <p>Email</p>
                <p><input type="text" name="email"></p>
                <p>Password</p>
                <p><input type="text" name="pass"></p>
                <p><input type="submit" value="Login"></p>
            </div>
        </form>
        
        <%
            String email, pass;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                email = request.getParameter("email");
                pass = request.getParameter("pass");
                
                if (email.equals("test@test.com") &&  pass.equals("test")) {
                    response.sendRedirect("Welcome.jsp");
                } else {
                    out.print("<script>alert('Invalid credentials!!')</script>");
                }
            }
        %>
    </body>
</html>
