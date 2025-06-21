<%-- 
    Document   : marksheet
    Created on : 10 Feb 2025, 5:11:27 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marksheet</title>
        <style>
            table {
                width: 80%;
            }
        </style>
    </head>
    <body>
        <form action="marksheet.jsp" method="POST">
            <table>
                <tr>
                    <td>Operating System</td>
                    <td><input type="number" name="os"></td>
                </tr>

                <tr>
                    <td>Networking</td>
                    <td><input type="number" name="networking"></td>
                </tr>

                <tr>
                    <td>Java</td>
                    <td><input type="number" name="java"></td>
                </tr>

                <tr>
                    <td>SPM</td>
                    <td><input type="number" name="spm"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Calculate"></td>
                </tr>

                <%
                    int total = 0, per = 0, os, networking, java, spm;
                    String grade = "";
                    if ("POST".equalsIgnoreCase(request.getMethod())) {
                        os = Integer.parseInt(request.getParameter("os"));
                        networking = Integer.parseInt(request.getParameter("networking"));
                        java = Integer.parseInt(request.getParameter("java"));
                        spm = Integer.parseInt(request.getParameter("spm"));

                        total = os + networking + java + spm;
                        per = (total / 4);

                        if (per > 80) {
                            grade = "A";
                        } else if (per > 70) {
                            grade = "B";
                        } else if (per > 40) {
                            grade = "C";
                        } else {
                            grade = "failed";
                        }
                    }
                %>

                <tr>
                    <td>Total</td>
                    <td><input type="text" value="<%out.print(total);%> / 400"></td>
                </tr>

                <tr>
                    <td>Per</td>
                    <td><input type="number" value="<% out.print(per); %>"></td>
                </tr>

                <tr>
                    <td>Grade</td>
                    <td><input type="text" value="<%out.print(grade);%>"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
