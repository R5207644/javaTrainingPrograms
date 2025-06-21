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
        <title>New Student</title>
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            * {
                margin: 0;
                padding: 0;
            }
            body {
                background-image: url("static/img/lib-background.jpg");
                background-size: cover;
            }
            .main-box {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                min-height: 100vh;
                
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
            String stId, stName, fathersName, course, branch;
            int quantity;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                stId = request.getParameter("stId");
                stName = request.getParameter("stName");
                fathersName = request.getParameter("fathersName");
                course = request.getParameter("course");
                branch = request.getParameter("branch");

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO students VALUES(?, ?, ?, ?, ?)");
                    stmt.setString(1, stId);
                    stmt.setString(2, stName);
                    stmt.setString(3, fathersName);
                    stmt.setString(4, course);
                    stmt.setString(5, branch);

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
        <div class="main-box">
            <div class="main">
                <h1>Student Registration Form</h1>
                <form method="post">
                    <table>
                        <tr>
                            <td>Student Id</td>
                            <td><input type="text" name="stId" class="form-control" required></td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="stName" class="form-control" required></td>
                        </tr>
                        <tr>
                            <td>Fathers Name</td>
                            <td><input type="text" name="fathersName" class="form-control" required></td>
                        </tr>
                        <tr>
                            <td>Course Name</td>
                            <td>
                                <select name="course" class="form-control" required>
                                    <option value="BCA">B.C.A</option>
                                    <option value="BA">BA</option>
                                    <option value="BSc">B.Sc</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Branch Name</td>
                            <td>
                                <select name="branch" class="form-control" required>
                                    <option value="CSE">CSE</option>
                                    <option value="Arts">Arts</option>
                                    <option value="Management">Management</option>
                                </select>
                            </td>
                        </tr>
                        <tr class="text-center">
                            <td ><input type="submit" value="save" class="btn btn-primary"></td>
                            <td><input type="button" value="x Close" class="btn btn-danger"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
