/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
    /*
    @Override
    public Reclamation getOneById(int idRcalmation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reclamation> getAllBySender(int idSender) {
        // get all sender's recalmation where the reclamation are not expired yet.
        //select * from Rcalamation wwhere sender= idSender and expired = false;        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
}
