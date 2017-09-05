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
