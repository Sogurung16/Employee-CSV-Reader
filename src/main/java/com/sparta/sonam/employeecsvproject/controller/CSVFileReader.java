package com.sparta.sonam.employeecsvproject.controller;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CSVFileReader{
    private Logger logger = Logger.getLogger("CSVFileReader");

    public ArrayList<EmployeeDTO> readFromFile(String fileName) {
        try {
            var fileReader = new FileReader(fileName);
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

            logger.info("Number of clean records in Database: " + employeeDTOMap.size());
            logger.info("Number of duplicate records in Database: " +
                    (employeeDTOArrayList.size() - employeeDTOMap.size()));

            employeeDTOArrayList.clear();

            Set<EmployeeDTO> employeeSet = new HashSet<>();
            employeeDTOMap.entrySet()
                    .stream().filter(entry -> employeeSet.add(entry.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            employeeDTOArrayList.addAll(employeeSet);

            return employeeDTOArrayList;
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}

//Read using multiple threads using a loop and group them together. kill the group after the process is complete.
//Note: most JDBC drivers these days have a built in connection pool.
//Connection pool: connections are reused rather than created each time a connection is requested

//stream prallel method - concurrency
//parallelstream

//spliterator iterates concurrently