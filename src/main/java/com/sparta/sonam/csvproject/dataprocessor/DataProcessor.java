package com.sparta.sonam.csvproject.dataprocessor;

import com.sparta.sonam.csvproject.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DataProcessor {
    public static ArrayList<EmployeeDTO> removeDuplicates(ArrayList<EmployeeDTO> arrayList){
        Set<EmployeeDTO> listWithoutDuplicates = new LinkedHashSet<>(arrayList);
        arrayList.clear();
        arrayList.addAll(listWithoutDuplicates);
        return arrayList;
    }
}
//TODO: Oanly take id and remove duplicate id then add remining ids back to arraylist
//assign row id using short and use row id instead of employee id???
