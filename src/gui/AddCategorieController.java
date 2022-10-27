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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.CategorieServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class AddCategorieController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfNomCat;
    @FXML
    private Button btnAddCat;
    @FXML
    private Button btnRetourCat;
    @FXML
    private Button btnGererCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onBtnAddCatAction(ActionEvent event) throws IOException {
        if (tfNomCat.getText().length() != 0) {
            Categorie c = new Categorie(1,tfNomCat.getText());
            CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl();
            categorieServiceImpl.createCategorie(c);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./ListCategorie.fxml"));
            Parent root;
            root=loader.load();
            btnAddCat.getScene().setRoot(root);
        
            new Alert(Alert.AlertType.INFORMATION, "Categorie ajouter avec succès").show();
        }else {
                new Alert(Alert.AlertType.INFORMATION, "Entrer un nom !!").show();
        }
    }

    @FXML
    private void onBtnRetourCatAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TestAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onBtnGererCatAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ListCategorie.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
