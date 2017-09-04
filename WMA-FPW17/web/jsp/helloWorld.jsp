<%-- 
    Document   : helloWorld
    Created on : 4-set-2017, 12.29.50
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach begin='1' end="${casuale}" var="i">
            <p>Un bel ${i}-mo paragrafo</p>
        </c:forEach>
    </body>
</html>
