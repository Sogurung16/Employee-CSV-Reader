package com.sparta.sonam.employeecsvproject.dataprocessor;

import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.reader.CSVFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class DataProcessorTest {
    @Test
    @DisplayName("Should obtain a sublist from an arraylist")
    void splitArrayListTest(){
        ArrayList<EmployeeDTO> employeeDTOArrayList = CSVFileReader.readFromFile("D:\\SpartaGlobal\\Course" +
                "\\Week 5\\FileIO\\src\\main\\resources\\EmployeeRecords.csv");

        DataProcessor dataProcessor = new DataProcessor();
        ArrayList<EmployeeDTO> subList = dataProcessor.splitArrayList(employeeDTOArrayList, 0, 1000);

        Assertions.assertEquals(1000, subList.size());
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

            Map<Integer, EmployeeDTO> employeeDTOMap = new HashMap<>();
            ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();

            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employeeDTOMap.put(employee.getEmployeeID(), employee);
                employeeDTOArrayList.add(employee);
            }

            fileReader.close();

            Assertions.assertEquals(57,
                    (employeeDTOArrayList.size() - employeeDTOMap.size()));
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}