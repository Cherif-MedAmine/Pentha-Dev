/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import entities.Categorie;
import utils.MyDB;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author AJ
 */
public class CategorieServiceImpl implements CategorieService{
    Connection conx = MyDB.getInstance().getConnection();
    
    
    @Override
    public void createCategorie(Categorie C) {
        String req = "INSERT INTO `categorie`( `nomCat`) VALUES ('" +C.getNomCat()+ "')" ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void updateCategorie(Categorie C) {
       String req = "UPDATE `categorie` SET `nomCat`='"+C.getNomCat()+"' WHERE idCategorie ="+ C.getIdCategorie() ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("La Categorie est modifier");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public void deleteCategorie(int idCategorie) {

    try {
        String req=" DELETE FROM categorie WHERE idCategorie="+ idCategorie ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

    @Override
    public List<Categorie> getAll() {

    List <Categorie> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  Categorie";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Categorie c = new Categorie (rs.getInt(1), rs.getString("nomCat"));
    list.add(c);
              }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    return list;
    }
    
    
    
}
