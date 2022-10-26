/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import entities.Reclamation;
import entities.Categorie;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AnnonceCRUD;
import services.CategorieService;
import services.CategorieServiceImpl;
import services.ReclamationService;
import services.ReclamationServiceImpl;
import services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class ListReclamationController implements Initializable {
    
    private ReclamationService reclamationServiceImpl = new ReclamationServiceImpl() {};
    private CategorieService categorieService = new CategorieServiceImpl();
    private UserCRUD userCRUD = new UserCRUD();
    
    private ObservableList<Reclamation> dataR;
    private List<Reclamation> listR = new ArrayList<Reclamation>();
    private Reclamation rowData;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Reclamation> tvReclamation;
    @FXML
    private TableColumn<Reclamation, String> tcIdReclamation;
    @FXML
    private TableColumn<Reclamation, String> tcIdAnnonceRec;
    @FXML
    private TableColumn<Reclamation, String> tcIdUserRecR;
    @FXML
    private TableColumn<Reclamation, String> tcChoiceRec;
    @FXML
    private TableColumn<Reclamation, String> tcDescRec;
    @FXML
    private TableColumn<Reclamation, String> tcDateRec;
    @FXML
    private Button btnSupprimerRec;
    @FXML
    private Button btnRetourRec;
    @FXML
    private Label labelRec;
    @FXML
    private Button btnModifierRec;
    @FXML
    private TextField tfChercher;
    @FXML
    private Button btnChercherRec;
    @FXML
    private TableColumn<Reclamation, String> tcNomCategorieRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idReclamation")); 
        tcNomCategorieRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCategorieRec")); 
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomAnnonceRec"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("dateRec"));

        listR = reclamationServiceImpl.getAllBySender(1);
        if(listR.size()!=0){
            listR.stream().forEach(r -> getLabelsToView(r));
        }
        dataR = FXCollections.observableArrayList(listR);
        tvReclamation.setItems(dataR);
        tvReclamation.setRowFactory(tv -> {
            TableRow<Reclamation> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                rowData = row.getItem();
                labelRec.setText(rowData.getChoiceRec());
            });
            return row;
        });

        /*
        ReclamationServiceImpl reclamationServiceImpl = new ReclamationServiceImpl();
        ArrayList arrayList= (ArrayList) reclamationServiceImpl.getAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tvReclamaton.setItems(observableList);
        tcIdCategorieRec.setCellValueFactory(new PropertyValueFactory<>("idCategorieRec"));
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<>("idAnnonceRec"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<>("idUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<>("descRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<>("dateRec"));
        */
    }
    
    private void getLabelsToView(Reclamation reclamation){
        Categorie categorie = categorieService.getOneById(reclamation.getIdCategorieRec());
        Annonce annonce = reclamationServiceImpl.getOneAnonceById(reclamation.getIdAnnonceRec());
        User user = userCRUD.getOneById(reclamation.getIdUserRecR());
        reclamation.setNomAnnonceRec(annonce.getDescription());
        reclamation.setNomCategorieRec(categorie.getNomCat());
        reclamation.setNomUserRecR(user.getFullName());
        System.out.println("*****"+reclamation);
    }
    
    @FXML
    private void onBtnSupprimerRecAction(ActionEvent event) {
        Integer selectedItem = rowData.getIdReclamation();
        reclamationServiceImpl.deleteReclamation(selectedItem);
        listR.remove(rowData);
        labelRec.setText("");
        dataR = FXCollections.observableArrayList(listR);
        tvReclamation.setItems(dataR);
            
        new Alert(Alert.AlertType.INFORMATION, "Réclamation supprimé avec succès").show();
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
    private void onBtnModifierRecAction(ActionEvent event) {
        Integer selectedItem = rowData.getIdReclamation();
        Reclamation reclamationToUpdate = listR.stream().filter(r->r.getIdReclamation().equals(selectedItem)).findAny().get();
        
        //bch ta3ml interface ta7t el tableau,
        // bch te5ou les donnes elli 3malthom  w bch t7othom fi reclamationToUpdate
        
        reclamationServiceImpl.updateReclamation(reclamationToUpdate);
        dataR = FXCollections.observableArrayList(listR);
        tvReclamation.setItems(dataR);
            
            new Alert(Alert.AlertType.INFORMATION, "Réclamation supprimé avec succès").show();
    }

    @FXML
    private void onBtnChercherRecAction(ActionEvent event) {
        try{
            if (tfChercher.getText().length() != 0) {
                listR = reclamationServiceImpl.findReclamationByChoice(tfChercher.getText());
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Entrer un choix !!").show();
            }
            dataR = FXCollections.observableArrayList(listR);
            tvReclamation.setItems(dataR);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
