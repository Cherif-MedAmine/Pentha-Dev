package services;

import entities.Reclamation;
import entities.User;
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
 * @author Oumayma Gaiech
 */
public class UserCRUD implements InterfaceUser{
    Connection conx = MyDB.getInstance().getConnection();

    @Override
    public void ajouterUser(User U) {
             String req ="INSERT INTO `user`(`fullName`,`genreUser`,`email`,`mdp`,`region`,`municipalite`,`telephone`,`role`,`adresseAgence`,`jourTravail`,`heureTravail`)VALUES ('"+U.getFullName()+"'," +U.getGenreUser()+",'"+U.getEmail()+"','"+U.getMdp()+"','"+U.getRegion()+"','"+U.getMunicipalite()+"','"+U.getTelephone()+"','"+U.getRole()+"','"+U.getAdresseAgence()+"','"+U.getJourTravail()+"','"+U.getHeureTravail()+"')";
              Statement st ;
              try {
              st = conx.createStatement() ;
              st.executeUpdate(req) ;
              System.out.println("L'utilisateur est ajouté");}
              
               catch (SQLException ex) {
                System.err.println(ex.getMessage());
        }
        
    }
        @Override
    public void supprimerUser(int idUser) {

    try {
        String req=" DELETE FROM user WHERE idUser="+ idUser ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
        System.out.println("L'utilisateur est supprimé");}
     catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    }
     @Override 
    public void modifierUser(User U) {
       String req = "UPDATE `user` SET `fullName`='"+U.getFullName()+"',`genreUser`='"+U.getGenreUser()+"',`email`='"+U.getEmail()+"',`mdp`='"+U.getMdp()+"',`region`='"+U.getRegion()+"',`municipalite`='"+U.getMunicipalite()+"',`telephone`='"+U.getTelephone()+"',`role`='"+U.getRole()+"',`adresseAgence`='"+U.getAdresseAgence()+"',`jourTravail`='"+U.getJourTravail()+"',`heureTravail`='"+U.getHeureTravail()+"' WHERE idUser ="+U.getIdUser() ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("L'utilisateur est modifié");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public List<User> Afficher() {

    List <User> list = new ArrayList<>();
        try {
    String req = "SELECT * FROM  User";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    System.out.println("L'utilisateur est affiché");
    while(rs.next()){
    User u = new User (rs.getInt(1), rs.getString("fullname"),rs.getInt("genreUser"), rs.getString("email"),rs.getString("mdp"),rs.getString("region"),rs.getString("municipalite"),rs.getString("telephone"),rs.getString("role"),rs.getString("adresseAgence"),rs.getString("jourTravail"), rs.getString("heureTravail"));
    list.add(u);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }  

    @Override
    public User getOneById(int id) {
   User user = new User();
        String req="SELECT * FROM User where idUser = " + id;
        System.out.println("req: "+req);
        System.out.println("id:" +id);
                
        try {
            Statement statement=conx.createStatement();
            ResultSet resultSet =statement.executeQuery(req);
            if(resultSet.next()){
                 user.setIdUser(resultSet.getInt(1));
                 user.setFullName(resultSet.getString(2));
                             }
        } catch (SQLException ex) {
            System.out.println("ex"+ex);
        }
       
        System.out.println("User"+ user);
        return user;     }
}