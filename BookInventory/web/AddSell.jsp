<%-- 
    Document   : AddSell
    Created on : 28 Apr 2025, 5:52:37 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Sells</title>
    </head>
    <body>
        <jsp:include page="Navbar.jsp"/>
        <div>
            <h2>Order And Customer Details</h2>
            <table border="2" class="table table-bordered">
                <tr>
                    <th>Order ID</th>
                    <td>1</td>
                    <th>Order Date</th>
                    <td><%=new Date()%></td>
                </tr>
                <tr>
                    <th>Customer Name</th>
                    <td><%=request.getParameter("name")%></td>
                    <th>Customer Mobile</th>
                    <td><%=request.getParameter("mobile")%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
