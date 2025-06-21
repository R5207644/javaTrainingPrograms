<%-- 
    Document   : MyResult
    Created on : 11 Feb 2025, 5:37:20 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Result</title>
    </head>
    <body>
        <table>
                <tr>
                    <td>Student Roll no.</td>
                    <td><%out.print(session.getAttribute("rollNo"));%></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%out.print(session.getAttribute("name"));%></td>
                </tr>
                <tr>
                    <td>Sub1</td>
                    <td><%out.print(session.getAttribute("sub1"));%></td>
                </tr>
                <tr>
                    <td>Sub2</td>
                    <td><%out.print(session.getAttribute("sub2"));%></td>
                </tr>
                <tr>
                    <td>Sub3</td>
                    <td><%out.print(session.getAttribute("sub3"));%></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><%out.print(session.getAttribute("total"));%></td>
                </tr>
                <tr>
                    <td>Per</td>
                    <td><%out.print(session.getAttribute("per"));%></td>
                </tr>
                <tr>
                    <td><input type="button" value="Print" onclick="print()"></td>
                </tr>
            </table>
    </body>
</html>
