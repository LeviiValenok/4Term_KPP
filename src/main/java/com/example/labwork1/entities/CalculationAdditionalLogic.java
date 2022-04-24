package com.example.labwork1.entities;

import java.util.List;

public class CalculationAdditionalLogic {
    public int calculateSumOfResult(List<Integer> resultList) {
        int sum = 0;
        if (!resultList.isEmpty()) {
            sum = resultList.stream().mapToInt(Integer::intValue).sum();
        }
        return sum;
    }

}
