package com.sparta.sonam.employeecsvproject.controller;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class CSVFileReaderTest {
    @Test
    @DisplayName("Reading file from a non existent file should throw IOException with message 'File not found'")
    void readFromFileCatchIOException() {
        String fileName = "D:\\SpartaGlobal\\Course\\Week 5\\FileIO\\src\\main\\resources\\ThereIsNoFile.csv";
        String message = "File not found";
        Assertions.assertThrows(IOException.class, () -> new FileReader(fileName), message);
    }

    @Test
    @DisplayName("Number of records in Database should be 1000")
    void numberOfRecordsInDatabase(){
        try {
            var fileReader = new FileReader("src/main/resources/EmployeeRecords.csv");
            var bufferedReader = new BufferedReader(fileReader);

            ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employeeDTOArrayList.add(employee);
            }

            Assertions.assertEquals(10000, employeeDTOArrayList.size());

            fileReader.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Number of clean records in Database should be 9943")
    void numberOfCleanRecordsInDatabase(){
        try {
            var fileReader = new FileReader("src/main/resources/EmployeeRecords.csv");
            var bufferedReader = new BufferedReader(fileReader);

            HashMap<Integer, EmployeeDTO> employeeDTOHashMap = new HashMap<>();
            ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employeeDTOHashMap.put(employee.getEmployeeID(), employee);
                employeeDTOArrayList.add(employee);
            }
            fileReader.close();

            Assertions.assertEquals(9943, employeeDTOHashMap.size());
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Number of duplicate records in Database should be 57")
    void numberOfDuplicateRecordsInDatabase(){
        try {
            var fileReader = new FileReader("src/main/resources/EmployeeRecords.csv");
            var bufferedReader = new BufferedReader(fileReader);

            HashMap<Integer, EmployeeDTO> employeeDTOHashMap = new HashMap<>();
            ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employeeDTOHashMap.put(employee.getEmployeeID(), employee);
                employeeDTOArrayList.add(employee);
            }
            fileReader.close();

            Assertions.assertEquals(57,
                    (employeeDTOArrayList.size() - employeeDTOHashMap.size()));
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
