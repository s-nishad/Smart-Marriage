/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cse_2206.Smart_Marriage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author shoha
 */

public class HomePageController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Label label_welcome;
    @FXML
    private Button goStatus;
    @FXML
    private BorderPane mainpane;
    @FXML
    private Button goReg;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "signUplogIn.fxml", "Home", null);
            }
        });

        goStatus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("MarriageStatus.fxml"));
                    mainpane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        
        
        goReg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("goReg.fxml"));
                    mainpane.getChildren().setAll(pane);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        
    }
    
    public void setUserInformation(String username) {
        label_welcome.setText("Welcome " + username + "!");
    }
}
