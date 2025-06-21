<%-- 
    Document   : functionTag
    Created on : 9 Apr 2025, 5:32:28 pm
    Author     : local user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Function Tag</title>
    </head>
    <body>
        <%--<c:set var="a" value="Welcome to Maa Sharda"/>--%>
        <%--<c:if test="${fn:containsIgnoreCase(a, 'maa')}">--%>
            <!--<p>Found Maa String</p>-->
        <%--</c:if>--%>
        
          <%--<c:set var="a" value="Welcome to Maa Sharda"/>--%>
        <%--<c:if test="${fn:endsWith(a, 'Sharda')}">--%>
            <!--<p>Ends with Sharda</p>-->
        <%--</c:if>--%>
        
        <c:set var="str1" value="This is First String"/>
        <c:set var="str2" value="This is <xyz>Second</xyz> String"/>
        <p>With escape function</p>
        <p>String1: ${fn:escapeXml(str1)}</p>
        <p>String1: ${fn:escapeXml(str2)}</p>
        
        <p>Without escape Character</p>
        <p>String1: ${str1}</p>
        <p>String1: ${str2}</p>
    </body>
</html>
