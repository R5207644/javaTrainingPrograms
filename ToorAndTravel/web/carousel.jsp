<%-- 
    Document   : carousel
    Created on : 6 Jun 2025, 5:51:06 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .carousel-inner {
                margin: auto;
                max-height: 90vw;
                padding: 10px;
            }
            .carousel-item img {
                height: 400px;
                width: 100%;
                border-radius: 25px;
                object-fit: cover;
                box-shadow: 2px 2px 2px #fefefe;
            }
        </style>
    </head>
    <body>
        <div class="carousel slide" id="home-carousel" data-ride="carousel">

            <ol class="carousel-indicators">
                <li data-target="#home-carousel" data-slide-to="0" class="active">first</li>
                <li data-target="#home-carousel" data-slide-to="1">second</li>
                <li data-target="#home-carousel" data-slide-to="2">third</li>
            </ol>


            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Static/img/1.jpg" alt="Slide 1"/>
                </div>
                <div class="carousel-item">
                    <img src="Static/img/2.jpg" alt="Slide 2"/>
                </div>
                <div class="carousel-item">
                    <img src="Static/img/3.jpg" alt="Slide 3"/>
                </div>
            </div>

            <a href="#home-carousel" class="carousel-control-prev" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a href="#home-carousel" class="carousel-control-next" role="button" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
    </body>
</html>
