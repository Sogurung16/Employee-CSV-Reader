package com.sparta.sonam.employeecsvproject.writer;

import com.sparta.sonam.employeecsvproject.dao.EmployeeDAO;
import com.sparta.sonam.employeecsvproject.dataprocessor.DataProcessor;
import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.jbdc.ConnectionManager;
import com.sparta.sonam.employeecsvproject.reader.CSVFileReader;

import java.io.File;
import java.util.ArrayList;

public class DatabaseWriter {
    private static ArrayList<EmployeeDTO> employeeDTOArrayList = new ArrayList<>();

    public static void writeFileOntoDB(File file) {
        ArrayList<EmployeeDTO> employeeDTOArrayList = CSVFileReader.readFromFile(file.getAbsolutePath());
        ArrayList<EmployeeDTO> subEmployeeDTOArrayList;
        int subListSize = 600;
        Thread thread = null;

        DataProcessor dataProcessor = new DataProcessor();
        int processedRecordsSize = employeeDTOArrayList.size();

        int index1, index2;
        for (index1 = 0, index2 = subListSize; index1 < processedRecordsSize; index1 += subListSize, index2 += subListSize) {
            if (index2 > processedRecordsSize) {
                index2 = processedRecordsSize;
            }

            subEmployeeDTOArrayList = dataProcessor.splitArrayList(employeeDTOArrayList, index1, index2);

            thread = dataProcessor.createThread(subEmployeeDTOArrayList);
            thread.start();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllFromDB() {
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOArrayList);
        employeeDAO.truncateRecords();
    }
}
