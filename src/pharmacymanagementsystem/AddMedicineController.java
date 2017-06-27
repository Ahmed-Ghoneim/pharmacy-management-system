/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AddMedicineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String search = "";
    private ResultSet rs;
    private HashMap <String, Integer> medicineList = new HashMap <>();
    private ObservableList<String> list = FXCollections.observableArrayList();
    
    @FXML
    private ChoiceBox medicineNameField;
    
    @FXML
    private TextField medicineQuantityField;

    @FXML
    private DatePicker expireDateField;
    
    @FXML
    private Label typedName;
    
    @FXML
    private Label status;
    
    @FXML
    void addMedicine(ActionEvent event) {
        if(medicineNameField.getValue().equals(null) || medicineQuantityField.getText().isEmpty() || expireDateField.getValue().equals(null)){
            status.setTextFill(Paint.valueOf("red"));
            status.setText("Please, fill all the fields");
        }else{
            int medicine_id = medicineList.get(medicineNameField.getValue());
            int quantity = Integer.parseInt(medicineQuantityField.getText());
            String expire_date = expireDateField.getValue().toString();
            int employee_id = PharmacyManagementSystem.id;
            String modified_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
            String sql = "INSERT INTO pharmacy_medicine(medicine_id, quantity, expire_date, employee_id, modified_date) "
                    + "VALUES(" + medicine_id + "," + quantity + ",'" + expire_date + "'," + employee_id + ",'" + modified_date + "');";
            try {
                PharmacyManagementSystem.stmt = PharmacyManagementSystem.conn.createStatement();
                PharmacyManagementSystem.stmt.executeUpdate(sql);
                PharmacyManagementSystem.conn.commit();
                status.setTextFill(Paint.valueOf("green"));
                status.setText("Updated successfully");
            } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    void clearFields(ActionEvent event) {
        medicineNameField.setValue(list.get(0));
        medicineQuantityField.clear();
        expireDateField.setValue(null);
    }
    
    @FXML      
    void selectTypedMedicine(KeyEvent event) {
        
        
        if ((event.getCode() == KeyCode.BACK_SPACE) && search.length() > 0) {
            search = search.substring(0, search.length() - 1);
        } else if(event.getCode() == KeyCode.TAB){
        }else{
            search += event.getText();
        }

        if (search.length() == 0) {
            medicineNameField.setValue(medicineList.get(1));
            search = "";
            typedName.setVisible(false);
            return;
        }else{
            typedName.textProperty().bind(new SimpleStringProperty(search));
            typedName.setVisible(true);
        }
        
        
        
        ObservableList < String > items = medicineNameField.getItems();
        for (String item : items) {
            if (item.toLowerCase().startsWith(search)) {
                medicineNameField.setValue(item);
            }
        }
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            //get list of medicine
            rs = PharmacyManagementSystem.stmt.executeQuery("SELECT id, name FROM medicine;");
            while(rs.next()){
                medicineList.put(rs.getString("name"), rs.getInt("id"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddMedicineController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.clear();
        list.addAll(medicineList.keySet());
        Collections.sort(list);
        medicineNameField.getItems().addAll(list);
        medicineNameField.setValue(list.get(0));
        //set quantity field for integers only
        medicineQuantityField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d*")) {
                medicineQuantityField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
    });
    }    
}
