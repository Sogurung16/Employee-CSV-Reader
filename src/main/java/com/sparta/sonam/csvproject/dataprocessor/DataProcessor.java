package com.sparta.sonam.csvproject.dataprocessor;

import com.sparta.sonam.csvproject.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DataProcessor {
    public static void removeDuplicates(ArrayList<Integer> arrayList){
        Set<Integer> listWithoutDuplicates = new LinkedHashSet<>(arrayList);
        arrayList.clear();
        arrayList.addAll(listWithoutDuplicates);
    }
}
//TODO: Only take id and remove duplicate id then add remining ids back to arraylist
//assign row id using short and use row id instead of employee id???
