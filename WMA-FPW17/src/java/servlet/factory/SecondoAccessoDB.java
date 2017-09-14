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
import model.Film;
import model.FilmFactory;

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
        int id = -1;
        Film film = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            film = factory.getFilmById(id);
        }

        if (request.getParameter("delete") != null) {
            // richiesta di cancellazione
            int delete = Integer.parseInt(request.getParameter("delete"));
            boolean deleted = factory.deleteFilm(delete);
            if (deleted) {
                // per non riscrivere una jsp diversa inserisco il messaggio
                // in un film fittizio.
                film = new Film();
                film.setTitolo("Film con identificatore " + delete
                        + " cancellato");
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
