/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package services;
import entities.Discussion;
import entities.Message;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
/**
 *
 * @author Riadh Akkari
 */   
    public class DiscussionCRUD implements InterfaceDiscussion {
        Connection connexion = MyDB.getInstance().getConnection();

    public DiscussionCRUD() {
    }

    
        @Override
        public int ajouterDiscussion(Discussion D) {
            
        String req = "INSERT INTO `discussion` (`idUserS`,`idUserR`) VALUES (" +D.getIdUserS()+ "," +D.getIdUserR()+")";
        PreparedStatement ps  ;
        System.err.println(req);
        
        
            try {
                ps = connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
                
                int affectedRows = ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();            
            if (generatedKeys.next()) {
               return (int) generatedKeys.getLong(1); 
               
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            } catch (SQLException ex) {
                Logger.getLogger(DiscussionCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
            
           
        
    
    }

    @Override
    public void supprimerDiscussion(int idDiscussion) {
                try {
        String req=" DELETE FROM discussion WHERE idDiscussion="+ idDiscussion ;

        PreparedStatement St = connexion.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

    @Override
    public List<Discussion> Afficher() {
        List <Discussion> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM  Discussion";
            Statement st;
            st =connexion.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Discussion D = new Discussion (rs.getInt("idDiscussion"), rs.getInt("idUserS"), rs.getInt("idUserR"));
                list.add(D);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Discussion> AfficherDiscussionByIdUserS(int idUserS) {
        List <Discussion> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM  Discussion where idUserS='" +idUserS +"'";
            Statement st;
            st =connexion.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Discussion D = new Discussion (rs.getInt("idDiscussion"), rs.getInt("idUserS"), rs.getInt("idUserR"));
                list.add(D);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void modifierDiscussion(Discussion D) {
        String req = "UPDATE `discussion` SET `idUserS`="+D.getIdUserS()+",`idUserR`="+D.getIdUserR()+" WHERE idDiscussion="+D.getIdDiscussion();
        Statement st  ;
        try {
        st = connexion.createStatement() ;
        st.executeUpdate(req) ; 
        System.out.println("La discussion est modifié");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<Discussion> AfficherDiscussionByIdUser(int idUserS) {
        List <Discussion> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM  Discussion where idUserS='" +idUserS+"'";
            Statement st;
            st =connexion.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Discussion D = new Discussion (rs.getInt("idDiscussion"), rs.getInt("idUserS"), rs.getInt("idUserR"));
                list.add(D);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
   }

    @Override
    public List<Discussion> AfficherDiscussionByIdUserR(int id) {
        List <Discussion> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `discussion` WHERE '" +id+ "' in (idUserS,idUserR)"; 
            Statement st;
            st =connexion.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Discussion D = new Discussion (rs.getInt("idDiscussion"), rs.getInt("idUserS"), rs.getInt("idUserR"));
                list.add(D);
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
    }
