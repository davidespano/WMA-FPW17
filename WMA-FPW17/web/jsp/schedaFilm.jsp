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
        <title>CineFPW -  ${film.getTitolo()}</title>
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


                    <h2 id="synopsis">${film.getTitolo()}</h2>
                    
                    <div id="edit">
                        <a href="./FactorySecondoAccessoDB?delete=${film.getId()}">
                            Cancella il film tramite link
                        </a><br/>
                        <form method="post" action="./FactorySecondoAccessoDB">
                            <input type="hidden" name="delete" value="${film.getId()}"/>
                            <button type="submit" name="deleteBnt">
                                Cancella tramite pulsante
                            </button>
                        </form>
                    </div>
                    
                    <p>
                        ${film.getRiassunto()}
                    </p>
                 
                    <h2 id="cast">Cast</h2>
                    <table>
                        <tr>
                            <th>Photo</th>
                            <th>Actor</th>
                            <th>Character</th>
                        </tr>
                        <tr>
                            <td>
                                <img src="https://images-na.ssl-images-amazon.com/images/M/MV5BMjE0MDkzMDQwOF5BMl5BanBnXkFtZTgwOTE1Mjg1MzE@._V1_UX32_CR0,0,32,44_AL_.jpg"
                                     alt="Benedict Cumberbatch"/>
                            </td>
                            <td>
                                Benedict Cumberbatch
                            </td>
                            <td>
                                Alan Turing
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="https://images-na.ssl-images-amazon.com/images/M/MV5BMTYwNDM0NDA3M15BMl5BanBnXkFtZTcwNTkzMjQ3OA@@._V1_UX32_CR0,0,32,44_AL_.jpg"
                                     alt="Keira Knightley" />
                            </td>
                            <td>
                                Keira Knightley
                            </td>
                            <td>
                                Joan Clarke
                            </td>
                        </tr>
                    </table>

                    <h2>Test div</h2>
                    <div>
                        <p>He arrives at Bletchley Park, guarded by Royal 
                            Naval officers. He waits in the office of Commander Denniston 
                            (Charles Dance). When the Commander arrives, Alan is cold and seems 
                            to lack humour. 
                        </p>
                        <img src="./img/alanturing.jpg" alt="locandina del film" 
                             title="tooltip per il mouse"/>
                    </div>


                    <span>
                        The Commander asks why Alan wants to work for the 
                        government; he replies he doesn't. He mentions that he's not 
                        very political and the Commander says it may be the shortest job 
                        interview ever. Alan mentions he doesn't speak German but tells the 
                        Commander that he's one of the best mathematicians in the world. 
                        He considers German codes to be like puzzles, which he enjoys 
                        solving. 
                    </span>
                    <span>The Commander calls for Alan to be removed by his 
                        secretary so Alan mentions Enigma, revealing he knows about the 
                        top secret program he's being considered for. Alan explains that 
                        Enigma is the greatest encryption device in history and if the 
                        Allies can crack the code, it will end the war. The Commander 
                        says everyone thinks Enigma is unbreakable. Alan says to let him 
                        try and they'll know for sure.
                    </span>
                </div>
            </div>

             <!-- footer -->
            <jsp:include page="footer.jsp"/>

        </div>
    </body>
</html>