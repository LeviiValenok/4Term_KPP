package com.example.labwork1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwork1.exception.CustomException;
import com.example.labwork1.validation.InputValidation;

@RestController

public class CalculationController {
//   InputValidation validation = new InputValidation();
   @GetMapping("/simplecalculation")
   public int simpleCalculation (@RequestParam (value = "number", defaultValue = "0") String number,
                                  @RequestParam (value = "firstOption", defaultValue = "0")String firstOption,
                                  @RequestParam (value = "secondOption", defaultValue = "0") String secondOption,
                                  @RequestParam (value = "thirdOption", defaultValue = "0") String thirdOption,
                                  @RequestParam (value = "fourthOption", defaultValue = "0") String fourthOption) throws CustomException
   {
       int result = 0;
       int sum = 0;
       int numberInt =0;
       if (InputValidation.isInt(number)) {
           numberInt = Integer.parseInt(number);
       } else {
           throw new CustomException("BAD REQUEST ERROR 400: incorrect input");
       }
       int firstOptionInt = 0, secondOptionInt = 0, thirstOptionInt = 0, fourthOptionInt = 0;
       sum = InputValidation.optionsValidation(firstOption, secondOption, thirdOption, fourthOption);
       result = numberInt + sum;
       return result;
   }

}
