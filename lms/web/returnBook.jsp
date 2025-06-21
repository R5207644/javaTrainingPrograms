<%-- 
    Document   : newStudent
    Created on : 19 Mar 2025, 5:03:09 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Book</title>
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            * {
                margin: 0;
                padding: 0;
            }
            .main-box {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                min-height: 100vh;
                background-image: url("static/img/lib-background.jpg");
            }
            .main {
                width: 700px;
                min-height: 70vh;
                box-shadow: 1px 1px 5px 5px #111;
                margin-top: 25px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                background-color: gray;
                color: #fff;
            }
            form {
                margin-top: 10px;
                width: 80%;
            }
            table {
                width: 90%;
                font-size: 1.2rem;
                font-weight: bold;
            }
            input[type='button'] {
                margin: 20px;
            }
            input[type="text"] {
                background-color: black;
                color: #fff;
            }
        </style>
    </head>
    <body>
        <%
            String bookId, stId, returnDate, dueDate, fFine;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                bookId = request.getParameter("bookId");
                stId = request.getParameter("stId");
                dueDate = request.getParameter("dueDate");
                returnDate = request.getParameter("currentDate");
                fFine = request.getParameter("fine");
                out.print(dueDate + returnDate);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");

                    PreparedStatement stmt = con.prepareStatement("INSERT INTO returnBook VALUES(?, ?, ?, ?, ?)");
                    stmt.setString(1, bookId);
                    stmt.setString(2, stId);
                    stmt.setString(3, dueDate);
                    stmt.setString(4, returnDate);
                    stmt.setString(5, fFine);

                    int i = stmt.executeUpdate();
                    if (i > 0) {
                        PreparedStatement stmt2 = con.prepareStatement("DELETE  FROM issuebook WHERE bookId=" + bookId);
                        int j = stmt2.executeUpdate();
                        if (j > 0) {
                            out.print("<script>alert('book returned');</script>");
                            response.sendRedirect("issueBook.jsp");
                        }
                    } else {
                        out.print("<script>alert('error ocured');</script>");
                    }
                    con.close();
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
        <%
            String bId = request.getParameter("bId");
            String sId = request.getParameter("sId");
            String dDate = request.getParameter("dDate");
            int fine = 100;
        %>
        <div class="main-box">
            <div class="main">
                <h1>Book Return Entry</h1>
                <form method="POST">
                    <table>
                        <tr>
                            <td>Book Id</td>
                            <td><input type="text" name="bookId" class="form-control" value="<%out.print(bId);%>"></td>
                        </tr>
                        <tr>
                            <td>Student Id</td>
                            <td><input type="text" name="stId" class="form-control" value="<%out.print(sId);%>"></td>
                        </tr>
                        <tr>
                            <td>Return Date</td>
                            <td><input type="date" name="dueDate" class="form-control" value="<%out.print(dDate);%>"></td>
                        </tr>
                        <tr>
                            <td>Current Date</td>
                            <td><input type="text" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" class="form-control" name="currentDate"></td>
                        </tr>
                        <tr>
                            <td>Fine</td>
                            <td><input type="text" value="<%out.print(fine);%>" class="form-control" name="fine"></td>
                        </tr>
                        <tr class="text-center">
                            <td ><input type="submit" value="Return" class="btn btn-primary"></td>
                            <td><input type="button" value="x Close" class="btn btn-danger"></td>
                        </tr>

                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
