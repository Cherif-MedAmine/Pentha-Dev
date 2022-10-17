/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class HomeController implements Initializable {

    @FXML
    private TextField homesearch;
    @FXML
    private Label labelusername;
    @FXML
    private Button buttonYourPostsHome;
    @FXML
    private Button buttonAddPostHome;
    @FXML
    private ImageView logoHomeImage ;
    @FXML
    private ImageView searchHomeImage;
    @FXML
    private ImageView userHomeImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
