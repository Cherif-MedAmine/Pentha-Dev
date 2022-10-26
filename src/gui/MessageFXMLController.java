
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Discussion;
import entities.Message;
import entities.User;
import java.net.URL;
import java.sql.Date;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import services.DiscussionCRUD;
import services.InterfaceDiscussion;
import services.InterfaceMessage;
import services.InterfaceUser;
import services.MessageCRUD;
import services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author Riadh Akkari
 */
public class MessageFXMLController implements Initializable {
    
    
    
    private DiscussionCRUD discussionCRUD = new DiscussionCRUD() {};
    private ObservableList<Discussion> dataD;
    private List<Discussion> listD = new ArrayList<Discussion>();
    private Discussion rowData;
    
    private MessageCRUD messageCRUD = new MessageCRUD() {};
    private ObservableList<Message> dataS;
    private ObservableList<Message> dataR;
    private List<Message> listS = new ArrayList<Message>();
    private List<Message> listR = new ArrayList<Message>();
    private Message rowDataS;
    private Message rowDataR;
    
    public static int idDiscussion;
    private Discussion selectedDiscussion;
    @FXML
    public TextField txtMessage;
    @FXML
    public TextField txtSearch;
    @FXML
    private Label labelNomPrenom;
    private Label labelNomPrenom1;
    
    
    private InterfaceUser UserService = new UserCRUD();
    private InterfaceDiscussion discussionService = new DiscussionCRUD();
    private InterfaceMessage messageService = new MessageCRUD();
    public static User userconnected = new User(1,"oumayma");
    //@FXML
    //private TableView<?> tvDisc;
    //@FXML
    //private TableColumn<?, ?> tcDisc;
    @FXML
    private TableView<Discussion> tableDiscussions;
    @FXML
    private TableColumn<Discussion, String> tcDiscussion;
    @FXML
    private TableView<Message> TableR;
    @FXML
    private TableColumn<Message, String> Receiver;
    @FXML
    private TableColumn<Message, String> Sender;
    @FXML
    private TableView<Message> TableS;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        List<Discussion> arraylist = discussionService.AfficherDiscussionByIdUserR(1); //id user sender!!!
        ObservableList observableList = FXCollections.observableArrayList(arraylist);
        tableDiscussions.setItems(observableList);
        tcDiscussion.setCellValueFactory(new PropertyValueFactory<Discussion, String>("idDiscussion"));                
        listD = discussionService.AfficherDiscussionByIdUserR(4); // user connected!!!!!
        dataD = FXCollections.observableArrayList(listD);       
        tableDiscussions.setItems(dataD);
        
