/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Annonce;
import entities.Attachement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;


/**
 *
 * @author amine
 */
public class AnnonceCRUD implements InterfaceAnnonce {
    Connection conx = MyDB.getInstance().getConnection();

    @Override
    public void ajouterAnnonce(Annonce A) {
        String req = "INSERT INTO `annonce`( `idUserA`, `description`, `adresseAnnonce`, `prixAnnonce`, `regionAnnonce`, `municipalite`, `codePostal`, `typeOpertaion`, `categorie`, `longitude`, `latitude`, `statut`, `superficie`, `archiveAnnonce`) VALUES (" +A.getIdUserA()+ ",'" +A.getDescription()+ "','" +A.getAdresseAnnonce()+ "'," +A.getPrixAnnonce()+ ",'" +A.getRegionAnnonce()+ "','" +A.getMunicipalite()+ "'," +A.getCodePostal()+ ",'" +A.getTypeOpertaion()+ "','" +A.getCategorie()+ "','" +A.getLongitude()+ "','" +A.getLatitude()+ "','" +A.getStatut()+ "','" +A.getSuperficie()+ "'," +A.getArchiveAnnonce()+ ")" ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

  

    @Override
    public void modifierAnnonce(Annonce A) {
         
         String req = "UPDATE `annonce` SET `idUserA`="+A.getIdUserA()+",`description`='"+A.getDescription()+"',`adresseAnnonce`='"+A.getAdresseAnnonce()+"',`prixAnnonce`="+A.getPrixAnnonce()+",`regionAnnonce`='"+A.getRegionAnnonce()+"',`municipalite`='"+A.getMunicipalite()+"',`codePostal`="+A.getCodePostal()+",`typeOpertaion`='"+A.getTypeOpertaion()+"',`categorie`='"+A.getCategorie()+"',`longitude`='"+A.getLongitude()+"',`latitude`='"+A.getLatitude()+"',`statut`='"+A.getStatut()+"',`superficie`='"+A.getSuperficie()+"',`archiveAnnonce`="+A.getArchiveAnnonce()+" WHERE idAnnonce ="+ A.getIdAnnonce();
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("L'Annonce est ajouté");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerAnnonce(Annonce A) {
        String req ;
        req = "UPDATE `annonce` SET `idUserA`="+A.getIdUserA()+",`description`='"+A.getDescription()+"',`adresseAnnonce`='"+A.getAdresseAnnonce()+"',`prixAnnonce`="+A.getPrixAnnonce()+",`regionAnnonce`='"+A.getRegionAnnonce()+"',`municipalite`='"+A.getMunicipalite()+"',`codePostal`="+A.getCodePostal()+",`typeOpertaion`='"+A.getTypeOpertaion()+"',`categorie`='"+A.getCategorie()+"',`longitude`='"+A.getLongitude()+"',`latitude`='"+A.getLatitude()+"',`statut`='"+A.getStatut()+"',`superficie`='"+A.getSuperficie()+"',`archiveAnnonce`="+1+" WHERE idAnnonce ="+ A.getIdAnnonce();
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("L'Annonce est ajouté");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 

    @Override
    public List<Annonce> Afficher() {
           List <Annonce> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  annonce";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Annonce A = new Annonce (rs.getInt(1), rs.getInt("idUserA"),rs.getString("description"),rs.getString("adresseAnnonce"),rs.getFloat("prixAnnonce"),rs.getString("regionAnnonce"),rs.getString("municipalite"),rs.getInt("codePostal"),rs.getString("typeOpertaion"),rs.getString("categorie"),rs.getString("longitude"),rs.getString("latitude"),rs.getString("statut"),rs.getString("superficie"),rs.getInt("archiveAnnonce"));
    list.add(A);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }  
//////////////////////////////////////
    @Override
    public void ajouterAttachement(Attachement Att) {
        String req = "INSERT INTO `attachement`( `idAnnonceAtt`, `nomAttachement`, `src`, `format`) VALUES (" +Att.getIdAnnonceAtt()+ ",'" +Att.getNomAttachement()+ "','" +Att.getSrc()+ "','" +Att.getFormat()+ "')" ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierAttachement(Attachement Att) {
         String req = "UPDATE `attachement` SET `idAnnonceAtt`="+Att.getIdAnnonceAtt()+",`nomAttachement`='"+Att.getNomAttachement()+"',`src`='"+Att.getSrc()+"',`format`='"+Att.getFormat()+"' WHERE idAttachement ="+ Att.getIdAttachement();
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("L'Attachement est ajouté");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimerAttachement(int idAttachement) {
         try {
        String req=" DELETE FROM attachement WHERE idAttachement="+ idAttachement ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
       
    }

    @Override
    public List<Attachement> AfficherAtt() {
              List <Attachement> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  attachement";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Attachement Att = new Attachement (rs.getInt(1), rs.getInt("idAnnonceAtt"),rs.getString("nomAttachement"),rs.getString("src"),rs.getString("format"));
    list.add(Att);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }

    
}



   

