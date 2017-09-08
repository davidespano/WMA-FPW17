/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.SecondoAccessoDB;

/**
 *
 * @author davide
 */
public class UserFactory {
    
    public UserFactory(){
        // Inizializzo la libreria per la connessione al database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecondoAccessoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUserById(int id){
        User toReturn = null;
        
        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(
                    Settings.DB_URL,
                    Settings.DB_USR,
                    Settings.DB_PSW
            );
            
            // creo la query
            String query = "select id, username, password, uType from users where id = ?";
            
            // creo l'istruzione sql
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // dico quale valore ci vada al posto del punto di domanda
            // si specifica la posizione del punto di domanda nella stringa 
            // della query iniziandoli a contare da 1 (noi ne abbiamo uno solo
            // ma potrebbero essere anche di più) e si usa una set con il tipo 
            // di dato corrisponente alla colonna del db (intero, stringa, booleano ecc.). Per noi 
            // è un intero. 
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            
            if(set.next()){
                // il corpo lo eseguo al massimo una volta
                // in questo caso, poiché id è chiave primaria
                
                toReturn = new User();
                
                toReturn.setId(set.getInt("id"));
                toReturn.setUsername(set.getString("username"));
                toReturn.setPassword(set.getString("password"));
                toReturn.setType(set.getInt("uType"));
            }
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    /**
     * Ricerca un utente tramite username e password
     * @param username lo username da ricercare
     * @param password la password da ricercare
     * @return un oggetto User nel caso l'utente sia stato trovato, null altrimenti
     */
    public User getUserByUsernamePassword(String username, String password){
        User toReturn = null;
        
        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(
                    Settings.DB_URL,
                    Settings.DB_USR,
                    Settings.DB_PSW
            );
            
            // creo la query
            String query = "select id, username, password, uType from users "
                    + "where username = ? and password = ?";
            
            // creo l'istruzione sql
            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet set = stmt.executeQuery();
            
            
            if(set.next()){
                // il corpo lo eseguo al massimo una volta
                // in questo caso, poiché id è chiave primaria
                
                toReturn = new User();
                
                toReturn.setId(set.getInt("id"));
                toReturn.setUsername(set.getString("username"));
                toReturn.setPassword(set.getString("password"));
                toReturn.setType(set.getInt("uType"));
            }
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
}
