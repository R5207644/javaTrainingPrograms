<%-- 
    Document   : ProductEntry
    Created on : 22 Apr 2025, 6:19:02 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Entry Form</title>
    </head>
    <body>
        <jsp:include page="Navbar.jsp"/>
        <%
            if (session.getAttribute("uname") == null) {
                response.sendRedirect("Dashboard.jsp");
            }
        %>
        <section>
            <div class="row">
                <div class="col-8 px-5 py-5">

                    <h4 class="text-danger">Product Entry Form</h4>
                    <hr>
                    <table class="table table-borderless">
                        <form method="post">
                            <tr>
                                <td class="form-group">
                                    <label for="type">Product Type*</label>
                                    <select name="type" class="form-control" required>
                                        <option value="Horror">Horror</option>
                                        <option value="Educational">Educational</option>
                                        <option value="Sci-Fi">Sci-Fi</option>
                                    </select>
                                </td>
                                <td class="form-group">
                                    <label for="com">Product Company*</label>
                                    <select name="com" class="form-control" required>
                                        <option value="Self Publish">Self Publish</option>
                                        <option value="Pratilipi">Pratilipi</option>
                                        <option value="Gajette">Gajette</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td class="form-group">
                                    <label for="name">Product name<span class="text-danger">*</span></label>
                                    <input type="text" name="name" class="form-control" required>
                                </td>
                                <td class="form-group">
                                    <label for="stock">Total Stock<span class="text-danger">*</span></label>
                                    <input class="form-control" name="stock" required type="number" min="1">
                                </td>
                            </tr>

                            <tr>
                                <td class="form-group">
                                    <label for="price">Product Price Per Unit<span class="text-danger">*</span></label>
                                    <input type="number" class="form-control" name="price">
                                </td>
                                <td class="form-group">
                                    <label for="description">Description<span class="text-danger">*</span></label>
                                    <textarea cols="10" rows="5" name="description" class="form-control" required></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Save Product" class="btn btn-danger">
                                    <input type="reset" value="Reset Form" class="btn btn-danger">
                                </td>
                            </tr>
                        </form>
                    </table>
                </div>

                <div class="col-4">
                    <img src="static/img/laptop-image.png" class="card-img-top" alt=""/>
                </div>

            </div>
        </section>
        <%
            String type, com, name, description;
            int stock, price;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                type = request.getParameter("type");
                com = request.getParameter("com");
                name = request.getParameter("name");
                stock = Integer.parseInt(request.getParameter("stock"));
                price = Integer.parseInt(request.getParameter("price"));
                description = request.getParameter("description");

                if (type == null || com == null || name == null || stock <= 0 || price <= 0 || description == null) {
                    out.print("<h1 class='text-danger'>All Fields Required!</h1>");
                    return;
                }

                try {
                    //Connection
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO BOOK(type, com, name, stock, price, description) VALUES(?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, type);
                    stmt.setString(2, com);
                    stmt.setString(3, name);
                    stmt.setInt(4, stock);
                    stmt.setInt(5, price);
                    stmt.setString(6, description);

                    int i = stmt.executeUpdate();

                    if (i > 0) {
                        out.print("<script>alert('Successful');</script>");
                        response.sendRedirect("ProductEntry.jsp");
                    } else {
                        out.print("<script>alert('Failed');</script>");
                    }
                } catch (Exception ex) {
                    out.print(ex);
                }
            }
        %>
    </body>
</html>
