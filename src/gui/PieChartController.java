/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.ReclamationService;
import services.ReclamationServiceImpl;
/**
 * FXML Controller class
 *
 * @author AJ
 */
public class PieChartController implements Initializable {
    
    private ReclamationService reclamationService = new ReclamationServiceImpl();
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private PieChart pieChart;
    @FXML
    private Button btnRetourPie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int annonce = reclamationService.countAnnonceCategorie();
        int compte = reclamationService.countCompteCategorie();
        int autre = reclamationService.countAutreCategorie();
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Annonce", annonce),
                new PieChart.Data("Compte", compte),
                new PieChart.Data("Autre", autre));
        pieChart.setData(pieChartData);
    }    

    @FXML
    private void onBtnRetourPieAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ListReclamationAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
