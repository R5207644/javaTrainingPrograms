<%-- 
    Document   : home
    Created on : 8 Apr 2025, 4:51:03 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <%--<c:out value="Hello World"/>--%>
        <%--<c:import var="data" url="https://edistrict.up.gov.in/edistrictup/"/>--%>
        <%--<c:out value="${data}"/>--%>
        <%--<c:set var="income" scope="session" value="${4000 * 4}"/>
       <p>Value before remove <c:out value="${income}"/></p>
       <c:remove var="income"/>
       <p>Value after remove <c:out value="${income}"/></p>--%>
        
        <%--<c:catch var="ex">--%>
            <% //
//                int x = 2/0;
//            %>
        <%--</c:catch>--%>
        
        <%--<c:out value="${ex}"/>--%>
        
        <%--<c:set var="a" scope="session" value="${10000}"/>--%>
        <%--<c:if test="${a > 1000}">--%>
            <!--<p>Income is greater than 10000</p>-->
        <%--</c:if>--%>
        
        <%--<c:set var="income" scope="session" value="${10000}"/>--%>
        <%--<c:choose>--%>
            <%--<c:when test="${income < 1000}">--%>
                <!--<p>salary is not good</p>-->
            <%--</c:when>--%>
                
                <%--<c:when test="${income < 20000}">--%>
                    <!--<p>salary is good</p>-->
                <%--</c:when>--%>
                    
                    <%--<c:otherwise>--%>
                        <!--<p>income is not defined</p>-->
                    <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        
        <%--<c:forEach var="j" begin="1" end="10">--%>
            <!--<p><c:out value="${j}"/></p>-->
        <%--</c:forEach>--%>
        
        <%--<c:forTokens items="rahul-nakul-Sarvesh" delims="-" var="name">--%>
            <%--<c:out value="${name}"/>--%>
        <%--</c:forTokens>--%>
        
        <%--<c:url value="/home.jsp" var="completeURL">--%>
        <%--<c:param name="id" value="1"/>--%>
        <%--<c:param name="user" value="secret"/>--%>
        <%--</c:url>--%>
        <%--<c:out value="${completeURL}"/>--%>
        
        <%--<c:redirect url="https://www.facebook.com"/>--%>
        
        <%--<c:url value="/Home.jsp/"/>--%>
        
    </body>
</html>
