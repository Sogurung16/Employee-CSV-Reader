package com.sparta.sonam.employeecsvproject;

import java.io.File;

public class Main {
    private static final File employeeRecordsFile = new File("src/main/resources/EmployeeRecords.csv");
    private static final File employeeRecordsLargeFile = new File("src/main/resources/EmployeeRecordsLarge.csv");

    public static void main( String[] args ) {
        Loader.writeToDB(employeeRecordsFile);

        Loader.writeToDB(employeeRecordsLargeFile);
    }
}
