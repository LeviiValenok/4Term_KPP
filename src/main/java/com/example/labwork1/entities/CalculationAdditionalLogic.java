package com.example.labwork1.entities;

import java.util.List;
import java.util.stream.Stream;

public class CalculationAdditionalLogic {
    public int calculateSumOfResult(String[] arr) {
        int sum = 0;

            sum = Stream.of(arr).mapToInt(Integer::parseInt).sum();

        return sum;
    }

    public int SumOfParametres(String[] arr) {
       SumOfParametresInterface temp;
       temp = (minus1, minus10, plus1, plus10) -> minus1+minus10+plus1+plus10;
       int sum = temp.sum(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
               Integer.parseInt(arr[4]));
       return sum;
    }

    interface SumOfParametresInterface{
        int sum(int minus1, int minus10, int plus1, int plus10);
    }
}


