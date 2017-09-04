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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davide
 */
@WebServlet(name = "PrimoAccessoDB", urlPatterns = {"/PrimoAccessoDB"})
public class PrimoAccessoDB extends HttpServlet {

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
        
        String titolo = null;
        String riassunto = null;
        int id = 0;
        
        // Inizializzo la libreria per la connessione al database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrimoAccessoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        // Inizializzo la connessione
        String db = "jdbc:derby://localhost:1527/film";

        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(db, "davide", "spano");
            
            // creo l'istruzione sql
            Statement stmt = conn.createStatement();
            
            // creo la query
            String query = "select id, titolo, riassunto from film "
                    + "where id = 1";
            
            ResultSet set = stmt.executeQuery(query);
            
            
            while(set.next()){
                // accesso per nome colonna
                id = set.getInt("id");
                
                // accesso per indice, inizia a contare da 1
                titolo = set.getString(2);
                
                riassunto = set.getString("riassunto");
            }
            
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PrimoAccessoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("titolo", titolo);
        request.setAttribute("riassunto", riassunto);
        
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
