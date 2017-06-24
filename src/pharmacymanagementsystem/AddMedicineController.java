/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AddMedicineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private VBox addMedicinePane;
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private TextField medicineNameField;
    
    @FXML
    private TextField medicineQuantityField;

    @FXML
    private TextField medicineExpireDateField;
    
     @FXML
    void goBack(MouseEvent event) {
        
    }

    
     @FXML
    void goToLogin(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        TextFields.bindAutoCompletion(
//            searchBox,
//            "Hey", "Hello", "Hello World", "Apple", "Cool", "Costa", "Cola", "Coca Cola");
    }    
}
