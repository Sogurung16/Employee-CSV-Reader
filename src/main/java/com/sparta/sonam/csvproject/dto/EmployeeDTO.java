package com.sparta.sonam.csvproject.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class EmployeeDTO {
    private int employeeID;
    private double salary;
    private String namePrefix, firstName, lastName, email;
    private char middleInitial, gender;
    private Date dateOfBirth, dateOfJoining;

    public EmployeeDTO(String[] employeeString){
        this.employeeID = Integer.parseInt(employeeString[0]);
        this.namePrefix = employeeString[1];
        this.firstName = employeeString[2];
        this.middleInitial = employeeString[3].charAt(0);
        this.lastName = employeeString[4];
        this.gender = employeeString[5].charAt(0);
        this.email = employeeString[6];
        try {
            this.dateOfBirth = DateFormat.getInstance().parse(employeeString[7]);
            this.dateOfJoining = DateFormat.getInstance().parse(employeeString[8]);
        }catch (ParseException e){
            e.getMessage();
        }
        this.salary = Double.parseDouble(employeeString[9]);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    //Constructor
    //read line , split, pass the employee ID into this class and create the object. check for the missing values.
    //Arraylist.
    //First line contain the attributes
}
