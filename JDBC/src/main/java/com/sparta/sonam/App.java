package com.sparta.sonam;

import com.sparta.sonam.jdbc.ConnectionManager;
import com.sparta.sonam.jdbc.UserDAO;

public class App {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO(ConnectionManager.connectToDB());
        ConnectionManager.closeConnection();
    }
}
