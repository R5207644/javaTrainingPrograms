<%-- 
    Document   : Second
    Created on : 19 Feb 2025, 4:28:59 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <style>
            .box {
                margin-top: 90px;
                background-color: skyblue;
                width: 600px;
                height: 400px;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                box-shadow: 5px 5px 5px #111, inset 5px 5px 5px #111;
                border: 10px inset white;
            }
            .box h1{
                font-size: 3cm;
            }
            
        </style>
    </head>
    <body>
    <center>
        <div class="box">
            <h1>Oops!</h1>
            <h3><%= exception %></h3>
        </div>
        
    </center>
    </body>
</html>
