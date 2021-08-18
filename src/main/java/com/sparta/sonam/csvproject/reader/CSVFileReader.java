package com.sparta.sonam.csvproject.reader;

import com.sparta.sonam.csvproject.dataprocessor.DataProcessor;
import com.sparta.sonam.csvproject.dto.EmployeeDTO;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader {
    private static Logger logger = Logger.getLogger("FileIO");

    public static void readFromFile(String fileName) {
        try {
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);

            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employees.add(employee);
            }

            logger.info("Number of records in Database: " + employees.size());
            logger.info("First record in Database: " + employees.get(0).toString());

            employees = DataProcessor.removeDuplicates(employees);

            logger.info("Number of records in Database: " + employees.size());

            fileReader.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

//TODO: fix null return on date values
