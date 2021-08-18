package com.sparta.sonam;

import com.sparta.sonam.csvproject.reader.CSVFileReader;
import java.io.File;

public class App {
    public static void main( String[] args ) {
        File file = new File("src/main/resources/EmployeeRecords.csv");
        String fileName = file.getAbsolutePath();
        CSVFileReader.readFromFile(fileName);
    }
}
