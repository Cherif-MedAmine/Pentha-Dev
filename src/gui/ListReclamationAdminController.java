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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.CategorieService;
import services.CategorieServiceImpl;
import services.ReclamationService;
import services.ReclamationServiceImpl;
import services.UserCRUD;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.*;
import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
/**
 * FXML Controller class
 *
 * @author AJ
 */
public class ListReclamationAdminController implements Initializable {
    
    private ReclamationService reclamationServiceImpl = new ReclamationServiceImpl();
    private CategorieService categorieService = new CategorieServiceImpl();
    private UserCRUD userCRUD = new UserCRUD();
    
    private ObservableList<Reclamation> dataR;
    private List<Reclamation> listR = new ArrayList<Reclamation>();
    private Reclamation rowData;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Stage stageD;

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
    @FXML
    private Button btnEnvoyerMail;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextArea taMessage;
    @FXML
    private Button btnEnvoyerSMS;
    @FXML
    private Button btnDiagramme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcIdReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("idReclamation")); 
        tcIdCategorieRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomCategorieRec"));
        tcIdAnnonceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomAnnonceRec"));
        tcIdUserRecS.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomUserRecS"));
        tcIdUserRecR.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomUserRecR"));
        tcChoiceRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("choiceRec"));
        tcDescRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descRec"));
        tcStatusRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("statusRec"));
        tcDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("dateRec"));
        listR = reclamationServiceImpl.getAll();
        if(listR.size()!=0){
            listR.stream().forEach(r -> getLabelsToView(r));
        }
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

    private void getLabelsToView(Reclamation reclamation){
        Categorie categorie = categorieService.getOneById(reclamation.getIdCategorieRec());
        Annonce annonce = reclamationServiceImpl.getOneAnonceById(reclamation.getIdAnnonceRec());
        User userS = userCRUD.getOneById(reclamation.getIdUserRecS());
        User userR = userCRUD.getOneById(reclamation.getIdUserRecR());
        reclamation.setNomCategorieRec(categorie.getNomCat());
        reclamation.setNomAnnonceRec(annonce.getDescription());
        reclamation.setNomUserRecS(userS.getFullName());
        reclamation.setNomUserRecR(userR.getFullName());
        System.out.println("*****"+reclamation);
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

    @FXML
    private void onBtnEnvoyerMailAction(ActionEvent event) {
        
        
        
        String ToEmail = "riadh.akkari@esprit.tn";
        String FromEmail = "ahmed.jebalia@esprit.tn";
        String FromEmailPassword = "one7890one789";
        String Sujet = tfSujet.getText();
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "stmp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(FromEmail, FromEmailPassword);
           }
        });
        try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(FromEmail));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
           message.setSubject(Sujet);
           message.setText(taMessage.getText());
           Transport.send(message);
        } catch (MessagingException e) {
            System.out.println(""+e);
        }
        
    }

    @FXML
    private void onBtnEnvoyerSMSAction(ActionEvent event) throws UnsupportedEncodingException, MalformedURLException, IOException {
        RestClient client = new RestClient("<USERNAME>", "<APIV2_TOKEN>");

    TMNewMessage m = client.getResource(TMNewMessage.class);
    m.setText("Hello from TextMagic Java");
    m.setPhones(Arrays.asList(new String[] {"25259644"}));
    try {
      m.send();
    } catch (final RestException e) {
      System.out.println(e.getErrors());
      throw new RuntimeException(e);
    }
    System.out.println(m.getId());
    }

    @FXML
    private void onBtnDiagrammeAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
