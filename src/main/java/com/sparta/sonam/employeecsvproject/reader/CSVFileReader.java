package com.sparta.sonam.employeecsvproject.reader;

import com.sparta.sonam.employeecsvproject.dataprocessor.DataProcessor;
import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.printer.Printer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVFileReader{
    public static ArrayList<EmployeeDTO> readFromFile(String fileAbsolutePath) {
        try {
            ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();

            var fileReader = new FileReader(fileAbsolutePath);
            var bufferedReader = new BufferedReader(fileReader);

            String line;

            bufferedReader.readLine();//first row = attributes row

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employeeDTO = new EmployeeDTO(line.split(","));
                employeeDTOArrayList.add(employeeDTO);
            }
            int originalRecordsSize = employeeDTOArrayList.size();

            fileReader.close();

            DataProcessor dataProcessor = new DataProcessor();

            dataProcessor.removeDuplicates(employeeDTOArrayList);

            int processedRecordsSize = employeeDTOArrayList.size();


            Printer.printNumCleanRecords(processedRecordsSize);
            Printer.printNumDuplicateRecords(originalRecordsSize, processedRecordsSize);

            return employeeDTOArrayList;
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}