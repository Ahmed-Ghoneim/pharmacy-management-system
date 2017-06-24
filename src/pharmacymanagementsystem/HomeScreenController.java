/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class HomeScreenController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    ScreensController myController;
    static String name;
    static String username;
    static Image image;
    
    @FXML
    private VBox homePane;
    
    @FXML
    private ImageView backward;

    @FXML
    private ImageView employeeImage;

    @FXML
    private Label employeeName;

    @FXML
    private Label employeeUsername;
    
    void updateScreen(String oldPane, String newPane) throws IOException{
        homePane.getChildren().remove(oldPane);
//        homePane.getChildren().add(FXMLLoader.load(getClass().getResource(PharmacyManagementSystem.role+".fxml")));
    }
    
    void backHomePane(ActionEvent event, String oldPane) throws IOException{
        homePane.getChildren().remove(oldPane);
    }
    
    @FXML
    void goToHomeScreen(MouseEvent event) throws IOException {
        homePane.getChildren().remove(1);
//        homePane.getChildren().add(FXMLLoader.load(getClass().getResource(PharmacyManagementSystem.role+".fxml")));
    }
            
     
    @FXML
    void goToLogin(ActionEvent event) {
        myController.setScreen("login");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            employeeName.setText(name);
//            employeeUsername.setText(username);
//            employeeImage.setImage(image);
//            homePane.getChildren().add(FXMLLoader.load(getClass().getResource(PharmacyManagementSystem.role+".fxml")));
//        } catch (IOException ex) {
//            Logger.getLogger(HomeScreenController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
