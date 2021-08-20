package com.sparta.sonam.employeecsvproject.controller.jbdc;

import com.sparta.sonam.employeecsvproject.model.EmployeeDTO;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class DatabaseWriter{
    private static Logger logger = Logger.getLogger("DatabaseWriter");
    private ArrayList<EmployeeDTO> employeeDTOArrayList;
    public void writeOntoDB(ArrayList<EmployeeDTO> employeeDTOArrayList){
        this.employeeDTOArrayList = employeeDTOArrayList;

        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOArrayList);
        EmployeeDAO employeeDAO2 = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOArrayList);
        EmployeeDAO employeeDAO3 = new EmployeeDAO(ConnectionManager.connectToDB(), employeeDTOArrayList);

        employeeDAO.run();
        employeeDAO2.run();
        employeeDAO3.run();

        /*logger.info(employeeDTOHashMap.get(198429));
        employeeDAO.createRecord(employeeDTOHashMap.get(198429));
        EmployeeDTO employeeDTO;*/

        /*for(EmployeeDTO employeeDTO: employeeDTOSet){
            employeeDAO.createRecord(employeeDTO);
        }*/
        //logger.info(employeeDTOSet.stream().count());
        //createMultipleRecords(employeeDTOArrayList);
        //employeeDAO.truncateRecords();
    }

    public ArrayList<EmployeeDTO> getEmployeeDTOArrayList() {
        return employeeDTOArrayList;
    }

    public void setEmployeeDTOArrayList(ArrayList<EmployeeDTO> employeeDTOArrayList) {
        this.employeeDTOArrayList = employeeDTOArrayList;
    }
}
