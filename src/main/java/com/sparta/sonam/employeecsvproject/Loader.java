package com.sparta.sonam.employeecsvproject;

import com.sparta.sonam.employeecsvproject.printer.Printer;
import com.sparta.sonam.employeecsvproject.reader.CSVFileReader;
import com.sparta.sonam.employeecsvproject.writer.DatabaseWriter;

import java.io.File;

public class Loader{
    public static void readFile(File file){
        CSVFileReader.readFromFile(file.getAbsolutePath());
    }

    public static void writeToDB(File file){
        long startTime = System.nanoTime();

        Printer.printFileRead(file.getName());
        DatabaseWriter.deleteAllFromDB();
        DatabaseWriter.writeFileOntoDB(file);

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        Printer.printTimeTakenToWriteToDB(timeTaken);
    }
}
