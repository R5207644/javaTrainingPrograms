<%-- 
    Document   : AddUser
    Created on : 1 May 2025, 11:44:37 am
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="UserDao.UserDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
        <jsp:useBean id="u" class="UserData.User"/>
        <jsp:setProperty property="*" name="u"/>
        
        <%
            int i = UserDao.save(u);
            if(i > 0) {
                response.sendRedirect("AddUserSuccess.jsp");
            } else {
                response.sendRedirect("AddUserError.jsp");
            }
        %>
    </body>
</html>
