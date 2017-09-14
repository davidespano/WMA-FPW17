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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.SecondoAccessoDB;

/**
 *
 * @author davide
 */
public class FilmFactory {
    
    public FilmFactory(){
        // Inizializzo la libreria per la connessione al database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecondoAccessoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Film> getFilmList(){
        List<Film> films = new ArrayList();
        
      
        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(
                    Settings.DB_URL,
                    Settings.DB_USR,
                    Settings.DB_PSW
            );
            
            // creo l'istruzione sql
            Statement stmt = conn.createStatement();
            
            // creo la query
            
            String query = "select id, titolo, riassunto from film ";
            
            ResultSet set = stmt.executeQuery(query);
            

            while(set.next()){
                
                Film film = new Film();
                film.setId(set.getInt("id"));
                film.setTitolo(set.getString("titolo"));
                film.setRiassunto(set.getString("riassunto"));
    
                films.add(film);
            }
            
            
          
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return films;
    }
    
    public Film getFilmById(int id){
        Film toReturn = null;
        
        try {
            // creazione e apertura della connessione
            // si specifica la url, lo username e la password per il db
            Connection conn = DriverManager.getConnection(
                    Settings.DB_URL,
                    Settings.DB_USR,
                    Settings.DB_PSW
            );
            
            // creo la query
            String query = "select id, titolo, riassunto from film where id = ?";
            
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
                
                toReturn = new Film();
                
                toReturn.setId(set.getInt("id"));
                toReturn.setTitolo(set.getString("titolo"));
                toReturn.setRiassunto(set.getString("riassunto"));
            }
            
            // Chiusura della connessione
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    /**
     * Questo metodo cancella il film con l'identificatore specificato
     * @param id l'identificatore del film da cancellare
     * @return true se il film è stato cancellato correttamente, false altrimenti. 
     */
    public boolean deleteFilm(int id){
        // stub del metodo da rimpiazzare con la query
        if(id >= 1 && id <=3){
            return true;
        }else{
            return false;
        }
    }
}
