/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.CategorieService;
import services.CategorieServiceImpl;
import services.ReclamationServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class AddReclamationController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Categorie selectedCategorie;
    
    private CategorieService categorieService = new CategorieServiceImpl();

    @FXML
    private TextArea taDescRec;
    @FXML
    private Button btnEnvoyerRec;
    @FXML
    private Label labelChoiceRec;
    private TextField tfChoiceRec;
    @FXML
    private Label labelDescRec;
    @FXML
    private Button btnRetourRec;
    @FXML
    private ComboBox<?> cbChoiceRec;
    @FXML
    private ComboBox<String> cbTypeRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCategorieComoboBox();
    }    
    
    
    private void initCategorieComoboBox(){
        //get all categories from DB
        List<Categorie> categories = categorieService.getAll();
        // fill the combobox by categories fetched from DB
        categories.stream().forEach(categorie -> cbTypeRec.getItems().add(categorie.getNomCat()));
        // Action fired when select an item from the combobox
        cbTypeRec.setOnAction((event) -> {
        int selectedItem = cbTypeRec.getSelectionModel().getSelectedIndex()+1;
        //get 1 categorie from DB
        selectedCategorie = categorieService.getOneById(selectedItem);
        });
    }
    
    @FXML
    private void onBtnEnvoyerRecAction(ActionEvent event) throws IOException {
        //Reclamation r = new Reclamation(1, Integer.valueOf(tfTypeRec.getText()), 1, 1, 4, tfChoiceRec.getText(), taDescRec.getText(), "unseen", "11/10/2022");
        Reclamation r = new Reclamation(1, selectedCategorie.getIdCategorie(), 1, 1, 4, "2", taDescRec.getText(), "unseen", "11/10/2022");
        ReclamationServiceImpl reclamationServiceImpl = new ReclamationServiceImpl();
        reclamationServiceImpl.createReclamation(r);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./ListReclamation.fxml"));
        Parent root;
        root=loader.load();
        btnEnvoyerRec.getScene().setRoot(root);
        
        new Alert(Alert.AlertType.INFORMATION, "Réclamation envoyer avec succès").show();
    }

    @FXML
    private void onBtnRetourRecAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomeReclamation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
