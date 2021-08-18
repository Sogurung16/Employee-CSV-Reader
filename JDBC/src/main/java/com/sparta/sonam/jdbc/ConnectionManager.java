package com.sparta.sonam.jdbc;

import com.sparta.sonam.util.PropertiesLoader;

import java.sql.*;

public class ConnectionManager {
    private static Connection connection;
    public static Connection connectToDB() {
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("userName");
        String password = PropertiesLoader.getProperties().getProperty("password");

        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
