/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import entities.Categorie;
import entities.Reclamation;
import entities.User;
import java.io.IOException;
import java.net.URL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import services.InterfaceUser;
import services.ReclamationService;
import services.ReclamationServiceImpl;
import services.UserCRUD;

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
    int selectedItem = 0;
    
    private CategorieService categorieService = new CategorieServiceImpl();
    
    private ReclamationService reclamationService = new ReclamationServiceImpl();
    
    private InterfaceUser interfaceUser = new UserCRUD();

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
    private ComboBox<String> cbChoiceRec;
    @FXML
    private ComboBox<String> cbTypeRec;
    @FXML
    private Label labelRec;
    @FXML
    private ComboBox<String> cbRec;
    
    HashMap<Integer, String> map = new HashMap<>(); 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCategorieComoboBox();
        labelRec.setVisible(false);    
        cbChoiceRec.setVisible(false);
        labelChoiceRec.setVisible(false);
        cbRec.setVisible(false);
        btnEnvoyerRec.setDisable(true);
        
       
       
        boolean isValid = cbTypeRec.getItems().isEmpty() || cbChoiceRec.getItems().isEmpty()  ;
        System.out.println("********************"+ cbTypeRec.getItems().isEmpty());
        if(isValid) 
        btnEnvoyerRec.setDisable(false);
        
    }
    
    private void initCategorieComoboBox(){
        //get all categories from DB
        List<Categorie> categories = categorieService.getAll();
        // fill the combobox by categories fetched from DB
        categories.stream().forEach(categorie -> cbTypeRec.getItems().add(categorie.getNomCat()));
    }
    
    @FXML
    private void onBtnEnvoyerRecAction(ActionEvent event) throws IOException {
        //Reclamation r = new Reclamation(1, Integer.valueOf(tfTypeRec.getText()), 1, 1, 4, tfChoiceRec.getText(), taDescRec.getText(), "unseen", "11/10/2022");
        Integer idAnnonceRec = null;
        Integer idUserRecR = null;
        String choice = map.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
        int selectedCbRec = cbRec.getSelectionModel().getSelectedIndex()+1;
        
        System.out.println("choice   "+choice);
        System.out.println("cbChoiceRec.getSelectionModel()"+selectedCbRec);
        //System.out.println("choice: "+choice);
        
        if (selectedItem == 1){
            idAnnonceRec = reclamationService.getOneAnonceById(selectedCbRec).getIdAnnonce();
            //choice = map.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
            System.out.println("cbRec.getSelectionModel().getSelectedIndex(): "+cbRec.getSelectionModel().getSelectedIndex());
            System.out.println("idAnnonceRec"+idAnnonceRec);
        }
        if (selectedItem == 2){
            idUserRecR = interfaceUser.getOneById(cbRec.getSelectionModel().getSelectedIndex()).getIdUser();
            //choice = mapCompte.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
            System.out.println("idUserRecR"+idUserRecR);   
        }
            System.out.println("selectedCategorie "+selectedCategorie);
            System.out.println("taDescRec "+taDescRec.getText());
            DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDateTime now = LocalDateTime.now(); 
            Reclamation r = new Reclamation()
                .idReclamation(1)
                .idCategorieRec(selectedCategorie.getIdCategorie())
                .idAnnonceRec(idAnnonceRec)
                .idUserRecS(1)  // User connected
                .idUserRecR(idUserRecR)
                .choiceRec(choice)
                .descRec(taDescRec.getText())
                .statusRec("unseen")
                .dateRec(now.toString())
                ;
        System.out.println("reclamation***"+r);
            
        btnEnvoyerRec.setDisable(false);
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

    @FXML
    private void onTypeRecAction(ActionEvent event) {
        selectedItem = cbTypeRec.getSelectionModel().getSelectedIndex()+1;
        //get 1 categorie from DB
        selectedCategorie = categorieService.getOneById(selectedItem);
        if (selectedItem == 1){
            cbChoiceRec.getItems().clear();
            
            map.put(1, "Suspect(e)");
            map.put(2, "Non réel(le)");
            map.put(3, "Arnaqueur(se)");
            map.put(3, "Autre");
            
            map.entrySet().forEach(c -> cbChoiceRec.getItems().add(c.getValue()));

            List<Annonce> listeAnnonce = reclamationService.getAllAnnonces();
            //reset combo
            cbRec.getItems().clear();
            listeAnnonce.stream().forEach(annonce -> cbRec.getItems().add(annonce.getDescription()));
            System.out.println("listeAnnonce: "+listeAnnonce);
            cbRec.setVisible(true);
            labelRec.setVisible(true);
            labelRec.setText("Choisir l'annonce à réclamer *");
            labelChoiceRec.setVisible(true);
            cbChoiceRec.setVisible(true);
        }
        if (selectedItem == 2){
            cbChoiceRec.getItems().clear();
            
            map.put(1, "c1");
            map.put(2, "c2");
            map.put(3, "c3");
            map.put(3, "C4");
            
            map.entrySet().forEach(c -> cbChoiceRec.getItems().add(c.getValue()));

            List<User> listeUser = interfaceUser.Afficher();
            //reset combo
            cbRec.getItems().clear();
            //cbChoiceRec.getItems().clear();
            listeUser.stream().forEach(user -> cbRec.getItems().add(user.getFullName()));
            //System.out.println("listeAnnonce: "+listeAnnonce);
            cbRec.setVisible(true);
            labelRec.setVisible(true);
            labelRec.setText("Choisir l'utilisateur à réclamer *");
            labelChoiceRec.setVisible(true);
            cbChoiceRec.setVisible(true);
            /*map.entrySet().forEach(c -> cbChoiceRec.getItems().add(c.getValue()));
            List<User> listeUser = interfaceUser.Afficher();
            cbRec.getItems().removeAll();
            cbRec.valueProperty().set(null);
            listeUser.stream().forEach(user -> cbRec.getItems().add(user.getFullName()));
            System.out.println("listeUser:"+listeUser);
            cbRec.setVisible(true);
            labelRec.setVisible(true);
            labelRec.setText("Choisir l'utilisateur à réclamer *");*/
        }
        if(selectedItem == 3){
            cbRec.setVisible(false);
            labelRec.setVisible(false);
            labelChoiceRec.setVisible(false);
            cbChoiceRec.setVisible(false);         
        }
        
    } 
}
