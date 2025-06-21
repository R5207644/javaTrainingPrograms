<%-- 
    Document   : Result
    Created on : 11 Feb 2025, 5:37:06 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marks</title>
    </head>
    <body>
        <form action="Result.jsp" method="POST">
            <table>
                <tr>
                    <td>Student Roll no.</td>
                    <td><input type="text" name="rollNo"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Sub1</td>
                    <td><input type="text" name="sub1"></td>
                </tr>
                <tr>
                    <td>Sub2</td>
                    <td><input type="text" name="sub2"></td>
                </tr>
                <tr>
                    <td>Sub3</td>
                    <td><input type="text" name="sub3"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
        <%
            String name, rollNo;
            int sub1, sub2, sub3, total = 0, per;
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                sub1 = Integer.parseInt(request.getParameter("sub1"));
                sub2 = Integer.parseInt(request.getParameter("sub2"));
                sub3 = Integer.parseInt(request.getParameter("sub3"));
                rollNo = request.getParameter("rollNo");
                name = request.getParameter("name");
                total = (sub1 + sub2 + sub3);
                per = total / 3;
                session.setAttribute("sub1", sub1);
                session.setAttribute("sub2", sub2);
                session.setAttribute("sub3", sub3);
                session.setAttribute("rollNo", rollNo);
                session.setAttribute("name", name);
                session.setAttribute("total", total);
                session.setAttribute("per", per);
                response.sendRedirect("MyResult.jsp");
            }
        %>
    </body>
</html>
