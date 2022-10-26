/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Riadh Akkari
 */
public class Discussion {
    private int idDiscussion; 
    private int idUserS;
    private int idUserR;

    public Discussion(int idDiscussion, int idUserS, int idUserR) {
        this.idDiscussion = idDiscussion;
        this.idUserS = idUserS;
        this.idUserR = idUserR;
    }
    public Discussion( int idUserS, int idUserR) {
    
        this.idUserS = idUserS;
        this.idUserR = idUserR;
        
    }

   

    public int getIdDiscussion(){
        return idDiscussion;
    }

    public void setIdDiscussion(int idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public int getIdUserS() {
        return idUserS;
    }

    public void setIdUserS(int idUserS) {
        this.idUserS = idUserS;
    }

    public int getIdUserR() {
        return idUserR;
    }

    public void setIdUserR(int idUserR) {
        this.idUserR = idUserR;
    }

   

    @Override
    public String toString() {
        return "Discussion{" + "idDiscussion=" + idDiscussion + ", idUserS=" + idUserS + ", idUserR=" + idUserR + '}';
    }

}