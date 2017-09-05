/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Film;

/**
 *
 * @author davide
 */
@WebServlet(name = "FilmList", urlPatterns = {"/FilmList"})
public class FilmList extends HttpServlet {

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
        
        // ---- vecchia versione  ----
        //List<String> titoli = new ArrayList<>();
        //List<Integer> ids = new ArrayList<>();
        
        // ---- nuova versione ----
        List<Film> films = new ArrayList();
        
        // Inizializzo la connessione
        String db = "jdbc:derby://localhost:1527/film";
        
        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(db, "davide", "spano");
            
            // creo l'istruzione sql
            Statement stmt = conn.createStatement();
            
            // creo la query
            
            String query = "select id, titolo from film ";
            
            ResultSet set = stmt.executeQuery(query);
            
            
            
            
            int count = 0;           
            while(set.next()){
                count++;
                
                // ----- vecchia versione -----
                //ids.add(set.getInt("id"));
                //titoli.add(set.getString("titolo"));
                
                Film film = new Film();
                film.setId(set.getInt("id"));
                film.setTitolo(set.getString("titolo"));
                
                films.add(film);
            }
            
            // non ci sono righe
            if (count == 0){
                // mostrare 404
                
            }
          
            // ---- vecchia versione ------
            //request.setAttribute("ids", ids);
            //request.setAttribute("titoli", titoli);
            
            request.setAttribute("films", films);
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("jsp/listaFilm.jsp").forward(request, response);
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
