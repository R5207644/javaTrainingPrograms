<%-- 
    Document   : FormatingTag
    Created on : 14 Apr 2025, 5:00:29 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formating Tag</title>
    </head>
    <body>
        <%--<c:set var="ammount" value="203.038"/>--%>
        <%--<fmt:parseNumber var="j" type="number" value="${ammount}"/>--%>
        <!--<h1 align="center"><i>Ammount is = </i><c:out value="${j}"/></h1>-->
        
        <%--<fmt:parseNumber var="j" integerOnly="true" type="number" value="${ammount}"/>--%>
        <!--<h1 align="center"><i>Ammount is = </i><c:out value="${j}"/></h1>-->
        
        <c:set var="str" value="<%=new java.util.Date()%>"/>
        <table border="2">
            <tr>
                <td width="100%">
                    <p align="center">
                        Formating: <fmt:formatDate value="${str}" type="both" timeStyle="long" dateStyle="long"/>
                    </p>
                </td>
            </tr>
            
            <c:forEach var="zone" items="<%=java.util.TimeZone.getAvailableIDs()%>">
                <tr>
                <td><c:out value="${zone}"/></td>
                <td>
                    <fmt:timeZone value="${zone}">
                        <fmt:formatDate value="${str}" timeZone="${zone}" type="both"/>
                        </fmt:timeZone>
                    </td>
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
