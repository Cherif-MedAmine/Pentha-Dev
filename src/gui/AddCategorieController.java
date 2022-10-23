/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.CategorieServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class AddCategorieController implements Initializable {

    @FXML
    private TextField tfNomCat;
    @FXML
    private Button btnAddCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onBtnAddCatAction(ActionEvent event) throws IOException {
        Categorie c = new Categorie(1,tfNomCat.getText());
        CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl();
        categorieServiceImpl.createCategorie(c);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./ListCategorie.fxml"));
        Parent root;
        root=loader.load();
        btnAddCat.getScene().setRoot(root);
        
        new Alert(Alert.AlertType.INFORMATION, "Categorie ajouter avec succès").show();
    }
    
}
