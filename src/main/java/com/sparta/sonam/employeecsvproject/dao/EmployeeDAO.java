package com.sparta.sonam.employeecsvproject.dao;

import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.jbdc.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class EmployeeDAO implements Runnable{
    private ArrayList<EmployeeDTO> employeeDTOArrayList;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public EmployeeDAO(Connection connection, ArrayList<EmployeeDTO> employeeDTOArrayList){
        this.connection = connection;
        this.employeeDTOArrayList = employeeDTOArrayList;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(EmployeeDTO employeeDTO){
        try {
            preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_EMPLOYEE_DB);
            preparedStatement.setInt(1, employeeDTO.getEmployeeID());
            preparedStatement.setString(2, employeeDTO.getNamePrefix());
            preparedStatement.setString(3, employeeDTO.getFirstName());
            preparedStatement.setString(4, String.valueOf(employeeDTO.getMiddleInitial()));
            preparedStatement.setString(5, employeeDTO.getLastName());
            preparedStatement.setString(6, String.valueOf(employeeDTO.getGender()));
            preparedStatement.setString(7, employeeDTO.getEmail());
            preparedStatement.setDate(8, new java.sql.Date(employeeDTO.getDateOfBirth().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(employeeDTO.getDateOfJoining().getTime()));
            preparedStatement.setFloat(10, employeeDTO.getSalary());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMultipleRecords(ArrayList<EmployeeDTO> employeeDTOArrayList){
        try {
            preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_EMPLOYEE_DB);
            for(EmployeeDTO employeeDTO: employeeDTOArrayList) {
                preparedStatement.setInt(1, employeeDTO.getEmployeeID());
                preparedStatement.setString(2, employeeDTO.getNamePrefix());
                preparedStatement.setString(3, employeeDTO.getFirstName());
                preparedStatement.setString(4, String.valueOf(employeeDTO.getMiddleInitial()));
                preparedStatement.setString(5, employeeDTO.getLastName());
                preparedStatement.setString(6, String.valueOf(employeeDTO.getGender()));
                preparedStatement.setString(7, employeeDTO.getEmail());
                preparedStatement.setDate(8, new java.sql.Date(employeeDTO.getDateOfBirth().getTime()));
                preparedStatement.setDate(9, new java.sql.Date(employeeDTO.getDateOfJoining().getTime()));
                preparedStatement.setFloat(10, employeeDTO.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void printAllEmployees(){
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getBytes(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getBytes(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getDate(8));
                System.out.println(resultSet.getDate(9));
                System.out.println(resultSet.getFloat(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void truncateRecords(){
        try {
            preparedStatement = connection.prepareStatement(SQLQueries.TRUNCATE_RECORDS);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            createMultipleRecords(employeeDTOArrayList);
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
        }
    }

}
