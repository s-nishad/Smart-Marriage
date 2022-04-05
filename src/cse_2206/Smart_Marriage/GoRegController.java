/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cse_2206.Smart_Marriage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shoha
 */
public class GoRegController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField birth;
    @FXML
    private TextField email;
    @FXML
    private TextField mstatus;
    @FXML
    private TextField nid;
    @FXML 
    private Button homebtn;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private Button submitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        homebtn.setOnAction((ActionEvent event) -> {
            try {
                Parent fxml = FXMLLoader.load(getClass().getResource("homePage.fxml"));
                mainpane.getChildren().removeAll();
                mainpane.getChildren().setAll(fxml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }    

    @FXML
    private void register(ActionEvent event) throws SQLException {
        Window owner = submitButton.getScene().getWindow();
        System.out.println(name.getText());
        System.out.println(birth.getText());
        System.out.println(address.getText());
        System.out.println(email.getText());
        System.out.println(mstatus.getText());
        System.out.println(nid.getText());
        
        if (name.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }
        
        if (birth.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your date of birth");
            return;
        }
        
        if (address.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your address");
            return;
        }
        
        
        if (email.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your email");
            return;
        }
        
        if (mstatus.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your partner name");
            return;
        }
        
        if (nid.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your nid");
            return;
        }
        
        String fullName = name.getText();
        String date = birth.getText();
        String addressNo = address.getText();
        String emailId = email.getText();
        String marriedStatus = mstatus.getText();
        String nidNo = nid.getText();
        
        
        Db2 Db2 = new Db2();
        Db2.insertRecord(fullName, date, addressNo, emailId, marriedStatus, nidNo);
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
            "Welcome " + name.getText());
        
    }
    
    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
}
