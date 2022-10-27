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
import static java.sql.Types.NULL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AnnonceCRUD;
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
public class ListReclamationController implements Initializable {
    
    private Categorie selectedCategorie;
    int selectedItem = 0;
    
    private ReclamationService reclamationService = new ReclamationServiceImpl();
    
    private InterfaceUser interfaceUser = new UserCRUD();
    
    private ReclamationService reclamationServiceImpl = new ReclamationServiceImpl() {};
    private CategorieService categorieService = new CategorieServiceImpl();
    private UserCRUD userCRUD = new UserCRUD();
    
    private ObservableList<Reclamation> dataR;
    private List<Reclamation> listR = new ArrayList<Reclamation>();
    private Reclamation rowData;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    String selectedStatus;

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
    @FXML
    private Label labelSeen;
    @FXML
    private Button btnEnvoyerRec;
    @FXML
    private TextArea taDescRec;
    @FXML
    private Label labelChoiceRec;
    @FXML
    private Label labelDescRec;
    @FXML
    private ComboBox<String> cbTypeRec;
    @FXML
    private ComboBox<String> cbChoiceRec;
    @FXML
    private Label labelRec1;
    @FXML
    private ComboBox<String> cbRec;
    
    HashMap<Integer, String> map = new HashMap<>();
    @FXML
    private Label labelTypeRec;
    @FXML
    private Label labelChampRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initCategorieComoboBox();
        labelTypeRec.setVisible(false);    
        cbTypeRec.setVisible(false);
        labelRec1.setVisible(false);    
        cbChoiceRec.setVisible(false);
        labelChoiceRec.setVisible(false);
        cbRec.setVisible(false);
        btnEnvoyerRec.setVisible(false);
        btnEnvoyerRec.setDisable(true);
        taDescRec.setVisible(false);
        labelDescRec.setVisible(false);
        labelChampRec.setVisible(false);        
        
        
        
        boolean isValid = cbTypeRec.getItems().isEmpty() || cbChoiceRec.getItems().isEmpty()  ;
        System.out.println("********************"+ cbTypeRec.getItems().isEmpty());
        if(isValid) 
        btnEnvoyerRec.setDisable(false);
        
        //String selectedStatus = rowData.getStatusRec();
        //System.out.println("selected Status: "+selectedStatus);
        
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idReclamation")); 
        tcNomCategorieRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCategorieRec")); 
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomAnnonceRec"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("dateRec"));

