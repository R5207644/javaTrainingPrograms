<%-- 
    Document   : Dashboard
    Created on : 18 Apr 2025, 6:08:08 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <style>
            .Dashboard-left a {
                margin-top: 15px;
            }
            
        </style>
    </head>
    <body>
        <%
            if ((String) session.getAttribute("uname") == null) {
                response.sendRedirect("Admin.jsp");
            }
        %>
        <jsp:include page="Navbar.jsp"/>
        <section>
            <div class="row">
                <div class="col-8 px-5 py-5 Dashboard-left">
                    <h4 class="text-danger">Welcome to Book Shop Management System</h4>
                    <hr>
                    <a href="ProductEntry.jsp" class="btn btn-danger form-control">Add Books</a>
                    <a href="StartSales.jsp" class="btn btn-danger form-control">Add Sells</a>
                    <a href="#" class="btn btn-danger form-control">All Book Report</a>
                    <a href="#" class="btn btn-danger form-control">Sell Report</a>
                    <a href="#" class="btn btn-danger form-control">Logout</a>
                </div>

                <div class="col-4">
                        <img src="static/img/laptop-image.png" class="card-img-top" alt=""/>
                </div>

            </div>
        </section>
    </body>
</html>
