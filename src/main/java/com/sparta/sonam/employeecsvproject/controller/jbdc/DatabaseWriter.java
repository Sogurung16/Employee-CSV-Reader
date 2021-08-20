package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;

import java.util.Collection;
import java.util.HashMap;

public class DatabaseWriter implements Runnable{
    public static void writeOntoDB(HashMap<Integer, EmployeeDTO> employeeDTOHashMap){
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB());
        Collection<EmployeeDTO> employeeDTOCollection = employeeDTOHashMap.values();
        for(EmployeeDTO employeeDTO: employeeDTOCollection){
            employeeDAO.createRecord(employeeDTO);
        }

    }

    @Override
    public void run() {

    }
}
