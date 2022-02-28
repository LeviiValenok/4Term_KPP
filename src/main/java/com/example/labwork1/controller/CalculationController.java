package com.example.labwork1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwork1.entities.Calculation;

@RestController

public class CalculationController {
   @GetMapping("/simplecalculation")
   Calculation simpleCalculation (@RequestParam (value = "number", defaultValue = "0") String number,
                                  @RequestParam (value = "firstOption", defaultValue = "0")String firstOption,
                                  @RequestParam (value = "secondOption", defaultValue = "0") String secondOption,
                                  @RequestParam (value = "thirstOption", defaultValue = "0") String thirstOption,
                                  @RequestParam (value = "fourthOption", defaultValue = "0") String fourthOption)
   {
       int result = 0;
       int sum = 0;
        if (Integer.parseInt(firstOption)== -1)
        {
            sum += Integer.parseInt(firstOption);
        }
        if (Integer.parseInt(secondOption)== -10)
        {
            sum  += Integer.parseInt(secondOption);
        }
        if (Integer.parseInt(thirstOption)== 1)
        {
            sum +=  Integer.parseInt(thirstOption);
        }
        if (Integer.parseInt(fourthOption)== 10)
        {
            sum +=  Integer.parseInt(fourthOption);
        }
        result = Integer.parseInt(number) + sum;

        return new Calculation(result);
   }

}
