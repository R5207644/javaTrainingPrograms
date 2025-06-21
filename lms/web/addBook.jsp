<%-- 
    Document   : addBook
    Created on : 18 Mar 2025, 6:04:18 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Book</title>
        <style>
            .box{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                background-color: whitesmoke;
            }
            .main {
                width: 400px;
                margin: 30px 0;
                padding: 25px;
                box-shadow: 1px 1px 5px 5px #111;
                background-color: white;
            }
            .main input[type="text"] {
                background-color: #111;
                color: white;
            }
        </style>
    </head>
    <body>
        <%
            String bookId, bookName, authorsName, edition, status, department;
            int quantity;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                bookId = request.getParameter("bookId");
                bookName = request.getParameter("bookName");
                authorsName = request.getParameter("authorsName");
                edition = request.getParameter("edition");
                status = request.getParameter("status");
                department = request.getParameter("department");
                quantity = Integer.parseInt(request.getParameter("quantity"));

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, bookId);
                    stmt.setString(2, bookName);
                    stmt.setString(3, authorsName);
                    stmt.setString(4, edition);
                    stmt.setString(5, status);
                    stmt.setInt(6, quantity);
                    stmt.setString(7, department);

                    int i = stmt.executeUpdate();
                    if (i > 0) {
                        out.print("<script>alert('Record Inserted');</script>");
                    } else {
                        out.print("<script>alert('Record Not Inserted');</script>");
                    }
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
        <%@include file="nav.html" %>
        <div class="box">
            <form class="main" method="POST">
                <h2 class="text-center">Add New Books</h2>
                <p class="text-center"><input type="text" class="form-control" placeholder="Book Id" name="bookId" required></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Book name" name="bookName" required></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Authors Name" name="authorsName"></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Edition" name="edition" required></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Status" name="status" required></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Quantity" name="quantity" required></p>
                <p class="text-center"><input type="text" class="form-control" placeholder="Department" name="department" required></p>
                <p class="text-center"><input type="submit" value="submit" class="btn btn-primary"></p>
            </form>
        </div>
    </body>
</html>
