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
    
    private int idReclamation, idCategorieRec, idAnnonceRec, idUserRec,	idUserSRec;
    private String objet, textRec, statusRec;
    

    public Reclamation(int idReclamation, int idCategorieRec, int idAnnonceRec, int idUserRec, int idUserSRec, String objet, String textRec, String statusRec) {
        this.idReclamation = idReclamation;
        this.idCategorieRec = idCategorieRec;
        this.idAnnonceRec = idAnnonceRec;
        this.idUserRec = idUserRec;
        this.idUserSRec = idUserSRec;
        this.objet = objet;
        this.textRec = textRec;
        this.statusRec = statusRec;
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

    public int getIdUserRec() {
        return idUserRec;
    }

    public int getIdUserSRec() {
        return idUserSRec;
    }

    public String getObjet() {
        return objet;
    }

    public String getTextRec() {
        return textRec;
    }

    public String getStatusRec() {
        return statusRec;
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

    public void setIdUserRec(int idUserRec) {
        this.idUserRec = idUserRec;
    }

    public void setIdUserSRec(int idUserSRec) {
        this.idUserSRec = idUserSRec;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setTextRec(String textRec) {
        this.textRec = textRec;
    }

    public void setStatusRec(String statusRec) {
        this.statusRec = statusRec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", idCategorieRec=" + idCategorieRec + ", idAnnonceRec=" + idAnnonceRec + ", idUserRec=" + idUserRec + ", idUserSRec=" + idUserSRec + ", objet=" + objet + ", textRec=" + textRec + ", statusRec=" + statusRec + '}';
    }
    
    
}
