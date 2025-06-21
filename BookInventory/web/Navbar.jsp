<%-- 
    Document   : Navbar
    Created on : 15 Apr 2025, 5:59:27 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="static/css/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-danger">
            <ul class="nav navbar-nav navbar-center">
                <li>
                    <a href="home.jsp" class="nav-link active">HOME</a>
                </li>
                <li>
                    <a href="about.jsp" class="nav-link">ABOUT US</a>
                </li>

                <%
                    String uname = (String) session.getAttribute("uname");
                %>
                <c:set var="id" value="<%=uname%>"/>
                <c:if test="${id != null}">
                    <li>
                        <a href="Dashboard.jsp" class="nav-link">Dashboard</a>
                    </li>
                    <li>
                        <a href="#" class="nav-link">ADD NEW</a>
                    </li>
                    <li>
                        <a href="#" class="nav-link">REPORTS</a>
                    </li>
                    <li>
                        <a href="Logout.jsp" class="nav-link">LOGOUT</a>
                    </li>
                </c:if>
                <c:if test="${id == null}">
                    <li>
                        <a href="Admin.jsp" class="nav-link">ADMINISTRATOR LOGIN</a>
                    </li>
                    <li>
                        <a href="Contact.jsp" class="nav-link">CONTACT US</a>
                    </li>
                </c:if>


            </ul>
        </nav>
    </body>
    <script src="static/jquery-3.7.1.js" type="text/javascript"></script>
    <script src="static/css/Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</html>
