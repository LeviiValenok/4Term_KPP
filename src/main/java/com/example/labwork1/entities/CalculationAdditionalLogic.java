package com.example.labwork1.entities;

import java.util.List;
import java.util.stream.Stream;

public class CalculationAdditionalLogic {
    public int calculateSumOfResult(String[] arr) {
        int sum = 0;

            sum = Stream.of(arr).mapToInt(Integer::parseInt).sum();

        return sum;
    }

}
