package com.sparta.sonam.csvproject.reader;

import com.sparta.sonam.csvproject.dto.EmployeeDTO;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader {
    private static Logger logger = Logger.getLogger("FileIO");
    public static void readFromFile(String fileName) {

        try {
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);

            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            String line;

            String attributes = bufferedReader.readLine();

            while((line = bufferedReader.readLine())!=null){
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                employees.add(employee);
            }

            logger.info("EmployeeID: " + employees.get(0).getEmployeeID());

            fileReader.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
