<%-- 
    Document   : admin
    Created on : 17 Mar 2025, 4:31:30 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin-panel</title>
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                background-image: url("static/img/lib-background.jpg");
                background-size: cover;
            }
            .main {
                width: 400px;
                height: 600px;
              
            }
            .admin-logo {
                width: 100%;
                height: 110px;
                display: flex;
                justify-content: center;
            }
            .admin-logo img{
                height: 100px;
                width: 120px;
                border-radius: 50%;
            }
            .heading{
                color: #fff;
            }
            .heading h1{
                text-shadow: 3px 3px #111;
            }
            .form-box {
                background-color: #fff;
            }
            form {
                padding: 10px;
            }
            
        </style>
    </head>
    <body>
        <div class="main">
            <!-- logo area-->
            <div class="admin-logo">
                <img src="static/img/admin-logo.jpg" alt="admin-logo"/>
            </div>

            <!--            heading area-->
            <div class="heading">
                <h1 class="text-center">Library Management System</h1>
            </div>

            <!--            form area-->
            <div class="form-box">
                <h3 class="card-header">Login</h3>
                <form action="action">
                    
                    <div class="form-group">
                        <label for="uname">Username</label>
                        <p><input type="text" name="uname" class="form-control"></p>
                    </div>
                    <div class="form-group">
                        <label for="pass">Password</label>
                        <p><input type="text" name="pass" class="form-control"></p>
                    </div>
                    <p class="text-center"><input type="submit" value="Login" class="btn btn-primary"></p>
                </form>
            </div>
        </div>
    </body>
</html>
