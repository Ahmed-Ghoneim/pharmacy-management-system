/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */

public class ManagerController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    private ScreensController myController;
    static String name;
    static String username;
    static Image image;
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private Button newInvoice;
    
    @FXML
    private VBox pane;
    
    @FXML
    private GridPane managerPane;
    
    @FXML
    private Label employeeName;

    @FXML
    private Label employeeUsername;
    
    @FXML
    private ImageView employeeImage;
    
     @FXML
    private ImageView backward;
    
    
    @FXML
    void GoToNotExist(ActionEvent event) {

    }

    @FXML
    void goToAddEmployee(ActionEvent event) {

    }

    @FXML
    void goToAddExpenditure(ActionEvent event) {

    }

    @FXML
    void goToAddMedicine(ActionEvent event) throws IOException {
        backward.setVisible(true);
        pane.getChildren().remove(managerPane);
        pane.getChildren().add(FXMLLoader.load(getClass().getResource("AddMedicine.fxml")));
    }

    @FXML
    void goToContactSupplier(ActionEvent event) {

    }

    @FXML
    void goToEditEmployee(ActionEvent event) {

    }

    @FXML
    void goToEditMedicine(ActionEvent event) {

    }

    @FXML
    void goToExpireSoon(ActionEvent event) {

    }

    @FXML
    void goToExpired(ActionEvent event) {

    }

    @FXML
    void goToMonthProfit(ActionEvent event) {

    }

    @FXML
    void goToNewInvoice(ActionEvent event) {

    }

    @FXML
    void goToOldInvoice(ActionEvent event) {

    }

    @FXML
    void goToShortStorage(ActionEvent event) {

    }

    @FXML
    void goToShowAll(ActionEvent event) {

    }

    @FXML
    void goToTotalInPrice(ActionEvent event) {

    }

    @FXML
    void goToTotalOutPrice(ActionEvent event) {

    }
    
    @FXML
    void goToShowAllInvoices(ActionEvent event) {

    }
    
     @FXML
    void goToShowAllEmployees(ActionEvent event) {

    }
    
     @FXML
    void goToManagerPane(MouseEvent event) {
        if(backward.isVisible())
            backward.setVisible(false);
        pane.getChildren().remove(1);
        pane.getChildren().add(managerPane);
    }
    
     @FXML
    void goToLogin(ActionEvent event) {
        myController.setScreen(PharmacyManagementSystem.loginID);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employeeName.setText(name);
        employeeUsername.setText(username);
        employeeImage.setImage(image);
    }    
    
    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

}