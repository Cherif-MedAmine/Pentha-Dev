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
        String req = "INSERT INTO `reclamation`( `idCategorieRec`, `idAnnonceRec`, `idUserRec`, `idUserSRec`, `objet`, `textRec`, `statusRec`) VALUES (" +R.getIdCategorieRec()+ "," +R.getIdAnnonceRec()+ "," +R.getIdUserRec()+ "," +R.getIdUserSRec()+ ",'" +R.getObjet()+ "','" +R.getTextRec()+ "','" +R.getStatusRec()+ "')" ;
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
        
        String req = "UPDATE `reclamation` SET `idCategorieRec`="+R.getIdCategorieRec()+",`idAnnonceRec`="+R.getIdAnnonceRec()+",`idUserRec`="+R.getIdUserRec()+",`idUserSRec`="+R.getIdUserSRec()+",`objet`='"+R.getObjet()+"',`textRec`='"+R.getTextRec()+"',`statusRec`='"+R.getStatusRec()+"' WHERE idReclamation ="+ R.getIdReclamation() ;
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
                Reclamation r = new Reclamation (rs.getInt(1), rs.getInt("idCategorieRec"), rs.getInt("idAnnonceRec"), rs.getInt("idUserRec"), rs.getInt("idUserSRec"),rs.getString("objet"),rs.getString("textRec"),rs.getString("statusRec"));
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
