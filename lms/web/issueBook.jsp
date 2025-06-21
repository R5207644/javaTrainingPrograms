<%-- 
    Document   : newStudent
    Created on : 19 Mar 2025, 5:03:09 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>issue Book</title>
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
            String stId, bookId, issueDate, dueDate;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                stId = request.getParameter("stId");
                bookId = request.getParameter("bookId");
                issueDate = request.getParameter("issueDate");
                dueDate = request.getParameter("dueDate");
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
                    Statement stmt2 = con.createStatement();
                    ResultSet rs = stmt2.executeQuery("SELECT quantity FROM book WHERE bookId='" + bookId + "'");
                    while (rs.next()) {
                        String quantity = rs.getString(1);
                        if (Integer.parseInt(quantity) > 0) {
                            PreparedStatement stmt = con.prepareStatement("INSERT INTO issueBook VALUES(?, ?, ?, ?)");
                            stmt.setString(1, stId);
                            stmt.setString(2, bookId);
                            stmt.setString(3, issueDate);
                            stmt.setString(4, dueDate);
                            
                            int i = stmt.executeUpdate();
                            if (i > 0) {
                                PreparedStatement stmt3 = con.prepareStatement("UPDATE book SET quantity='" + (Integer.parseInt(quantity) - 1) + "' WHERE bookId='" + bookId + "'");
                                int j = stmt3.executeUpdate();
                                if ((j > 0)) {
                                    out.print("<script>alert('book issued')</script>");
                                } else {
                                    out.print("<script>alert('error in decreasing quantity');</script>");
                                }
                            } else {
                                out.print("<script>alert('Record Not Inserted');</script>");
                            }
                        } else {
                            out.print("<script>alert('book not available');</script>");
                        }
                    }
                    con.close();
                    
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
        <div class="main-box">
            <div class="main">
                <h1>Book Issue Form</h1>
                <form method="POST">
                    <table>
                        <tr>
                            <td>Book Id</td>
                            <td><input type="text" name="bookId" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Student Id</td>
                            <td><input type="text" name="stId" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Issue Date</td>
                            <td><input type="date" name="issueDate" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Due Date</td>
                            <td><input type="date" name="dueDate" class="form-control"></td>
                        </tr>
                        <tr class="text-center">
                            <td ><input type="submit" value="Issue" class="btn btn-primary"></td>
                            <td><input type="button" value="x Close" class="btn btn-danger"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

        <div class="container">
            <h1 class="text-center">Available Books in Library</h1>
            <%        
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM issueBook");
                    
                    out.print("<table class='table table-hover'>");
                    out.print("<tr> <th>Book Id</th>");
                    out.print("<th>Student Id</th>");
                    out.print("<th>Issue Date</th>");
                    out.print("<th>Due date</th>");
                    out.print("<th>Action</h1></tr>");
                    while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rs.getString(1) + "</td>");
                        out.print("<td>" + rs.getString(2) + "</td>");
                        out.print("<td>" + rs.getString(3) + "</td>");
                        out.print("<td>" + rs.getString(4) + "</td>");
                        out.print("<td><a href='returnBook.jsp?bId="+rs.getString(2)+"&sId=" + rs.getString(1) + "&dDate=" + rs.getString(4) + "'>Return</a></td>");
                        out.print("</tr>");
                        
                    }
                    out.print("</table>");
                    con.close();
                } catch (Exception ex) {
                    out.print(ex);
                }
            %>
        </div>

    </body>
</html>
