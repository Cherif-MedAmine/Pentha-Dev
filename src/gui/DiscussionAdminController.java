/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Discussion;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.DiscussionCRUD;

/**
 * FXML Controller class
 *
 * @author Riadh Akkari
 */
public class DiscussionAdminController implements Initializable {
    
    private DiscussionCRUD discussionCRUD = new DiscussionCRUD() {};
    private ObservableList<Discussion> dataD;
    private List<Discussion> listD = new ArrayList<Discussion>();
    private Discussion rowData;

    @FXML
    private TableView<Discussion> TableDisc;
    @FXML
    private TableColumn<Discussion, String> tcIdM;
    @FXML
    private TableColumn<Discussion, String> tcIdUserS;
    @FXML
    private TableColumn<Discussion, String> tcIdUserR;
    @FXML
    private Button Supprimer;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DiscussionCRUD discussionCRUD = new DiscussionCRUD();
        ArrayList arrayList = (ArrayList) discussionCRUD.Afficher();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        TableDisc.setItems(observableList);
        tcIdM.setCellValueFactory(new PropertyValueFactory<Discussion, String>("idDiscussion"));
        tcIdUserS.setCellValueFactory(new PropertyValueFactory<Discussion, String>("idUserS"));
        tcIdUserR.setCellValueFactory(new PropertyValueFactory<Discussion, String>("idUserR"));
        listD = discussionCRUD.Afficher();
        dataD = FXCollections.observableArrayList(listD);
        TableDisc.setItems(dataD);
        
        TableDisc.setRowFactory(tv -> {
            TableRow<Discussion> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                rowData = row.getItem();
                //Supprimer.setText(rowData.getIdUserS());
            });
            return row;
        });
    } 
    
   

    @FXML
    private void btnSupprimerDisc(ActionEvent event) {
            discussionCRUD.supprimerDiscussion(rowData.getIdDiscussion());
            listD.remove(rowData);
            dataD = FXCollections.observableArrayList(listD);
            TableDisc.setItems(dataD);
    }

    
}
