/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author amine
 */
public class Attachement {
     private int idAttachement;
    private int idAnnonceAtt;
    private String nomAttachement;
    private String src;
    private String format;

    public Attachement(int idAttachement, int idAnnonceAtt, String nomAttachement, String src, String format) {
        this.idAttachement = idAttachement;
        this.idAnnonceAtt = idAnnonceAtt;
        this.nomAttachement = nomAttachement;
        this.src = src;
        this.format = format;
    }

    public int getIdAttachement() {
        return idAttachement;
    }

    public void setIdAttachement(int idAttachement) {
        this.idAttachement = idAttachement;
    }

    public int getIdAnnonceAtt() {
        return idAnnonceAtt;
    }

    public void setIdAnnonceAtt(int idAnnonceAtt) {
        this.idAnnonceAtt = idAnnonceAtt;
    }

    public String getNomAttachement() {
        return nomAttachement;
    }

    public void setNomAttachement(String nomAttachement) {
        this.nomAttachement = nomAttachement;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Attachement{" + "idAttachement=" + idAttachement + ", idAnnonceAtt=" + idAnnonceAtt + ", nomAttachement=" + nomAttachement + ", src=" + src + ", format=" + format + '}';
    }
    
    
    
}
