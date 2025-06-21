<%-- 
    Document   : home
    Created on : 15 Apr 2025, 5:58:49 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="static/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Navbar.jsp"/>
        <div class="container">
            <section class="home-header">
                <div class="row kg-row-home-top">
                    <div class="col-5 home-header-box">
                        <h1>Factory Books</h1>
                        <p>We Sell new And used books all around the world in our very busy books projects.</p>
                        <p>All run by a dedicated group of volunteers based at varanasi.</p>
                    </div>
                    <div class="col-7 kg-home-col-7 home-header-box">
                        <img src="static/img/laptop-image.png" class="img-fluid" alt=""/>
                    </div>
                </div>
            </section>

            <section>
                <h4>BOOK SHOP MANAGEMENT SYSTEM</h4>
                <hr>
                <div>
                    A Book Management System is a software application designed to 
                    efficiently manage and organize a collection of books, whether for
                    personal use, libraries, bookstores, or educational institutions.
                    This system streamlines tasks such as cataloging books, tracking
                    availability, managing borrow/return activities, and maintaining
                    user records.
                </div>
                <div class="row kg-row-home">
                    <div class="col-2 card-body">
                        <img src="static/img/laptop-image.png" class="card-img-top" alt="alt"/>
                    </div>
                    <div class="col-10">
                        <h4>SELLS MANAGEMENT SYSTEM</h4>
                        <p>
                            A Sales Management System for a Book Shop Management 
                            System is a tool designed to streamline the sales process,
                            track revenue, and enhance customer experience. It enables
                            efficient handling of transactions, inventory, and customer
                            records, ensuring smooth day-to-day operations of a bookstore.
                        </p>
                    </div>
                </div>
                <div class="row kg-row-home">
                    <div class="col-2 card-body">
                        <img src="static/img/laptop-image.png" class="card-img-top" alt="alt"/>
                    </div>
                    <div class="col-10">
                        <h4>ADMINISTRATOR MANAGEMENT SYSTEM</h4>
                        <p>
                            An Administrator Management System is a software solution
                            designed to streamline and centralize administrative tasks
                            within an organization, institution, or system. It ensures
                            effective management of operations, enhances productivity,
                            and provides comprehensive control over key administrative
                            functions.

                        </p>
                    </div>
                </div>
                <div class="row kg-row-home">
                    <div class="col-2 card-body">
                        <img src="static/img/laptop-image.png" class="card-img-top" alt="alt"/>
                    </div>
                    <div class="col-10">
                        <h4>BOK MANAGEMENT SYSTEM</h4>
                        <p>
                            A Book Management System is a software application designed
                            to simplify and automate the process of managing books within
                            a library, bookstore, or personal collection. It serves
                            as an efficient tool for cataloging, tracking, and maintaining
                            records, ensuring that users can handle book-related tasks with ease.

                        </p>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
