<%-- 
    Document   : Contact
    Created on : 18 Apr 2025, 5:47:25 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
    </head>
    <body>
        <jsp:include page="Navbar.jsp"/>
        <div class="container">
            <h4 class="text-danger">CONTACT FORM</h4>
            <hr>
            <form action="#">
                <p class="form-group">
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control">
                </p>
                <p class="form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control">
                </p>
                <p class="form-group">
                    <label for="phone">Phone</label>
                    <input type="number" name="phone" class="form-control">
                </p>
                <p class="form-group">
                    <label for="subject">Subject</label>
                    <input type="text" name="subject" class="form-control">
                </p>
                <p class="form-group">
                    <label for="message">Message</label>
                    <textarea rows="5" cols="10" class="form-control" name="message"></textarea>
                </p>
                <p class="form-group">
                    <input type="submit" value="Submit" class="btn btn-danger">
                    <input type="reset" value="Reset" class="btn btn-danger">
                </p>
            </form>
        </div>
    </body>
</html>
