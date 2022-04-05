/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cse_2206.Smart_Marriage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shoha
 */
public class MarriageStatusController implements Initializable {
    
     @FXML
    private TableView<marriage_data> studentsTable;
    @FXML
    private TableColumn<marriage_data, String> idCol;
    @FXML
    private TableColumn<marriage_data, String> nameCol;
    @FXML
    private TableColumn<marriage_data, String> birthCol;
    @FXML
    private TableColumn<marriage_data, String> adressCol;
    @FXML
    private TableColumn<marriage_data, String> nidCol;
    @FXML
    private TableColumn<marriage_data, String> mstatusCol;
    
    
    
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    marriage_data marriage_data = null ;
    @FXML
    private Button homebtn;
    @FXML
    private TextField search;
    @FXML
    private AnchorPane mainpane;
    
    ObservableList<marriage_data>  StudentList = FXCollections.observableArrayList();
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        
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
    private void refreshTable() {
        
        try {
            StudentList.clear();
            
            query = "SELECT * FROM `m_data`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                StudentList.add(new  marriage_data(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("birth"),
                        resultSet.getString("adress"),
                        resultSet.getString("email"),
                        resultSet.getString("nid"),
                        resultSet.getString("mstatus")));
                studentsTable.setItems(StudentList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MarriageStatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadData() {
        
        connection = DbConnect.getConnect();
        refreshTable();
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthCol.setCellValueFactory(new PropertyValueFactory<>("birth"));
        adressCol.setCellValueFactory(new PropertyValueFactory<>("adress"));
        mstatusCol.setCellValueFactory(new PropertyValueFactory<>("mstatus"));
        nidCol.setCellValueFactory(new PropertyValueFactory<>("nid"));
        
        
    }

}
