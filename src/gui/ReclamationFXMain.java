    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author AJ
 */
public class ReclamationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomeReclamation.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("TestAdmin.fxml"));
            
            Scene scene = new Scene(root);
            
            //scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
           
            
            primaryStage.setTitle("Immo+");
            primaryStage.setScene(scene);
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclamationFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
