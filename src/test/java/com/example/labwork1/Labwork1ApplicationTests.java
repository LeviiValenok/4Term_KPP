package com.example.labwork1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.labwork1.controller.CalculationController;
import com.example.labwork1.exception.CustomException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class Labwork1ApplicationTests {

    private final CalculationController calculationController = new CalculationController();
//    private final Calculation calculation = new Calculation();
    @Test

    void testCalculateResultPlus_10() throws CustomException {
    int result = calculationController.simpleCalculation("11", "0", "0", "0", "10");
    int expected = 21;

    assertEquals(expected, result);
    }

    @Test
    void testCalculateResultPlus_1() throws CustomException {
        int result = calculationController.simpleCalculation("11", "0", "0", "1", "0");
        int expected = 12;

        assertEquals(expected, result);


    }

    @Test
    void testCalculateResultMinus_1() throws CustomException {
        int result = calculationController.simpleCalculation("11", "-1", "0", "0", "0");
        int expected = 10;

        assertEquals(expected, result);
    }

    @Test
    void testCalculateResultMinus_10() throws CustomException {
        int result = calculationController.simpleCalculation("11", "0", "-10", "0", "0");
        int expected = 1;

        assertEquals(expected, result);
    }


}

