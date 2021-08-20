package com.sparta.sonam.employeecsvproject.dataprocessor;

import com.sparta.sonam.employeecsvproject.dao.EmployeeDAO;
import com.sparta.sonam.employeecsvproject.dto.EmployeeDTO;
import com.sparta.sonam.employeecsvproject.jbdc.ConnectionManager;

import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor{
    public ArrayList<EmployeeDTO> splitArrayList(ArrayList<EmployeeDTO> employeeDTOArrayList, int index1, int index2){
        ArrayList<EmployeeDTO> subList = new ArrayList<>(employeeDTOArrayList.subList(index1, index2));

        for(int i = 0; i < subList.size(); i++){
            EmployeeDTO employeeDTO = employeeDTOArrayList.get(i);
            employeeDTOArrayList.add(employeeDTO);
        }
        return subList;
    }

    public void removeDuplicates(ArrayList<EmployeeDTO> employeeDTOArrayList){
        int i = 0;
        //Map does not allow duplicate keys.
        //ArrayList does allow duplicates. Map and ArrayList is used calculate duplicate records.
        Map<Integer, EmployeeDTO> employeeDTOMap = new HashMap();
        while(employeeDTOArrayList.size()>i){
            int employeeID = employeeDTOArrayList.get(i).getEmployeeID();
            EmployeeDTO employeeDTO = employeeDTOArrayList.get(i);
            employeeDTOMap.put(employeeID, employeeDTO);
            i++;
        }

        employeeDTOArrayList.clear();//ArrayList is returned (less memory and faster)

        //Set used to remove duplicate values within keys. Ensuring 1-1 K-V relationship.
        Set<EmployeeDTO> employeeSet = new HashSet<>();
        employeeDTOMap.entrySet()
                .stream().filter(entry -> employeeSet.add((EmployeeDTO) entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        employeeDTOArrayList.addAll(employeeSet);
    }

    public Thread createThread(ArrayList<EmployeeDTO> subEmployeeDTOArrayList){
        Thread thread = new Thread(new EmployeeDAO(ConnectionManager.connectToDB(), subEmployeeDTOArrayList));
        return thread;
    }
}
