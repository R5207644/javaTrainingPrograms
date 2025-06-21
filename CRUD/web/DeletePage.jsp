<%-- 
    Document   : DeletePage
    Created on : 8 Mar 2025, 4:54:51 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
        <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="header.html" %>
        <%
            try {
                String uname = request.getParameter("uname");
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE uname='" + uname + "'");
                int i = stmt.executeUpdate();
                if (i > 0) {
                    response.sendRedirect("Read.jsp");
                } else {
                    out.print("<p>some error occured!!</p>");
                    out.print("<a href='Read.jsp'>Back</a>");
                }
            } catch(Exception ex){
                out.print(ex);
            }

        %>
    </body>
</html>
