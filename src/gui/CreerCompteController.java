/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author Oumayma Gaiech
 */
public class CreerCompteController implements Initializable {

    
    @FXML
    private Button valider;
    @FXML
    private Button Connecter;
    @FXML
    private TextField id_fullName;
    @FXML
    private TextField id_region;
    @FXML
    private TextField id_mdp;
    @FXML
    private TextField id_telephone;
    @FXML
    private TextField id_jourTravail;
    @FXML
    private TextField id_heureTravail;
    @FXML
    private TextField id_adresseAgence;
    @FXML
    private TextField id_email;
    @FXML
    private TextField id_municipalite;
    @FXML
    private ComboBox id_role;
    @FXML
    private ComboBox id_genre;
    private Parent fxml;
    private Scene scene;
    private Stage stage;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Admin" , "Simple Client","Agence" ) ;
        id_role.setItems(list);
        ObservableList<String> liste = FXCollections.observableArrayList("Femme" , "Homme") ;
        id_genre.setItems(liste);
    }    
    
          public Connection getConnection(){ 
          
          Connection conx ;
          try{
              conx = DriverManager.getConnection("jdbc:mysql://localhost:3307/immoplus") ;
              return conx ;
          }catch(SQLException ex){
              System.out.println("Error: "+ ex.getMessage());
              return null ;
          }
          
      }



    @FXML
    private void valider(ActionEvent event) {
       
    String fullName;
    String genreUser;
    String email;
    String mdp;
    String region;
     String municipalite;
    String telephone;
     String role;
     String adresseAgence;
    String jourTravail;
     String heureTravail;
     
     fullName=id_fullName.getText();
     genreUser=id_genre.getSelectionModel().getSelectedItem().toString(); 
     email=id_email.getText();
     mdp=id_mdp.getText();
     region=id_region.getText();
     municipalite=id_municipalite.getText();
     telephone=id_telephone.getText();
     role=id_role.getSelectionModel().getSelectedItem().toString(); 
     adresseAgence=id_adresseAgence.getText();
     jourTravail=id_jourTravail.getText();
     heureTravail=id_heureTravail.getText();
     
     if(id_fullName.getText().isEmpty() || id_email.getText().isEmpty() ||id_mdp.getText().isEmpty() || id_region.getText().isEmpty() || id_municipalite.getText().isEmpty() || id_telephone.getText().isEmpty() || id_adresseAgence.getText().isEmpty() || id_jourTravail.getText().isEmpty() || id_heureTravail.getText().isEmpty())
     {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Veuillez remplir tous les champs");
             alert.showAndWait();
     }
     else
        {
            User U1 = new User (fullName,genreUser,email,mdp,region,municipalite,telephone,role,adresseAgence,jourTravail,heureTravail);
            UserCRUD uc= new UserCRUD () ;
            uc.ajouterUser(U1);
        
        JOptionPane.showMessageDialog(null,"Succés de création ");
        }
    }

 @FXML
    private void butt_conn(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentification.fxml"));
             fxml=loader.load(); 
             stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             scene=new Scene((Parent) fxml);
             stage.setScene(scene);
             stage.centerOnScreen();
             stage.show(); 
    }
}
    

   
    

