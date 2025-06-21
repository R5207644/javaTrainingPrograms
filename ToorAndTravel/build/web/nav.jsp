<%-- 
    Document   : nav
    Created on : 6 Jun 2025, 5:37:58 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="Static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="Static/js/jquery-3.7.1.min.js" type="text/javascript"></script>
        <script src="Static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            #logo {
                height: 80px;
                width: 80px;
            }

            .left-navbar, .top-navbar {
                display: flex;
                align-items: center;
                gap: 3rem;
            }
            .top-navbar {
                justify-content: space-between;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Enquiry.html"/>
        <div class="text-center bg-warning py-2">
            <b>Call us</b>
            <i class="fa-solid fa-phone"></i>
            <b>+91 8303959362</b>
        </div>
        <div class="top-navbar">
            <div class="left-navbar">
                <img src="Static/img/logo.png" id="logo" alt=""/>
                <div><i class="fa-solid fa-magnifying-glass"></i><input type="text"></div>
            </div>

            <div>
                <a href="#">Blog</a>
                <a href="#">About Us</a>
                <a href="#"><i class="fa-brands fa-instagram"></i></a>
                <a href="#"><i class="fa-brands fa-facebook"></i></a>
                <a href="#"><i class="fa-brands fa-pinterest"></i></a>
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#enquiryModal"><i class="fa-solid fa-phone"></i>Request a Callback</button>
            </div>
        </div>
    </body>
</html>
