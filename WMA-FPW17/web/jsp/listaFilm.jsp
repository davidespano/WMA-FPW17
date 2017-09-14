<%-- 
    Document   : schedaFilm
    Created on : 4-set-2017, 14.09.23
    Author     : davide
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CineFPW -  ${titolo}</title>
        <meta name="author" content="Davide Spano" />
        <meta name="description" content="Un piccolo sito di 
              prenotazione di biglietti del Cinema" />
        <meta name="keywords" content="cinema, Davide, Spano" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style2.css" type="text/css" />
    </head>
    <body>
        <div class="container">
            <!-- header -->
            <jsp:include page="header.jsp"/>

            <div class="row">
                <div class="col-3">
                    <nav>
                        <h2>Contents</h2>
                        <!-- lista non ordinata -->
                        <h3>Lista non ordinata </h3>
                        <ul class="lista-ss">
                            <li>Elemento senza link</li>
                            <li><a href="#synopsis">Synopsis</a></li>
                            <li><a href="#cast">Cast</a></li>
                        </ul>
                        <h3>Lista non ordinata </h3>
                        <!-- lista ordinata -->
                        <ol class="lista-ss">
                            <li>Prima lista</li>
                            <li>Prima lista</li>
                            <li><a href="#synopsis">Synopsis</a></li>
                            <li><a href="#cast">Cast</a></li>
                            <li>
                                <ul>
                                    <li>Prima sottolista</li>
                                    <li>Prima sottolista</li>
                                </ul>
                            </li>
                            <li>
                                <ul>
                                    <li>Seconda sottolista</li>
                                    <li>Seconda sottolista</li>
                                </ul>
                            </li>
                        </ol>
                        <h3>Lista non ordinata </h3>
                        <!-- lista innestata -->
                        <ul class="lista-or">
                            <li>Lista or</li>
                            <li>Lista or</li>
                            <li>
                                <ul>
                                    <li><a href="#">Primo elemento </a></li>
                                    <li><a href="#">Secondo elemento</a></li>
                                </ul>
                            </li>
                            <li><a href="#cast">Cast</a></li>
                        </ul>
                    </nav>
                </div>
                
                <div class="col-9">


                    <h2 id="synopsis">Lista Film</h2>
                    <ul>
                        <!-- vecchia versione 
                        <c :forEach var="i" begin="0" end="{ids.size() -1}">
                            <li>
                                <a href="PrimoAccessoDB?id={ids.get(i)}">
                                     {titoli.get(i)}
                                </a>
                            </li>
                        </c :forEach>
                        -->
                        
                        <!-- nuova versione -->
                        <c:forEach items="${films}" var="film">
                            <li>
                                <a href="FactorySecondoAccessoDB?id=${film.getId()}">
                                     ${film.getTitolo()}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    
                    
                </div>
            </div>

            <!-- footer -->
            <jsp:include page="footer.jsp"/>

        </div>
    </body>
</html>