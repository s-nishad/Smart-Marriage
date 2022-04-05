/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse_2206.Smart_Marriage;


import java.sql.*;




/**
 *
 * @author shoha
 */
public class Db2 {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db-smart-marriage";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO m_data( name, birth, adress, email, mstatus, nid) VALUES ( ?, ?, ?, ?, ?, ?)";
    
    
    public void insertRecord(String fullName, String date, String addressNo, String emailId, String marriedStatus, String nidNo) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, addressNo);
            preparedStatement.setString(4, emailId);
            preparedStatement.setString(5, marriedStatus);
            preparedStatement.setString(6, nidNo);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
