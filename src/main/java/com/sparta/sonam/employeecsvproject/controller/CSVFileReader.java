package com.sparta.sonam.csvproject.controller.reader;

import com.sparta.sonam.csvproject.model.dto.EmployeeDTO;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVFileReader{
    private static Logger logger = Logger.getLogger("CSVFileReader");

    public static void readFromFile(String fileName) {
        try {
            var fileReader = new FileReader(fileName);
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

            logger.info("Number of clean records in Database: " + employeeDTOHashMap.size());
            logger.info("Number of duplicate records in Database: " +
                    (employeeDTOArrayList.size() - employeeDTOHashMap.size()));
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

//Read using multiple threads using a loop and group them together. kill the group after the process is complete.
//Note: most JDBC drivers these days have a built in connection pool.
//Connection pool: connections are reused rather than created each time a connection is requested

//stream prallel method - concurrency
//parallelstream

//spliterator iterates concurrently