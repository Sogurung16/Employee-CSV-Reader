package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DatabaseWriter implements Runnable{
    private static Logger logger = Logger.getLogger("DatabaseWriter");
    public static void writeOntoDB(HashMap<Integer, EmployeeDTO> employeeDTOHashMap){
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB());
        Collection<EmployeeDTO> employeeDTOCollection = employeeDTOHashMap.values();
        /*logger.info(employeeDTOHashMap.get(198429));
        employeeDAO.createRecord(employeeDTOHashMap.get(198429));
        EmployeeDTO employeeDTO;*/
        for(EmployeeDTO employeeDTO: employeeDTOCollection){
            employeeDAO.createRecord(employeeDTO);
        }
    }

    @Override
    public void run() {

    }
}
