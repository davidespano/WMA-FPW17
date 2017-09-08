<%-- 
    Document   : header
    Created on : 7-set-2017, 10.08.20
    Author     : davide
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-12">
        <header>
            <h1>CineFPW</h1>
        </header>
        <c:if test="${user != null}">
            <p>
                Ciao, ${user.getUsername()}
            </p>
            <p>
                <a href="Login?logout">Logout</a>
            </p>
        </c:if>
    </div>
</div>
