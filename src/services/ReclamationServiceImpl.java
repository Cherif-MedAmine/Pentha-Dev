/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Annonce;
import java.util.List;
import entities.Reclamation;
import utils.MyDB;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author AJ
 */
public class ReclamationServiceImpl implements ReclamationService {
    Connection conx = MyDB.getInstance().getConnection();

    @Override
    public void createReclamation(Reclamation R) {
        String req = "INSERT INTO `reclamation`( `idCategorieRec`, `idAnnonceRec`, `idUserRecS`, `idUserRecR`, `choiceRec`, `descRec`, `statusRec`, `dateRec`) VALUES (" +R.getIdCategorieRec()+ "," +R.getIdAnnonceRec()+ "," +R.getIdUserRecS()+ "," +R.getIdUserRecR()+ ",'" +R.getChoiceRec()+ "','" +R.getDescRec()+ "','" +R.getStatusRec()+ "','" +R.getDateRec()+ "')" ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void updateReclamation(Reclamation R) {
        
        String req = "UPDATE `reclamation` SET `idCategorieRec`="+R.getIdCategorieRec()+",`idAnnonceRec`="+R.getIdAnnonceRec()+",`idUserRecS`="+R.getIdUserRecS()+",`idUserRecR`="+R.getIdUserRecR()+",`choiceRec`='"+R.getChoiceRec()+"',`descRec`='"+R.getDescRec()+"',`statusRec`='"+R.getStatusRec()+"',`dateRec`='" +R.getDateRec()+ "' WHERE idReclamation ="+ R.getIdReclamation() ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("La reclamation est modifier");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        

    @Override
    public void deleteReclamation(int idReclamation) {
        try {
        String req=" DELETE FROM reclamation WHERE idReclamation="+ idReclamation ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

    @Override
    public List<Reclamation> getAll() {
        List <Reclamation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM  Reclamation";        
            Statement st;
            st =conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               Reclamation r = new Reclamation (rs.getInt(1), rs.getInt("idCategorieRec"), rs.getInt("idAnnonceRec"), rs.getInt("idUserRecS"), rs.getInt("idUserRecR"),rs.getString("choiceRec"),rs.getString("descRec"),rs.getString("statusRec"),rs.getString("dateRec"));
               list.add(r);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }   
    
    @Override
    public Reclamation getOneById(int idReclamation) {
        Reclamation reclamation = new Reclamation();
        String req="SELECT * FROM annonce where idAnnonce = " + idReclamation;
        System.out.println("req: "+req);
        System.out.println("id:" +idReclamation);
                
        try {
            Statement statement=conx.createStatement();
            ResultSet resultSet =statement.executeQuery(req);
            if(resultSet.next()){
                 reclamation.setIdReclamation(resultSet.getInt(1));
                             }
        } catch (SQLException ex) {
            System.out.println("ex"+ex);
        }
       
        System.out.println("Reclamation"+ reclamation);
        return reclamation; 
    }

    @Override
    public List<Reclamation> getAllBySender(int idSender) {
        List <Reclamation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM  Reclamation where idUserRecS = " +idSender;        
            Statement st;
            st =conx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               Reclamation r = new Reclamation (rs.getInt(1), rs.getInt("idCategorieRec"), rs.getInt("idAnnonceRec"), rs.getInt("idUserRecS"), rs.getInt("idUserRecR"),rs.getString("choiceRec"),rs.getString("descRec"),rs.getString("statusRec"),rs.getString("dateRec"));
               list.add(r);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Annonce> getAllAnnonces() {
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

    @Override
    public Annonce getOneAnonceById(int id) {
        Annonce categorie = new Annonce();
        String req="SELECT * FROM annonce where idAnnonce = " + id;
        System.out.println("req: "+req);
        System.out.println("id:" +id);
                
        try {
            Statement statement=conx.createStatement();
            ResultSet resultSet =statement.executeQuery(req);
            if(resultSet.next()){
                 categorie.setIdAnnonce(resultSet.getInt(1));
                 categorie.setDescription(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("ex"+ex);
        }
       
        System.out.println("AnnonceReclamation"+ categorie);
        return categorie; 
    }

    @Override
    public List<Reclamation> findReclamationByChoice(String choiceRec) {
        List<Reclamation> findReclamation = new ArrayList<>();
        String req = "select * from reclamation where choiceRec=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conx.prepareStatement(req);
            preparedStatement.setString(1, choiceRec);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Reclamation reclamation;
                reclamation = new Reclamation();
                reclamation.setIdReclamation(result.getInt("idReclamation"));
                reclamation.setIdCategorieRec(result.getInt("idCategorieRec"));
                reclamation.setIdAnnonceRec(result.getInt("idAnnonceRec"));
                reclamation.setIdUserRecS(result.getInt("idUserRecS"));
                reclamation.setIdUserRecR(result.getInt("idUserRecR"));
                reclamation.setChoiceRec(result.getString("choiceRec"));
                reclamation.setDescRec(result.getString("descRec"));
                reclamation.setStatusRec(result.getString("statusRec"));
                reclamation.setDateRec(result.getString("dateRec"));
                findReclamation.add(reclamation);
            }
            
        } catch (SQLException ex) {
        }
        return findReclamation;
    }

    
    
    
}
        //select * from Rcalamation wwhere sender= idSender and expired = false;        
