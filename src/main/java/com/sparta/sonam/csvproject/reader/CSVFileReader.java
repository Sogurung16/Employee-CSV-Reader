package com.sparta.sonam.csvproject.reader;

import com.sparta.sonam.csvproject.dataprocessor.DataProcessor;
import com.sparta.sonam.csvproject.dto.EmployeeDTO;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader implements Runnable{
    private static Logger logger = Logger.getLogger("FileIO");

    public static void readFromFile(String fileName) {
        try {
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);

            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            ArrayList<Integer> employeesID = new ArrayList<>();
            String line;

            bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employees.add(employee);
                employeesID.add(employee.getEmployeeID());
            }

            logger.info("Number of records in Database: " + employees.size());
            logger.info("First record in Database: " + employees.get(0).toString());

            DataProcessor.removeDuplicates(employeesID);

            logger.info("Number of records in Database: " + employeesID.size());

            fileReader.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {

    }
}

//Read using multiple threads using a loop and group them together. kill the group after the process is complete.
//Note: most JDBC drivers these days have a built in connection pool.
//Connection pool: connections are reused rather than created each time a connection is requested

//stream prallel method - concurrency
//parallelstream

//spliterator iterates concurrently