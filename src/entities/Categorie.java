/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author AJ
 */
public class Categorie {
    
    private int idCategorie;
    private String nomCat;

    public Categorie(int idCategorie, String nomCat) {
        this.idCategorie = idCategorie;
        this.nomCat = nomCat;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCategorie=" + idCategorie + ", nomCat=" + nomCat + '}';
    }
    
    
    
}
