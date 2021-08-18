package com.sparta.sonam.csvproject.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class EmployeeDTO {
    private int employeeID;
    private float salary;
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
        this.salary = Float.parseFloat(employeeString[9]);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public float getSalary() {
        return salary;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public char getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString(){
        return "\nEmployee ID: " + getEmployeeID() +
                "\nName Prefix: " + getNamePrefix() +
                "\nFirst Name: " + getFirstName() +
                "\nMiddle Initial: " + getMiddleInitial() +
                "\nLast Name: " + getLastName() +
                "\nGender: " + getGender() +
                "\nEmail: " + getEmail() +
                "\nDate of Birth: " + getDateOfBirth() +
                "\nDate of Joining: " + getDateOfJoining() +
                "\nSalary: " + getSalary();
    }
}
