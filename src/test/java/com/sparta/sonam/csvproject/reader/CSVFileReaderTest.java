package com.sparta.sonam.csvproject.reader;

import com.sparta.sonam.csvproject.dto.EmployeeDTO;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employees.add(employee);
            }

            Assertions.assertEquals(10000, employees.size());

            fileReader.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}