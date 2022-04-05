/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cse_2206.Smart_Marriage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shoha
 */
public class SignUpController implements Initializable {

    @FXML
    private Button action_signup;

    @FXML
    private TextField input_mail;

    @FXML
    private PasswordField input_pass;

    @FXML
    private TextField input_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        action_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!input_user.getText().trim().isEmpty() && !input_mail.getText().isEmpty() && !input_pass.getText().isEmpty()) {
                    DBUtils.signUpUser(event, input_user.getText(), input_mail.getText(), input_pass.getText());
                } else {
                    System.out.println("PLease fill all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("please fill all the information to sign up!");
                    alert.show();
                }
            }
        });
    }
}
