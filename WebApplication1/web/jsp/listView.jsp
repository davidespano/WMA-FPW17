<%-- 
    Document   : listView
    Created on : 6-set-2017, 12.07.28
    Author     : davide
--%>

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
            fra servlet e jsp richiamata
        -->
        <ul>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(0) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(1) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(2) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(3) %></li>
            <li><%= ((List<String>)request.getAttribute("sequenza")).get(4) %></li>
        </ul>
        
    </body>
</html>
