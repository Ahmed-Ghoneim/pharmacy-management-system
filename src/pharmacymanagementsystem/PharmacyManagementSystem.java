/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    static int id;
//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = new Date();
//    String d = dateFormat.format(date);
    //set Screens IDs and file name
    static String loginID = "login";
    static String loginFile = "Login.fxml";
    static String managerID = "manager";
    static String managerFile = "Manager.fxml";
    static String employeeID = "employee";
    static String employeeFile = "Employee.fxml";
    //set sqlite objects
    static Connection conn = null;
    static Statement stmt = null;
    
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