package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.controller.CSVFileReader;
import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

public class Loader{
    private static ArrayList<EmployeeDTO> employeeDTOArrayList;
    private static Logger logger = Logger.getLogger("EmployeeCSVReader");
    public static void readFile(){
        long startTime = System.nanoTime();

        File file = new File("src/main/resources/EmployeeRecords.csv");
        String absolutePath = file.getAbsolutePath();
        CSVFileReader csvFileReader = new CSVFileReader();
        employeeDTOArrayList = csvFileReader.readFromFile(absolutePath);

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        logger.info("Time taken to read file: " + timeTaken/1_000_000_000 + "seconds");
    }

    public static void writeFile(){
        long startTime = System.nanoTime();

        DatabaseWriter databaseWriter = new DatabaseWriter();
        databaseWriter.writeOntoDB(employeeDTOArrayList);

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        logger.info("Time taken to write to database: " + timeTaken/1_000_000_000 + "seconds");
    }
}
