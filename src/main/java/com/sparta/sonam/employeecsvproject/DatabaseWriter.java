package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseWriter{
    private static Logger logger = Logger.getLogger("DatabaseWriter");
    private ArrayList<EmployeeDTO> employeeDTOArrayList;
    public void writeOntoDB(ArrayList<EmployeeDTO> employeeDTOArrayList){
        int index1 = 0, index2 = 0;
        Thread thread = null;

        long startTime = System.nanoTime();
        int subListSize = employeeDTOArrayList.size();

        for(int i = 0; i < employeeDTOArrayList.size(); i++){

        }

        loop:while(index2%1000==0){
            index2+=1000;
            if(index2<= employeeDTOArrayList.size()) {
                List<EmployeeDTO> employeeDTOSubList = (new ArrayList(employeeDTOArrayList.subList(index1, index2)));
                index1 = index2;

                EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOSubList);

                thread = new Thread(employeeDAO);
                thread.start();
            }else{
                break loop;
            }
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        logger.info("Time taken to write to database: " + timeTaken/1_000_000_000 + "seconds");

        /*List<EmployeeDTO> employeeDTOList = Collections.synchronizedList(new ArrayList(employeeDTOArrayList));
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOList);
        employeeDAO.truncateRecords();*/

        //spliterator
        //sublist

        /*EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOList);
        EmployeeDAO employeeDAO2 = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOList);
        EmployeeDAO employeeDAO3 = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOList);

        Thread thread = new Thread(employeeDAO);
        Thread thread2 = new Thread(employeeDAO2);
        Thread thread3 = new Thread(employeeDAO3);

        thread.start();
        thread2.start();
        thread3.start();*/

        /*logger.info(employeeDTOHashMap.get(198429));
        employeeDAO.createRecord(employeeDTOHashMap.get(198429));
        EmployeeDTO employeeDTO;*/

        /*for(EmployeeDTO employeeDTO: employeeDTOSet){
            employeeDAO.createRecord(employeeDTO);
        }*/
        //logger.info(employeeDTOSet.stream().count());
        //createMultipleRecords(employeeDTOArrayList);
    }
}
