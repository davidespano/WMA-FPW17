/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.factory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Film;
import model.FilmFactory;
import model.User;
import model.UserFactory;

/**
 *
 * @author davide
 */
@WebServlet(name = "FactorySecondoAccessoDB", urlPatterns = {"/FactorySecondoAccessoDB"})
public class SecondoAccessoDB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FilmFactory factory = new FilmFactory();
        UserFactory userFactory = new UserFactory();
        User user = null;
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("userId") != null){
            // l'utente è autenticato, recupero l'utente tramite
            // il suo identificatore salvato in sessione
            int userId = (int) session.getAttribute("userId");
            user = userFactory.getUserById(userId);
            request.setAttribute("user", user);
        }else{
            // non è autenticato, lo rimando alla login, lo faccio con una 
            // redirect nella risposta (il browser carica in automatico la nuova
            // URL)
            
            response.sendRedirect("Login");
            return;
        }

        
        int id = -1;
        Film film = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            film = factory.getFilmById(id);
        }

        if (request.getParameter("delete") != null) {
            // richiesta di cancellazione
            int delete = Integer.parseInt(request.getParameter("delete"));
            film = factory.getFilmById(delete);
            boolean deleted = user.canDelete(film) && factory.deleteFilm(delete);
            if (deleted) {
                // per non riscrivere una jsp diversa inserisco il messaggio
                // in un film fittizio.
                film = new Film();
                film.setTitolo("Film con identificatore " + delete
                        + " cancellato");
            }else{
                // mostriamo un messaggio di errore nella cancellazione
                film = new Film();
                film.setTitolo("Film con identificatore " + delete
                        + " non cancellato");
            }
        }

        if (film == null) {
            film = new Film();
            film.setTitolo("Nessun film trovato");
        }

        request.setAttribute("film", film);
        request.getRequestDispatcher("jsp/schedaFilm.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
