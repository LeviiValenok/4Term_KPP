package com.example.labwork1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.labwork1.exception.CustomException;

@RestController

public class CalculationController {
    private static boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;

        }
        catch (NumberFormatException e) {
            return false;
        }
    }
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
       if (isInt(number)) {
           numberInt = Integer.parseInt(number);
       } else {
           throw new CustomException("BAD REQUEST");
       }
       int firstOptionInt = 0, secondOptionInt = 0, thirstOptionInt = 0, fourthOptionInt = 0;

       if ( (isInt(firstOption)) && ((Integer.parseInt(firstOption) == -1 ) || (Integer.parseInt(firstOption) == 0 ))) {
           sum  += Integer.parseInt(firstOption);
       } else {
           throw new CustomException("BAD REQUEST");
       }
       if ( (isInt(secondOption)) && ((Integer.parseInt(secondOption) == -10 )|| (Integer.parseInt(secondOption) == 0 ))) {
           sum  += Integer.parseInt(secondOption);
       } else {
           throw new CustomException("BAD REQUEST");
       }
       if ( (isInt(thirdOption)) && ((Integer.parseInt(thirdOption) == 1 ) || (Integer.parseInt(thirdOption) == 0 ))) {
           sum += Integer.parseInt(thirdOption);
       } else {
           throw new CustomException("BAD REQUEST");
       }
       if ( (isInt(fourthOption)) && ((Integer.parseInt(fourthOption) == 10 ) || (Integer.parseInt(fourthOption) == 0 ))) {
           sum += Integer.parseInt(fourthOption);
       } else {
           throw new CustomException("BAD REQUEST");
       }
       result = numberInt + sum;
       return result;
   }

}
