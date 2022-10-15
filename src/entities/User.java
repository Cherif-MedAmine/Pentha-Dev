/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Oumayma Gaiech
 */
public class User {
    
    private int idUser;
    private String fullName;
    private int genreUser;
    private String email;
    private String mdp;
    private String region;
    private String municipalite;
    private String telephone;
    private String role;
    private String adresseAgence;
    private String jourTravail;
    private String heureTravail;
    
public User(){
        
    }
    public User(int idUser, String fullName, int genreUser, String email, String mdp, String region, String municipalite, String telephone, String role, String adresseAgence, String jourTravail, String heureTravail) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.genreUser = genreUser;
        this.email = email;
        this.mdp = mdp;
        this.region = region;
        this.municipalite = municipalite;
        this.telephone = telephone;
        this.role = role;
        this.adresseAgence = adresseAgence;
        this.jourTravail = jourTravail;
        this.heureTravail = heureTravail;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGenreUser() {
        return genreUser;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getRegion() {
        return region;
    }

    public String getMunicipalite() {
        return municipalite;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRole() {
        return role;
    }

    public String getAdresseAgence() {
        return adresseAgence;
    }

    public String getJourTravail() {
        return jourTravail;
    }

    public String getHeureTravail() {
        return heureTravail;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGenreUser(int genreUser) {
        this.genreUser = genreUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setMunicipalite(String municipalite) {
        this.municipalite = municipalite;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAdresseAgence(String adresseAgence) {
        this.adresseAgence = adresseAgence;
    }

    public void setJourTravail(String jourTravail) {
        this.jourTravail = jourTravail;
    }

    public void setHeureTravail(String heureTravail) {
        this.heureTravail = heureTravail;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", fullName=" + fullName + ", genreUser=" + genreUser + ", email=" + email + ", mdp=" + mdp + ", region=" + region + ", municipalite=" + municipalite + ", telephone=" + telephone + ", role=" + role + ", adresseAgence=" + adresseAgence + ", jourTravail=" + jourTravail + ", heureTravail=" + heureTravail + '}';
    }
    
}
