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
    
    //FK
    private Integer idReclamation, idCategorieRec, idAnnonceRec, idUserRecS, idUserRecR;
    // For view
    private String  nomCategorieRec, nomAnnonceRec, nomUserRecS, nomUserRecR;
    
    private String choiceRec, descRec, statusRec, dateRec;
    /* 
    private string creationDate;
    private boolean expired = false ;
    
    if creationDate < system.now() + 3 monthes expired = true;
    */

    public Reclamation() {
    }

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

    public Integer getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public Integer getIdCategorieRec() {
        return idCategorieRec;
    }

    public void setIdCategorieRec(Integer idCategorieRec) {
        this.idCategorieRec = idCategorieRec;
    }

    public Integer getIdAnnonceRec() {
        return idAnnonceRec;
    }

    public void setIdAnnonceRec(Integer idAnnonceRec) {
        this.idAnnonceRec = idAnnonceRec;
    }

    public Integer getIdUserRecS() {
        return idUserRecS;
    }

    public void setIdUserRecS(Integer idUserRecS) {
        this.idUserRecS = idUserRecS;
    }

    public Integer getIdUserRecR() {
        return idUserRecR;
    }

    public void setIdUserRecR(Integer idUserRecR) {
        this.idUserRecR = idUserRecR;
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
    public Reclamation idReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
         return this;
    }

    public Reclamation idCategorieRec(Integer idCategorieRec) {
        this.idCategorieRec = idCategorieRec;
        return this;
    }

    public Reclamation idAnnonceRec(Integer idAnnonceRec) {
        this.idAnnonceRec = idAnnonceRec;
        return this;        
    }

    public Reclamation idUserRecS(Integer idUserRecS) {
        this.idUserRecS = idUserRecS;
        return this;
    }

    public Reclamation idUserRecR (Integer idUserRecR) {
        this.idUserRecR = idUserRecR;
        return this;

    }
    

    public Reclamation choiceRec(String choiceRec) {
        this.choiceRec = choiceRec;
        return this;
    }

    public Reclamation descRec(String descRec) {
        this.descRec = descRec;
        return this;
    }

    public Reclamation statusRec(String statusRec) {
        this.statusRec = statusRec;
        return this;
    }

    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
    }

    public Reclamation dateRec(String dateRec) {
        this.dateRec = dateRec;
        return this;
    }

    public String getNomCategorieRec() {
        return nomCategorieRec;
    }

    public void setNomCategorieRec(String nomCategorieRec) {
        this.nomCategorieRec = nomCategorieRec;
    }

    public String getNomAnnonceRec() {
        return nomAnnonceRec;
    }

    public void setNomAnnonceRec(String nomAnnonceRec) {
        this.nomAnnonceRec = nomAnnonceRec;
    }

    public String getNomUserRecS() {
        return nomUserRecS;
    }

    public void setNomUserRecS(String nomUserRecS) {
        this.nomUserRecS = nomUserRecS;
    }

    public String getNomUserRecR() {
        return nomUserRecR;
    }

    public void setNomUserRecR(String nomUserRecR) {
        this.nomUserRecR = nomUserRecR;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", idCategorieRec=" + idCategorieRec + ", idAnnonceRec=" + idAnnonceRec + ", idUserRecS=" + idUserRecS + ", idUserRecR=" + idUserRecR + ", nomCategorieRec=" + nomCategorieRec + ", nomAnnonceRec=" + nomAnnonceRec + ", nomUserRecS=" + nomUserRecS + ", nomUserRecR=" + nomUserRecR + ", choiceRec=" + choiceRec + ", descRec=" + descRec + ", statusRec=" + statusRec + ", dateRec=" + dateRec + '}';
    }

    
     
}
