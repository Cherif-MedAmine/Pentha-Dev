/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Message;
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
public class MessageCRUD implements InterfaceMessage {
    Connection connexion = MyDB.getInstance().getConnection();

    @Override
    public void ajouterMessage(Message M) {
        String req = "INSERT INTO `message`( `idDiscussionM`,`idUserS_M`,`message` , `dateMessage` ) VALUES (" +M.getIdDiscussionM()+","+M.getIdUserS_M()+",'"+M.getMessage()+"', '"+M.getDateMessage()+"')";
        Statement st  ;
        try {
        st = connexion.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
}


    
    @Override
    public void modifierMessage(Message M) {
        String req = "UPDATE `message` SET `idDiscussionM`="+M.getIdDiscussionM()+",`idUserS_M`="+M.getIdUserS_M()+", `message` = '"+M.getMessage()+"', `dateMessage` = '"+M.getDateMessage()+"' WHERE idMessage ="+ M.getIdMessage() ;
        Statement st  ;
        try {
        st = connexion.createStatement() ;
        st.executeUpdate(req) ;
        //System.out.println("Le message est modifié");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void supprimerMessage(int idMessage) {
        try {
        String req=" DELETE FROM message WHERE idMessage="+ idMessage ;

        PreparedStatement St = connexion.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

   
    @Override
    public List<Message> Afficher() {
        List <Message> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  Message";        
    Statement st;
    st =connexion.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Message M = new Message (rs.getInt(1),rs.getInt("idDiscussionM"),rs.getInt("idUserS_M"),rs.getString("message"),rs.getString("dateMessage"));
    list.add(M);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }
}


