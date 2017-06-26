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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EmployeeController implements Initializable, ControlledScreen {
    
    private ScreensController myController;
    static String name;
    static String username;
    static Image image;

    @FXML
    private VBox pane;

    @FXML
    private ImageView backward;

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<?> searchTable;

    @FXML
    private TableColumn<?, ?> medicineName;

    @FXML
    private TableColumn<?, ?> medicinePrice;

    @FXML
    private TableColumn<?, ?> medicineQuantity;

    @FXML
    private TableColumn<?, ?> medicineEffectiveIngredient;

    @FXML
    private ImageView employeeImage;

    @FXML
    private Label employeeName;

    @FXML
    private Label employeeUsername;

    @FXML
    private GridPane employeePane;


    @FXML
    void GoToNotExist(ActionEvent event) {

    }

    @FXML
    void goToAddExpenditure(ActionEvent event) {

    }

    @FXML
    void goToAddMedicine(ActionEvent event) throws IOException {
        backward.setVisible(true);
        pane.getChildren().remove(employeePane);
        pane.getChildren().add(FXMLLoader.load(getClass().getResource("AddMedicine.fxml")));
    }

    @FXML
    void goToContactSupplier(ActionEvent event) {

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
    void goToLogin(ActionEvent event) {
        
        myController.setScreen(PharmacyManagementSystem.loginID);
    
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
    void goToEmployeePane(MouseEvent event) {
        if(backward.isVisible())
            backward.setVisible(false);
        pane.getChildren().remove(1);
        pane.getChildren().add(employeePane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        employeeName.setText(name);
        employeeUsername.setText(username);
        employeeImage.setImage(image);
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

}
