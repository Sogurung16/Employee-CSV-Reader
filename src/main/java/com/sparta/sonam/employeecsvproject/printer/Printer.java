package com.sparta.sonam.employeecsvproject.printer;

public class Printer {
    public static void printNumCleanRecords(int cleanRecords){
        System.out.println("Number of clean records in Database: " + cleanRecords);
    }

    public static void printNumDuplicateRecords(int originalRecordsSize, int cleanRecords){
        System.out.println("Number of duplicate records in Database: " +
                (originalRecordsSize - cleanRecords));
    }

    public static void printFileRead(String fileName){
        System.out.println("File read: " + fileName);
    }

    public static void printTimeTakenToWriteToDB(long timeTaken){
        System.out.println("Time taken to write file: " + timeTaken/1_000_000_000 + "seconds");
    }
}
