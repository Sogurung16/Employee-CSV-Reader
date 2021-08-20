package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.controller.util.PropertiesLoader;

import java.sql.*;

public class ConnectionManager {
    private static Connection connection;
    public static Connection connectToDB(){
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("username");
        String password = PropertiesLoader.getProperties().getProperty("password");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
