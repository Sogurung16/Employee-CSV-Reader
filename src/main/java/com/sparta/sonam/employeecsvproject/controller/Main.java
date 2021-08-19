package com.sparta.sonam.employeecsvproject.controller;

import org.apache.log4j.Logger;;

import java.io.File;

public class App {
    private static Logger logger = Logger.getLogger("Main");
    public static void main( String[] args ) {
        readFile();
    }

    private static void readFile(){
        long startTime = System.nanoTime();

        File file = new File("src/main/resources/EmployeeRecords.csv");
        String absolutePath = file.getAbsolutePath();
        CSVFileReader.readFromFile(absolutePath);

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        logger.info("Time taken to run programme: " + timeTaken/1_000_000_000 + "seconds");
    }
}
