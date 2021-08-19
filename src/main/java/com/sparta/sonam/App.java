package com.sparta.sonam;

import com.sparta.sonam.csvproject.reader.CSVFileReader;
import org.apache.log4j.Logger;

import java.io.File;

public class App {
    private static Logger logger = Logger.getLogger("Main");
    public static void main( String[] args ) {
        long startTime = System.nanoTime();
        File file = new File("src/main/resources/EmployeeRecords.csv");
        String fileName = file.getAbsolutePath();
        CSVFileReader.readFromFile(fileName);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        logger.info("Time taken to run programme: " + timeTaken/1_000_000_000 + "seconds");
    }
}
