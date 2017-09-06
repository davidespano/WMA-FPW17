<%-- 
    Document   : listView
    Created on : 6-set-2017, 12.07.28
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <li>${sequenza.get(0)}</li>
            <li>${sequenza.get(1)}</li>
            <li>${sequenza.get(2)}</li>
            <li>${sequenza.get(3)}</li>
            <li>${sequenza.get(4)}</li>
        </ul>
        <!-- equivalente, vi dimostra che l'oggetto request e' lo stesso
            fra servlet e jsp richiamata ${sequenza.get(0)}
        -->
        <ul>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(0) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(1) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(2) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(3) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(4) %></li>
        </ul>
        <!-- scorriamo la sequenza con un foreach -->
        <ul>
            <c:forEach begin="0" end="${sequenza.size() - 1}" var="i">
                <li>${sequenza.get(i)}</li>
            </c:forEach>
        </ul>
        <!-- scorriamo con l'elemento -->
        <ul>
            <c:forEach items="${sequenza}" var="elemento">
                <li>${elemento}</li>
            </c:forEach>
        </ul>
    </body>
</html>
