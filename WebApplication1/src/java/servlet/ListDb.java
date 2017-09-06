/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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

/**
 *
 * @author davide
 */
@WebServlet(name = "ListDb", urlPatterns = {"/ListDb"})
public class ListDb extends HttpServlet {

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
        // Inizializzo la libreria per la connessione al database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListDb.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        // Stringa di connessione
        String db = "jdbc:derby://localhost:1527/film";
        
        try {
            // PASSO 1: creazione della connessione
            Connection conn = DriverManager.getConnection(
                    db,
                    // username
                    "davide",
                    // password
                    "spano"
            );
            
            // PASSO 2: creo un oggetto che rappresenta istruzioni sql
            Statement stmt = conn.createStatement();
            
            // ResultSet è un oggetto che rappresenta la tabella risultato
            // di una query select
            ResultSet set = stmt.executeQuery(
                    "select id, titolo, riassunto from film");
            
            List<String> lista = new ArrayList<>();
            
            // set.next() incrementa di 1 l'indice della riga corrente.
            // si parte da -1 (per leggere la prima riga next va chiamato 
            // almeno una volta).
            while(set.next()){
                // qui leggo le celle della riga corrente
                String titolo = set.getString("titolo");
                lista.add(titolo);
            }
            
            lista.add("");
            lista.add("");
            
            // passo la lista alla jsp
            // sequenza è il nome della lista di valori all'interno della jsp
            request.setAttribute("sequenza", lista);
            
            // faccio la forward
            request.getRequestDispatcher("jsp/listView.jsp").
                    forward(request, response);
            
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ListDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
