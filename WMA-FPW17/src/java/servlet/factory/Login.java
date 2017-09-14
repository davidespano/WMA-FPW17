/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.factory;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserFactory;

/**
 *
 * @author davide
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        
        String pageToLoad = "jsp/login.jsp";
        
        // restituisce un oggetto che rappresenta la sessione
        // solo nel caso sia stato inizializzato ad una richesta precedente
        // altrimenti restituisce null
        HttpSession session = request.getSession(false);
        UserFactory factory = new UserFactory();
        
        if(session != null && session.getAttribute("userId") != null){
           // utente è già autenticato 
           pageToLoad = "/FilmList";
           int id = (int) session.getAttribute("userId");
           User user = factory.getUserById(id);
           request.setAttribute("user", user);
        }
        
        if(request.getParameter("login") != null){
            // se il parametro login è diverso da null, allora il mio utente
            // ha premuto il pulsante di login
            
            // usare come chiavi il NAME degli input
            String username = request.getParameter("user");
            String password = request.getParameter("pass");
            
            // leggo i dati dal db
            
            User user = factory.getUserByUsernamePassword(username, password);
            
            if(user != null){
                // l'utente è autenticato, lo portiamo alla lista di Film
                pageToLoad = "/FilmList";
                
                // inizializzo la sessione. Se non esisteva alla richiesta
                // precedente, ne creo una nuova (parametro del metodo a true)
                session = request.getSession(true);
                
                // creo una variabile di sessione, questo indica che sia
                // autenticato
                session.setAttribute("userId", user.getId());
                
                request.setAttribute("user", user);
                
            }else{
                request.setAttribute("auth_errato", true);
                
                // utente non autenticato lo rimando al login
                pageToLoad = "jsp/login.jsp";
            }
            
        }
        
        if(request.getParameter("logout") != null){
            // abbiamo premuto sul link di logout
            if(session != null)
                session.invalidate();
            pageToLoad = "jsp/login.jsp";
            request.setAttribute("user", null);
            
        }
        
        request.getRequestDispatcher(pageToLoad).forward(request, response);
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
