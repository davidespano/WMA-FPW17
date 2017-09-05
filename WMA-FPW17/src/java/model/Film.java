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
public class Film {
    private int id;
    private String titolo;
    private String riassunto;
    private String imgUrl;
    
    // costruttore vuoto
    public Film(){
        this.id = -1;
        this.titolo = "";
        this.riassunto = "";
        this.imgUrl = "";
    }
    
    public Film(int id, String titolo){
        this(id, titolo, null, null);
    }
    
    // costruttore generale
    public Film(int id, String titolo, String riassunto, String imgUrl){
        this.id = id;
        this.titolo = titolo;
        this.riassunto = riassunto;
        this.imgUrl = imgUrl;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitolo(){
        return this.titolo;
    }
    
    public void setTitolo(String titolo){
        this.titolo = titolo;
    }
    
    public String getRiassunto(){
        return this.riassunto;
    }
    
    public void setRiassunto(String riassunto){
        this.riassunto = riassunto;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
