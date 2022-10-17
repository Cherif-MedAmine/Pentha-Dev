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
public class Annonce {
     private int idAnnonce;
    private int idUserA;
    private String description;
    private String adresseAnnonce;
    private float prixAnnonce;
    private String regionAnnonce;
    private String municipalite;
    private int codePostal;
    private String typeOpertaion;
    private String categorie;
    private String longitude;
    private String latitude;
    private String statut;
    private String superficie;
    private int archiveAnnonce;

    public Annonce(int idAnnonce, int idUserA, String description, String adresseAnnonce, float prixAnnonce, String regionAnnonce, String municipalite, int codePostal, String typeOpertaion, String categorie, String longitude, String latitude, String statut, String superficie, int archiveAnnonce) {
        this.idAnnonce = idAnnonce;
        this.idUserA = idUserA;
        this.description = description;
        this.adresseAnnonce = adresseAnnonce;
        this.prixAnnonce = prixAnnonce;
        this.regionAnnonce = regionAnnonce;
        this.municipalite = municipalite;
        this.codePostal = codePostal;
        this.typeOpertaion = typeOpertaion;
        this.categorie = categorie;
        this.longitude = longitude;
        this.latitude = latitude;
        this.statut = statut;
        this.superficie = superficie;
        this.archiveAnnonce = archiveAnnonce;
    }

    
    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public int getIdUserA() {
        return idUserA;
    }

    public void setIdUserA(int idUserA) {
        this.idUserA = idUserA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresseAnnonce() {
        return adresseAnnonce;
    }

    public void setAdresseAnnonce(String adresseAnnonce) {
        this.adresseAnnonce = adresseAnnonce;
    }

    public float getPrixAnnonce() {
        return prixAnnonce;
    }

    public void setPrixAnnonce(float prixAnnonce) {
        this.prixAnnonce = prixAnnonce;
    }

    public String getRegionAnnonce() {
        return regionAnnonce;
    }

    public void setRegionAnnonce(String regionAnnonce) {
        this.regionAnnonce = regionAnnonce;
    }

    public String getMunicipalite() {
        return municipalite;
    }

    public void setMunicipalite(String municipalite) {
        this.municipalite = municipalite;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getTypeOpertaion() {
        return typeOpertaion;
    }

    public void setTypeOpertaion(String typeOpertaion) {
        this.typeOpertaion = typeOpertaion;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public int getArchiveAnnonce() {
        return archiveAnnonce;
    }

    public void setArchiveAnnonce(int archiveAnnonce) {
        this.archiveAnnonce = archiveAnnonce;
    }

    @Override
    public String toString() {
        return "Annonce{" + "idAnnonce=" + idAnnonce + ", idUserA=" + idUserA + ", description=" + description + ", adresseAnnonce=" + adresseAnnonce + ", prixAnnonce=" + prixAnnonce + ", regionAnnonce=" + regionAnnonce + ", municipalite=" + municipalite + ", codePostal=" + codePostal + ", typeOpertaion=" + typeOpertaion + ", categorie=" + categorie + ", longitude=" + longitude + ", latitude=" + latitude + ", statut=" + statut + ", superficie=" + superficie + ", archiveAnnonce=" + archiveAnnonce + '}';
    }

 
    
    
    
    
}
