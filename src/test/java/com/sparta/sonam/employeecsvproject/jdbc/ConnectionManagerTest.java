package com.sparta.sonam.employeecsvproject.jdbc;

import com.sparta.sonam.employeecsvproject.jbdc.ConnectionManager;
import com.sparta.sonam.employeecsvproject.util.PropertiesLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

class ConnectionManagerTest {
    String url, username, password;

    @BeforeEach
    void setUp(){
        this.url = PropertiesLoader.getProperties().getProperty("url");
        this.username = PropertiesLoader.getProperties().getProperty("username");
        this.password = PropertiesLoader.getProperties().getProperty("password");
    }

    @Test
    @DisplayName("Test connection is valid & exists.")
    void connectToDBTest() {
        Connection connection = ConnectionManager.connectToDB();
        try {
            Assertions.assertTrue(connection.isValid(1000));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test connection is successfully closed.")
    void closeConnectionTest() {
        Connection connection = ConnectionManager.connectToDB();
        ConnectionManager.closeConnection();
        try {
            Assertions.assertTrue(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}