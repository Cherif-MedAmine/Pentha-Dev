/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package services;
import entities.Discussion;
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
 * @author Riadh Akkari
 */   
    public class DiscussionCRUD implements InterfaceDiscussion {
        Connection connexion = MyDB.getInstance().getConnection();

    
        @Override
        public void ajouterDiscussion(Discussion D) {
        String req = "INSERT INTO `discussion` (`idUserS`,`idUserR`) VALUES (" +D.getIdUserS()+ "," +D.getIdUserR()+")";
        Statement st  ;
        try {
        st = connexion.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    
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
                Discussion D = new Discussion (rs.getInt(1), rs.getInt("idUserS"), rs.getInt("idUserR"));
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

   }
