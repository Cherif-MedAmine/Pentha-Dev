/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ReclamationServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class ListReclamationAdminController implements Initializable {
    
    private ReclamationServiceImpl reclamationServiceImpl = new ReclamationServiceImpl() {};
    private ObservableList<Reclamation> dataR;
    private List<Reclamation> listR = new ArrayList<Reclamation>();
    private Reclamation rowData;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Reclamation> tvReclamaton;
    @FXML
    private TableColumn<Reclamation, String> tcIdReclamation;
    @FXML
    private TableColumn<Reclamation, String> tcIdCategorieRec;
    @FXML
    private TableColumn<Reclamation, String> tcIdAnnonceRec;
    @FXML
    private TableColumn<Reclamation, String> tcIdUserRecS;
    @FXML
    private TableColumn<Reclamation, String> tcIdUserRecR;
    @FXML
    private TableColumn<Reclamation, String> tcChoiceRec;
    @FXML
    private TableColumn<Reclamation, String> tcDescRec;
    @FXML
    private TableColumn<Reclamation, String> tcStatusRec;
    @FXML
    private TableColumn<Reclamation, String> tcDateRec;
    @FXML
    private Button btnSupprimerRec;
    @FXML
    private Button btnRetourRec;
    @FXML
    private Label labelRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idReclamation")); 
        tcIdCategorieRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idCategorieRec"));
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idAnnonceRec"));
        tcIdUserRecS.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idUserRecS"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descRec"));
        tcStatusRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("statusRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("dateRec"));
        listR = reclamationServiceImpl.getAll();
        dataR = FXCollections.observableArrayList(listR);
        tvReclamaton.setItems(dataR);
        tvReclamaton.setRowFactory(tv -> {
            TableRow<Reclamation> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                rowData = row.getItem();
                labelRec.setText(rowData.getChoiceRec());
            });
            return row;
        });
        
        /*ReclamationServiceImpl reclamationServiceImpl = new ReclamationServiceImpl();
        ArrayList arrayList= (ArrayList) reclamationServiceImpl.getAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tvReclamaton.setItems(observableList);
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<>("idReclamation"));
        tcIdCategorieRec.setCellValueFactory(new PropertyValueFactory<>("idCategorieRec"));
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<>("idAnnonceRec"));
        tcIdUserRecS.setCellValueFactory(new PropertyValueFactory<>("idUserRecS"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<>("idUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<>("descRec"));
        tcStatusRec.setCellValueFactory(new PropertyValueFactory<>("statusRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<>("dateRec"));*/
    }    

    @FXML
    private void onBtnSupprimerRecAction(ActionEvent event) {
        reclamationServiceImpl.deleteReclamation(rowData.getIdReclamation());
        listR.remove(rowData);
        labelRec.setText("");
        dataR = FXCollections.observableArrayList(listR);
        tvReclamaton.setItems(dataR);
        
        new Alert(Alert.AlertType.INFORMATION, "Reclamation supprimé avec succès").show();
    }

    @FXML
    private void onBtnRetourRecAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TestAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
