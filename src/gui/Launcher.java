package gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    

    @Override
    public void start(Stage primaryStage) throws Exception {
     
           
        Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource("Home.fxml"));
             Scene scene = new Scene(root);
        
        primaryStage.setTitle("home");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}