package com.sparta.sonam.jdbc;

import java.sql.*;

public class UserDAO {
    private Connection connection;
    private Statement statement;

    public UserDAO(Connection connection) {
        try {
            this.connection = connection;
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllUsers() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT INTO `userdb_schema`.`users` (`id`, `user-name`, `email`) VALUES ('2', 'temp', 'temp@gmail.com');
    public void createRecord(int id, String userName, String email) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readRecord(int recordId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQLQueries.SELECT_RECORD);
            preparedStatement.setInt(1, recordId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int recordId){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQLQueries.DELETE_RECORD);
            preparedStatement.setInt(1, recordId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecordName(String newName, int recordId){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQLQueries.UPDATE_RECORD_NAME);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, recordId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecordEmail(String newEmail, int recordId){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SQLQueries.UPDATE_RECORD_EMAIL);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, recordId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
