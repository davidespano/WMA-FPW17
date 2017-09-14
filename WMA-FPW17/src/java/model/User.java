/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author davide
 */
public class User {
    
    public static final int ADMIN = 1;
    public static final int REGISTERED = 0;
    
    private int id;
    private String username;
    private String password;
    private int type;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    public boolean canDelete(Film film){
        // l'utente davide può cancellare solo il film con identificatore 1
        // tutti gli altri no. L'amministratore può cancellare tutto.
        if(this.getType() == User.ADMIN){
            return true;
        }
        
        if(this.getUsername().equals("davide") && film.getId() == 1){
            return true;
        }
        
        return false;
    }
    
}
