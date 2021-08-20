package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;

import java.sql.*;

public class EmployeeDAO {
    /*Create, Read, Update, Delete*/
    private Connection connection;
    private Statement statement;

    public EmployeeDAO(Connection connection){
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(EmployeeDTO employeeDTO){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_EMPLOYEE_DB);
            preparedStatement.setInt(1, employeeDTO.getEmployeeID());
            preparedStatement.setString(2, employeeDTO.getNamePrefix());
            preparedStatement.setString(3, employeeDTO.getFirstName());
            preparedStatement.setString(4, String.valueOf(employeeDTO.getMiddleInitial()));
            preparedStatement.setString(5, employeeDTO.getLastName());
            preparedStatement.setString(6, String.valueOf(employeeDTO.getGender()));
            preparedStatement.setString(7, employeeDTO.getEmail());
            preparedStatement.setDate(8, (Date) employeeDTO.getDateOfBirth());
            preparedStatement.setDate(9, (Date) employeeDTO.getDateOfJoining());
            preparedStatement.setFloat(10, employeeDTO.getSalary());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(){

    }

    public void printAllEmployees(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from employee_csv_reader_db.employees");

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

    public void deleteRecord(){

    }
}
