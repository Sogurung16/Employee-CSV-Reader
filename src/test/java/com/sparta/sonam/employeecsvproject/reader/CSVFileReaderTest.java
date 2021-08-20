package com.sparta.sonam.employeecsvproject.reader;

import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.reader.CSVFileReader;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CSVFileReaderTest {
    @Test
    @DisplayName("Reading file from a non existent file should throw IOException with message 'File not found'")
    void readFromFileCatchIOException() {
        String fileName = "D:\\SpartaGlobal\\Course\\Week 5\\FileIO\\src\\main\\resources\\ThereIsNoFile.csv";
        String message = "File not found";
        Assertions.assertThrows(IOException.class, () -> new FileReader(fileName), message);
    }

    @Test
    @DisplayName("Number of records in Database should be 10000")
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
    @DisplayName("The return value of the class should be of size 9943")
    void arrayListReturnsCorrectValue(){
        CSVFileReader csvFileReader = new CSVFileReader();

        ArrayList<EmployeeDTO> employeeDTOArrayList = csvFileReader.readFromFile
                ("D:/SpartaGlobal/Course/Week 5/FileIO/src/main/resources/EmployeeRecords.csv");

        Assertions.assertEquals(9943, employeeDTOArrayList.size());
    }
}
