<%-- 
    Document   : connection
    Created on : 5 Mar 2025, 5:03:21 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connection example</title>
       
    </head>
    <body>
      
        <%
            String name, gender, course, uname, passwd;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                name = request.getParameter("name");
                gender = request.getParameter("gender");
                course = request.getParameter("course");
                uname = request.getParameter("uname");
                passwd = request.getParameter("passwd");

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO students (name, gender, course, uname, passwd) VALUES (?, ?, ?, ?, ?)");
                    stmt.setString(1, name);
                    stmt.setString(2, gender);
                    stmt.setString(3, course);
                    stmt.setString(4, uname);
                    stmt.setString(5, passwd);

                    int i = stmt.executeUpdate();
                    if (i > 0) {
                        out.print(i + " record inserted successfully");
                        response.sendRedirect("Read.jsp");
                    } else {
                        out.print("Failed to insert record");
                    }

                    stmt.close();
                    con.close();
                } catch (Exception ex) {
                    out.print("An error occurred: " + ex.getMessage());
                }
            }
        %>
    </body>
</html>
