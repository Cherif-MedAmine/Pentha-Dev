/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReclamationServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class ListReclamationController implements Initializable {

    @FXML
    private TableView<?> tvReclamaton;
    @FXML
    private TableColumn<?, ?> tcIdCategorieRec;
    @FXML
    private TableColumn<?, ?> tcIdAnnonceRec;
    @FXML
    private TableColumn<?, ?> tcIdUserRecR;
    @FXML
    private TableColumn<?, ?> tcChoiceRec;
    @FXML
    private TableColumn<?, ?> tcDescRec;
    @FXML
    private TableColumn<?, ?> tcDateRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    }    
    
}
