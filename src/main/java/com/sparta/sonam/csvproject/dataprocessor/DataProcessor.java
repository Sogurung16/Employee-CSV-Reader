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
//TODO: Only take id and remove duplicate id then add remaining ids back to arraylist