        tableDiscussions.setRowFactory(tcDiscussion -> {
            TableRow<Discussion> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                rowData = row.getItem();});
            return row;});
        
        System.out.println(rowData);
        
        
        discussionService.AfficherDiscussionByIdUserS(1);
        List<Discussion> d = discussionService.AfficherDiscussionByIdUserS(1);
        System.out.println(d);
        
        //labelNomPrenom.setText(String.valueOf(rowData.getIdDiscussion()));
        
       
        
        /*UserCRUD userCRUD = new UserCRUD();
        ArrayList arrayList= (ArrayList) userCRUD.chercherParNom(txtSearch.getText());
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tvDisc.setItems(observableList);
        tcDisc.setCellValueFactory(new PropertyValueFactory<>("fullName"));*/
        
    }
                

    @FXML
    private void btnAjouterDiscussion(ActionEvent event) {
        List<User> users = UserService.chercherParNom(txtSearch.getText());
        System.out.println( users.get(0) );
        Discussion discussion = new Discussion(users.get(0).getIdUser(),users.get(0).getIdUser());
        idDiscussion = discussionService.ajouterDiscussion(discussion);
        //labelNomPrenom.setText(rowData.getIdDiscussion());
        //labelNomPrenom1.setText(users.get(0).getFullName());*/
    }




    @FXML
    private void btnAjouterMessage(ActionEvent event) {
        
        
        
        String message;
        message=txtMessage.getText();
        if(txtMessage.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Le message est vide!");
             alert.showAndWait();
        }
        else
        {
            Message m1, m2;
            System.out.println("row idDis: " +rowData.getIdDiscussion());
            m1 = new Message (1,rowData.getIdDiscussion(),4,txtMessage.getText(),"10,10,2022"); // user connected!!!!!
            if(rowData.getIdUserS() == 4) // user connected!!!!!
            {m2 = new Message (1,rowData.getIdDiscussion(),rowData.getIdUserR()," ","10,10,2022");}
            else{m2 = new Message (1,rowData.getIdDiscussion(),rowData.getIdUserS()," ","10,10,2022");}
            MessageCRUD MC= new MessageCRUD () ;
            MC.ajouterMessage(m1);
            MC.ajouterMessage(m2);
       
        JOptionPane.showMessageDialog(null,"Le message est envoyé! ");
        }
        
        
    }

    @FXML
    private void btnSupprimerDiscussionM(ActionEvent event) {
    }

    @FXML
    private void btnOuvrirDiscussion(ActionEvent event) {
        
        if(rowData.getIdUserR() == 4) // user connected!!!!!
        {
        List<Message> arraylist = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserR());
        ObservableList observableList = FXCollections.observableArrayList(arraylist);
        TableR.setItems(observableList);
        Receiver.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));                
        listR = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserR());
        dataR = FXCollections.observableArrayList(listR);       
        TableR.setItems(dataR);
        
        List<Message> arraylist2 = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserS());
        ObservableList observableList2 = FXCollections.observableArrayList(arraylist);
        TableS.setItems(observableList2);
        Sender.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));                
        listS = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserS());
        dataS = FXCollections.observableArrayList(listS);       
        TableS.setItems(dataS);
        
        System.out.println("idDis"+rowData.getIdDiscussion());
        
        TableR.setRowFactory(Receiver -> {
            TableRow<Message> row1 = new TableRow<>();
            row1.setOnMouseClicked(eventR -> {
                rowDataR = row1.getItem();});
            return row1;});
        
        TableS.setRowFactory(Sender -> {
            TableRow<Message> row = new TableRow<>();
            row.setOnMouseClicked(eventS -> {
                rowDataS = row.getItem();});
            return row;});
        }
        else if(rowData.getIdUserS() == 4){ // user connected!!!!!
        List<Message> arraylist = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserR());
        ObservableList observableList = FXCollections.observableArrayList(arraylist);
        TableR.setItems(observableList);
        Sender.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));                
        listR = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserR());
        dataR = FXCollections.observableArrayList(listR);       
        TableS.setItems(dataR);
        
        List<Message> arraylist2 = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserS());
        ObservableList observableList2 = FXCollections.observableArrayList(arraylist);
        TableS.setItems(observableList2);
        Receiver.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));                
        listS = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserS());
        dataS = FXCollections.observableArrayList(listS);       
        TableR.setItems(dataS);
        
        System.out.println("idDis"+rowData.getIdDiscussion());
        
        TableR.setRowFactory(Receiver -> {
            TableRow<Message> row1 = new TableRow<>();
            row1.setOnMouseClicked(eventR -> {
                rowDataR = row1.getItem();});
            return row1;});
        
        TableS.setRowFactory(Sender -> {
            TableRow<Message> row = new TableRow<>();
            row.setOnMouseClicked(eventS -> {
                rowDataS = row.getItem();});
            return row;});
        }
        
        
        
        
        
        /*List<Message> arraylist2 = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserS());
        ObservableList observableList2 = FXCollections.observableArrayList(arraylist);
        TableS.setItems(observableList);
        Receiver.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));                
        listM = messageService.AfficherMessageByIdDiscussion(rowData.getIdDiscussion(), rowData.getIdUserR());
        dataM = FXCollections.observableArrayList(listM);       
        TableR.setItems(dataM);
        
        System.out.println("idDis"+rowData.getIdDiscussion());
        
        TableS.setRowFactory(Sender -> {
            TableRow<Message> row = new TableRow<>();
            row.setOnMouseClicked(eventS -> {
                rowDataM = row.getItem();
                
                
                    });
            //return row;*/
        
        
    }
}

