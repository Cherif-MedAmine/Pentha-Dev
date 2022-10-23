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
public class Reclamation {
    
    private int idReclamation, idCategorieRec, idAnnonceRec, idUserRecS, idUserRecR;
    private String choiceRec, descRec, statusRec, dateRec;
    /* 
    private string creationDate;
    private boolean expired = false ;
    
    if creationDate < system.now() + 3 monthes expired = true;
    */

    public Reclamation(int idReclamation, int idCategorieRec, int idAnnonceRec, int idUserRecS, int idUserRecR, String choiceRec, String descRec, String statusRec, String dateRec) {
        this.idReclamation = idReclamation;
        this.idCategorieRec = idCategorieRec;
        this.idAnnonceRec = idAnnonceRec;
        this.idUserRecS = idUserRecS;
        this.idUserRecR = idUserRecR;
        this.choiceRec = choiceRec;
        this.descRec = descRec;
        this.statusRec = statusRec;
        this.dateRec = dateRec;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public int getIdCategorieRec() {
        return idCategorieRec;
    }

    public int getIdAnnonceRec() {
        return idAnnonceRec;
    }

    public int getIdUserRecS() {
        return idUserRecS;
    }

    public int getIdUserRecR() {
        return idUserRecR;
    }

    public String getChoiceRec() {
        return choiceRec;
    }

    public String getDescRec() {
        return descRec;
    }

    public String getStatusRec() {
        return statusRec;
    }

    public String getDateRec() {
        return dateRec;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public void setIdCategorieRec(int idCategorieRec) {
        this.idCategorieRec = idCategorieRec;
    }

    public void setIdAnnonceRec(int idAnnonceRec) {
        this.idAnnonceRec = idAnnonceRec;
    }

    public void setIdUserRecS(int idUserRecS) {
        this.idUserRecS = idUserRecS;
    }

    public void setIdUserRecR(int idUserRecR) {
        this.idUserRecR = idUserRecR;
    }

    public void setChoiceRec(String choiceRec) {
        this.choiceRec = choiceRec;
    }

    public void setDescRec(String descRec) {
        this.descRec = descRec;
    }

    public void setStatusRec(String statusRec) {
        this.statusRec = statusRec;
    }

    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "idReclamation=" + idReclamation +
                ", idCategorieRec=" + idCategorieRec +
                ", idAnnonceRec=" + idAnnonceRec +
                ", idUserRecS=" + idUserRecS +
                ", idUserRecR=" + idUserRecR +
                ", choiceRec='" + choiceRec + '\'' +
                ", descRec='" + descRec + '\'' +
                ", statusRec='" + statusRec + '\'' +
                ", dateRec='" + dateRec + '\'' +
                '}';
    }

    
}
