<%-- 
    Document   : ChangePassword
    Created on : 10 Mar 2025, 5:19:13 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <%@include file="nav.html"%>
        <form method="POST">
            <table class="container">
                <tr>
                    <td>Old Password</td>
                    <td><input type="text" name="oldPass" class="form-control"></td>
                </tr>
                <tr>
                    <td>New Password</td>
                    <td><input type="text" name="newPass" class="form-control"></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="text" name="confirmPass" class="form-control"></td>
                </tr>
                <tr class="text-center">
                    <td colspan="2"><input type="submit" value="Change" class="btn btn-primary"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
