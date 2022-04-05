/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse_2206.Smart_Marriage;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;



/**
 *
 * @author shoha
 */
public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) {
        Parent root = null;

        if (username != null ){
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                HomePageController homepagecontroller = loader.getController();
                homepagecontroller.setUserInformation(username);
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String username, String email, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db-smart-marriage", "root", "");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user_info WHERE email = ?");
            psCheckUserExists.setString(1, email);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("Email Already Exits");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You can not use this email");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO user_info (username, email, password) VALUES (?, ?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.executeUpdate();

                changeScene(event, "homePage.fxml", "Welcome ", username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db-smart-marriage", "root", "");
            preparedStatement = connection.prepareStatement("SELECT password FROM user_info WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User Not Found in the Database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided incorrect information");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    //String retrievedChannel = resultSet.getString("username");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "homePage.fxml", "welcome ", email);
                    } else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided incorrect information");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
