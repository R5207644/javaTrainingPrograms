<%-- 
    Document   : DestinationTab
    Created on : 6 Jun 2025, 6:00:59 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Honeymoon Trips</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">International Trips</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Domestic Trips</button>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="row">
                        <div class="col-3">
                            <div class="card">
                                <img src="Static/img/1.jpg" class="card-img" alt=""/>
                                <p>Bali Indonesia</p>
                                <h4 class="card-title">Bali Honeymoon 7 Days 6 Nights Tour Package</h4>
                                <p class="card-text"><s>₹44,999 </s> &nbsp; <b class="text-success">₹39,999</b></p>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#enquiryModal"><i class="fa-solid fa-phone"></i>Request a Callback</button>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="Static/img/2.jpg" class="card-img" alt=""/>
                                <p>Bali Indonesia</p>
                                <h4 class="card-title">Bali Honeymoon 7 Days 6 Nights Tour Package</h4>
                                <p class="card-text"><s>₹44,999 </s> &nbsp; <b class="text-success">₹39,999</b></p>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#enquiryModal"><i class="fa-solid fa-phone"></i>Request a Callback</button>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="Static/img/3.jpg" class="card-img" alt=""/>
                                <p>Bali Indonesia</p>
                                <h4 class="card-title">Bali Honeymoon 7 Days 6 Nights Tour Package</h4>
                                <p class="card-text"><s>₹44,999 </s> &nbsp; <b class="text-success">₹39,999</b></p>
                                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#enquiryModal"><i class="fa-solid fa-phone"></i>Request a Callback</button>
                            </div>
                        </div>
                        <div class="col-3">
                            
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">...</div>
                <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">...</div>
            </div>
    </body>
</html>
