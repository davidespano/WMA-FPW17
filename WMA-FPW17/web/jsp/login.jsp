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
        <title>CineFPW -  Login</title>
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
                    <c:if test="${auth_errato}">
                         <p>Username o password errati</p>
                    </c:if>
                   
                    <h2 id="synopsis">Login</h2>
                    <form method="post" action="Login">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="user"
                               placeholder="Il nome con cui ti sei registrato"/>
                        
                        <label for="password">Password</label>
                        <input type="password" id="password" name="pass" />
                        
                        <button type="submit" name="login" id="login">
                            Login
                        </button>
                    </form>
                    
                    
                </div>
            </div>

            <!-- footer -->
            <jsp:include page="footer.jsp"/>

        </div>
    </body>
</html>