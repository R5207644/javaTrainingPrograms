<%-- 
    Document   : dashboard
    Created on : 18 Mar 2025, 4:26:56 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <link href="static/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: whitesmoke;
            }
            .main{
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 500px;
                height: 500px;
                margin-top: 20px;
                box-shadow: 2px 2px 5px 5px #111;
                background-color: #fff;
                border-radius: 20px;
            }
            .top, .middle, .bottom {
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .top {
                color: red;
            }
            .icon-box {
                width: 120px;
                height: 120px;
                margin: 20px;
                background-size: cover;
            }
            .card-box a{
                margin-left: 25%;
            }
            .img {
                max-width: 100%;
                max-height: 100%;
            }
            .line{
                height: 3px;
                background-color: red;
                width: 80%;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="main container">

            <div class="top">
                <h1>Library Management</h1>
            </div>

            <div class="line"></div>

            <div class="middle">

                <div class="card-box">
                    <div class="icon-box" style="background-image: url('static/img/search.png');"></div>
                    <a href="#">Book Search</a>
                </div>
                <div class="card-box">
                    <div class="icon-box" style="background-image: url('static/img/team.png');"></div>
                    <a href="#">Members</a>
                </div>
            </div>

            <div class="bottom">
                <div class="card-box">
                    <div class="icon-box" style="background-image: url('static/img/book-stack.png');"></div>
                    <a href="#">Books</a>
                </div>
                <div class="card-box">
                    <div class="icon-box" style="background-image: url('static/img/work-plan.png');"></div>
                    <a href="#">Book Issue</a>
                </div>
                <div class="card-box">
                    <div class="icon-box" style="background-image: url('static/img/return.png');"></div>
                    <a href="#">Book returns</a>
                </div>
            </div>
        </div>
    </body>
</html>
