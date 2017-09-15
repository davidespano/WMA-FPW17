<%-- 
    Document   : filter
    Created on : 15-set-2017, 13.32.25
    Author     : davide
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach items="${films}" var="film">
        <json:object>
            <json:property name="id" value="${film.getId()}"/>
            <json:property name="titolo" value="${film.getTitolo()}"/>
            <json:property name="riassunto" value="${film.getRiassunto()}"/>
        </json:object>
    </c:forEach>
</json:array>