        listR = reclamationServiceImpl.getAllBySender(1); // User connected 
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
                selectedStatus = rowData.getStatusRec();
                if(selectedStatus.equals("seen")){
                    labelSeen.setText("*Cette réclamation a été répondue par l'administrateur");
                    btnModifierRec.setVisible(false);
                }else{
                    labelSeen.setText("");
                    btnModifierRec.setVisible(true);
                }
                System.out.println("selected Status: "+selectedStatus);
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
    public void initTable(){
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idReclamation")); 
        tcNomCategorieRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCategorieRec")); 
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomAnnonceRec"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("dateRec"));

        listR = reclamationServiceImpl.getAllBySender(1); // User connected 
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
                selectedStatus = rowData.getStatusRec();
                System.out.println("selected Status: "+selectedStatus);
            });
            return row;
        });
        
    }
    
    private void initCategorieComoboBox(){
        //get all categories from DB
        List<Categorie> categories = categorieService.getAll();
        // fill the combobox by categories fetched from DB
        categories.stream().forEach(categorie -> cbTypeRec.getItems().add(categorie.getNomCat()));
    }
    
    /*private void onTypeRecAction(ActionEvent event) {
        selectedStatus = rowData.getStatusRec();
        System.out.println("selected Status: "+selectedStatus);
    }*/
    
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
        btnEnvoyerRec.setVisible(true);
        labelTypeRec.setVisible(true);    
        cbTypeRec.setVisible(true);
        taDescRec.setVisible(true);
        labelDescRec.setVisible(true);
        labelChampRec.setVisible(true);
        
        /*Integer selectedItem = rowData.getIdReclamation();
        Reclamation reclamationToUpdate = listR.stream().filter(r->r.getIdReclamation().equals(selectedItem)).findAny().get();
        
        //bch ta3ml interface ta7t el tableau,
        // bch te5ou les donnes elli 3malthom  w bch t7othom fi reclamationToUpdate
        
        reclamationServiceImpl.updateReclamation(reclamationToUpdate);
        dataR = FXCollections.observableArrayList(listR);
        tvReclamation.setItems(dataR);
        */
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

    @FXML
    private void onBtnEnvoyerRecAction(ActionEvent event) {
        Integer idAnnonceRec = null;
        Integer idUserRecR = null;
        String choice = map.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
        
        
        System.out.println("cbChoiceRec.getSelectionModel()"+cbChoiceRec.getSelectionModel());
        //System.out.println("choice: "+choice);
        
        if (selectedItem == 1){
            idAnnonceRec = reclamationService.getOneAnonceById(cbRec.getSelectionModel().getSelectedIndex()+1).getIdAnnonce();
            //choice = map.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
            System.out.println("idAnnonceRec"+idAnnonceRec);
        }
        if (selectedItem == 2){
            idUserRecR = interfaceUser.getOneById(cbRec.getSelectionModel().getSelectedIndex()+1).getIdUser();
            //choice = map2.get(cbChoiceRec.getSelectionModel().getSelectedIndex()+1);
            System.out.println("idUserRecR"+idUserRecR);   
        }
            System.out.println("selectedCategorie "+selectedCategorie);
            System.out.println("taDescRec "+taDescRec.getText());
            DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDateTime now = LocalDateTime.now(); 
            Reclamation r = new Reclamation()
                .idReclamation(rowData.getIdReclamation())
                .idCategorieRec(selectedCategorie.getIdCategorie())
                .idAnnonceRec(idAnnonceRec)
                .idUserRecS(1)  // User connected
                .idUserRecR(idUserRecR)
                .choiceRec(choice)
                .descRec(taDescRec.getText())
                .statusRec("unseen")
                .dateRec(now.toString())
                ;
        System.out.println("reclamation"+r);
            
        btnEnvoyerRec.setVisible(true);
        ReclamationServiceImpl reclamationServiceImpl = new ReclamationServiceImpl();
        reclamationServiceImpl.updateReclamation(r);
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("./ListReclamation.fxml"));
        Parent root;
        root=loader.load();
        btnEnvoyerRec.getScene().setRoot(root);*/
        
        new Alert(Alert.AlertType.INFORMATION, "Réclamation modifier avec succès").show();
        
        labelTypeRec.setVisible(false);    
        cbTypeRec.setVisible(false);
        labelRec1.setVisible(false);    
        cbChoiceRec.setVisible(false);
        labelChoiceRec.setVisible(false);
        cbRec.setVisible(false);
        btnEnvoyerRec.setVisible(false);
        btnEnvoyerRec.setDisable(true);
        taDescRec.setVisible(false);
        labelDescRec.setVisible(false);
        labelChampRec.setVisible(false);
        
        initTable();
        
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
            labelRec1.setVisible(true);
            labelRec1.setText("Choisir l'annonce à réclamer *");
            labelChoiceRec.setVisible(true);
            cbChoiceRec.setVisible(true);
        }
        if (selectedItem == 2){
            cbChoiceRec.getItems().clear();
            
            map.put(1, "C1");
            map.put(2, "C2");
            map.put(3, "C3");
            map.put(4, "C4");
            
            map.entrySet().forEach(c -> cbChoiceRec.getItems().add(c.getValue()));

            List<User> listeUser = interfaceUser.Afficher();
            //reset combo
            cbRec.getItems().clear();
            //cbChoiceRec.getItems().clear();
            listeUser.stream().forEach(user -> cbRec.getItems().add(user.getFullName()));
            //System.out.println("listeAnnonce: "+listeAnnonce);
            cbRec.setVisible(true);
            labelRec1.setVisible(true);
            labelRec1.setText("Choisir l'utilisateur à réclamer *");
            labelChoiceRec.setVisible(true);
            cbChoiceRec.setVisible(true);
            /*map.entrySet().forEach(c -> cbChoiceRec.getItems().add(c.getValue()));
            List<User> listeUser = interfaceUser.Afficher();
            cbRec.getItems().removeAll();
            cbRec.valueProperty().set(null);
            listeUser.stream().forEach(user -> cbRec.getItems().add(user.getFullName()));
            System.out.println("listeUser:"+listeUser);
            cbRec.setVisible(true);
            labelRec1.setVisible(true);
            labelRec1.setText("Choisir l'utilisateur à réclamer *");*/
        }
        if(selectedItem == 3){
            cbRec.setVisible(false);
            labelRec1.setVisible(false);
            labelChoiceRec.setVisible(false);
            cbChoiceRec.setVisible(false);         
        }
    }
    
}
