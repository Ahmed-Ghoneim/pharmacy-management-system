/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Ahmed
 */
public class LoginController implements Initializable, ControlledScreen {

    Connection conn = null;
    Statement stmt = null;
    TrayNotification notification;
    Encryption encryption;
    ScreensController myController;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void login(ActionEvent event) throws Exception {
        String employeeName = "";
        String user = "";
        String encPass = encryption.encrypt(password.getText());
        String email = "";
        String imageLink = "";
        try {
            boolean logged = false;
            String pass = "";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, username, email, image, password FROM employees;");
            
            while (rs.next()) {
                user = rs.getString("username");
                email = rs.getString("email");
                pass = rs.getString("password");
                
                //Login success
                if ((username.getText().equals(user) || username.getText().equals(email)) && encPass.equals(pass)) {
                    logged = true;
                    employeeName = rs.getString("name");
                    imageLink = rs.getString("image");
                    System.out.println("link: " + imageLink);
                    notification = new TrayNotification("Welcome", "Logged in successfuly", NotificationType.SUCCESS);
                    notification.setAnimationType(AnimationType.POPUP);
                    notification.showAndDismiss(Duration.seconds(1));
                    System.out.println("Hello\n");
                    if(user.equals("root"))
                        goToManagerScreen(rs.getString("name"), user, new Image(imageLink));
                    else
                        goToEmployeeScreen(rs.getString("name"), user, new Image(imageLink));
                    username.clear();
                    password.clear();
                    break;
                }
            }

            if(!logged){
                notification = new TrayNotification("Wrong", "username or password", NotificationType.ERROR);
                notification.setAnimationType(AnimationType.POPUP);
                notification.showAndDismiss(Duration.seconds(1));
                System.out.println("Try again\n");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void exitProgram(ActionEvent event) {
        System.out.println("Bye");
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/pharmacy.db");
            conn.setAutoCommit(false);
            
            encryption = new Encryption();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private void goToManagerScreen(String name, String username, Image image){
        ManagerController.name = name;
        ManagerController.username = username;
        ManagerController.image = image;
        PharmacyManagementSystem.mainContainer.loadScreen(PharmacyManagementSystem.managerID, PharmacyManagementSystem.managerFile);
        myController.setScreen(PharmacyManagementSystem.managerID);
    }
    
    private void goToEmployeeScreen(String name, String username, Image image){
        EmployeeController.name = name;
        EmployeeController.username = username;
        EmployeeController.image = image;
        PharmacyManagementSystem.mainContainer.loadScreen(PharmacyManagementSystem.employeeID, PharmacyManagementSystem.employeeFile);
        myController.setScreen(PharmacyManagementSystem.employeeID);
    }
}
