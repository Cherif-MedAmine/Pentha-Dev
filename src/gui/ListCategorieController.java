/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import services.CategorieService;
import services.CategorieServiceImpl;

/**
 * FXML Controller class
 *
 * @author AJ
 */
public class ListCategorieController implements Initializable {
    
    private CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl() {};
    private ObservableList<Categorie> dataC;
    private List<Categorie> listC = new ArrayList<Categorie>();
    private Categorie rowData;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Categorie> tvCat;
    @FXML
    private TableColumn<Categorie, String> tcID;
    @FXML
    private TableColumn<Categorie, String> tcNomCat;
    @FXML
    private Button btnSupprimerCat;
    @FXML
    private Label labelCat;
    @FXML
    private Button btnRetourCat;
    @FXML
    private TextField tfChercher;
    @FXML
    private Button btnChercherCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory<Categorie, String>("idCategorie")); 
        tcNomCat.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nomCat"));
        
        listC = categorieServiceImpl.getAll();
        dataC = FXCollections.observableArrayList(listC);
        tvCat.setItems(dataC);
        tvCat.setRowFactory(tv -> {
            TableRow<Categorie> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                rowData = row.getItem();
                labelCat.setText(rowData.getNomCat());
            });
            return row;
        });
        /*
        CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl();
        ArrayList arrayList= (ArrayList) categorieServiceImpl.getAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tvCat.setItems(observableList);
        tcID.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        tcNomCat.setCellValueFactory(new PropertyValueFactory<>("nomCat"));
         */
    }    

    @FXML
    private void onBtnSupprimerCatAction(ActionEvent event) {
            categorieServiceImpl.deleteCategorie(rowData.getIdCategorie());
            listC.remove(rowData);
            labelCat.setText("");
            dataC = FXCollections.observableArrayList(listC);
            tvCat.setItems(dataC);
            
            new Alert(Alert.AlertType.INFORMATION, "Categorie supprimé avec succès").show();
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
    private void onBtnChercherCatAction(ActionEvent event) {
        try{
            if (tfChercher.getText().length() != 0) {
                listC = categorieServiceImpl.findCategorieByName(tfChercher.getText());
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Entrer un nom !!").show();
            }
            dataC = FXCollections.observableArrayList(listC);
            tvCat.setItems(dataC);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
