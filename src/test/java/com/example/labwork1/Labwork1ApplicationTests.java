package com.example.labwork1;

import com.example.labwork1.entities.Calculation;
import com.example.labwork1.entities.CalculationParametres;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.labwork1.controller.CalculationController;
import com.example.labwork1.exception.CustomException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class Labwork1ApplicationTests {

    private final CalculationController calculationController = new CalculationController();

    @Test

    void testCalculateResultPlus_10() throws CustomException {
        var sum = new Calculation(new CalculationParametres(11, 0, 0, 0, 10));
        sum.calculateRoot();
        assertThat(sum.getRoot()).isEqualTo(21);
    }

    @Test
    void testCalculateResultPlus_1() throws CustomException {
        var sum = new Calculation(new CalculationParametres(11, 0, 0, 1, 0));
        sum.calculateRoot();
        assertThat(sum.getRoot()).isEqualTo(12);


    }

    @Test
    void testCalculateResultMinus_1() throws CustomException {
        var sum = new Calculation(new CalculationParametres(11, -1, 0, 0, 0));
        sum.calculateRoot();
        assertThat(sum.getRoot()).isEqualTo(10);
    }

    @Test
    void testCalculateResultMinus_10() throws CustomException {
        var sum = new Calculation(new CalculationParametres(11, 0, 0, -10, 0));
        sum.calculateRoot();
        assertThat(sum.getRoot()).isEqualTo(1);
    }


}

