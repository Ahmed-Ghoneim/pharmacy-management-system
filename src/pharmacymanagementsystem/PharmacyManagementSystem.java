/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
//background  #5fc5fc
public class PharmacyManagementSystem extends Application {
    
    public static String loginID = "login";
    public static String loginFile = "Login.fxml";
    public static String managerID = "manager";
    public static String managerFile = "Manager.fxml";
    public static String employeeID = "employee";
    public static String employeeFile = "Employee.fxml";
    
    static ScreensController mainContainer;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainContainer = new ScreensController();
        mainContainer.loadScreen(PharmacyManagementSystem.loginID, PharmacyManagementSystem.loginFile);
        
        mainContainer.setScreen(PharmacyManagementSystem.loginID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        stage.setTitle("Pharmacy Management System");
        stage.setMaximized(true);
        stage.getIcons().add(new Image("images/pharma logo.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}