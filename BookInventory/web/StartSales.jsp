<%-- 
    Document   : StartSales
    Created on : 23 Apr 2025, 5:42:13 pm
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
        <jsp:include page="Navbar.jsp"/>
        <section class="py-5 px-5">
            <form method="post" action="AddSell.jsp">
                <h5 class="text-danger">Start Sales</h5>
                <hr>
                <div class="row">
                    <div class="col-8">
                        <table class="table table-borderless">
                            <tr>
                                <td class="form-group">
                                    <label>Customer Name<span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" required name="name">
                                </td>
                                <td class="form-group">
                                    <label>Mobile Number<span class="text-danger">*</span></label>
                                    <input type="number" min="6666666666" max="9999999999" class="form-control" name="mobile" required>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Start Order" class="btn btn-danger">
                                    <input type="reset" value="Reset Form" class="btn btn-danger">
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </form>
        </section>
    </body>
</html>
