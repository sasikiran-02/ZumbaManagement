package com.simplilearn.zumbamanagement.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    private static final String TAG = "DB ";
    
    // Singleton instance
    private static DB dbInstance = new DB();

    private Connection connection;
    private Statement statement;

    // Public method to get the singleton instance
    public static DB getDB() {
        return dbInstance;
    }

    // Private constructor to initialize the database connection
    private DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(TAG + "Driver Loaded");
            initialize();
        } catch (Exception e) {
            System.out.println(TAG + "Something Went Wrong: " + e);
        }
    }

    // Method to initialize the database connection
    private void initialize() {
        try {
            String url = "jdbc:mysql://localhost:3306/zumba"; // Change to your DB name
            String user = "root"; // Change to your DB username
            String password = "Sasikiran@02"; // Change to your DB password
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(TAG + "Connection Created");
            statement = connection.createStatement();
            System.out.println(TAG + "Statement Created");
        } catch (SQLException e) {
            System.out.println(TAG + "Database Connection Failed: " + e.getMessage());
        }
    }

    // Method to execute update SQL commands (INSERT, UPDATE, DELETE)
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            System.out.println(TAG + "Executing SQL: " + sql + " ...");
            result = statement.executeUpdate(sql);
            System.out.println(TAG + "Statement Executed Successfully");
        } catch (SQLException e) {
            System.out.println(TAG + "Error Executing Update: " + e.getMessage());
        }
        return result;
    }

    // Method to execute query SQL commands (SELECT)
    public ResultSet executeQuery(String sql) {
        ResultSet set = null;
        try {
            System.out.println(TAG + "Executing SQL: " + sql + " ...");
            set = statement.executeQuery(sql);
            System.out.println(TAG + "Statement Executed Successfully");
        } catch (SQLException e) {
            System.out.println(TAG + "Error Executing Query: " + e.getMessage());
        }
        return set;
    }

    // Method to close the database connection
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println(TAG + "Connection Closed");
            }
        } catch (SQLException e) {
            System.out.println(TAG + "Error Closing Connection: " + e.getMessage());
        }
    }
}
