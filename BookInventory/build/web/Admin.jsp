<%-- 
    Document   : Admin
    Created on : 18 Apr 2025, 5:25:04 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin </title>
    </head>
    <body>
        <jsp:include page="Navbar.jsp"/>
        <div class="card admin-form">
            <div class="card-header">
                <h4 class="text-danger">Administrator Login Form</h4>
            </div>
            <div class="card-body">
                <form method="post">
                    <p class="form-group">
                        <label for="uname">Username</label>
                        <input type="text" name="uname" class="form-control" required>
                    </p>

                    <p class="form-group">
                        <label for="passwd">Password</label>
                        <input type="password" name="passwd" class="form-control" required>
                    </p>
                    <p class="form-group">
                        <input type="submit" value="Login" class="btn btn-danger">
                        <input type="reset" value="Cancel" class="btn btn-danger">
                    </p>
                </form>
            </div>
        </div>

        <%
            String uname, passwd;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                uname = request.getParameter("uname");
                passwd = request.getParameter("passwd");

                if (uname.equals("admin") && passwd.equals("admin123")) {
                    session.setAttribute("uname", uname);
                    response.sendRedirect("Dashboard.jsp");
                } else {
                    out.print("<h1 class='text-danger'>Wrong Username or Password</h1>");
                }
            }
        %>
    </body>
</html>
