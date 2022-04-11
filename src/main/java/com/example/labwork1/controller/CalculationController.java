package com.example.labwork1.controller;

import com.example.labwork1.counter.RequestCounter;
import com.example.labwork1.cache.CalculationCache;
import com.example.labwork1.entities.CalculationParametres;
import com.example.labwork1.validation.InputValidation;
import com.example.labwork1.entities.Calculation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.labwork1.exception.CustomException;


@RestController

public class CalculationController {

   // RequestCounterController calls = new RequestCounterController();
    RequestCounter requestCounter = new RequestCounter();
   InputValidation validation = new InputValidation();
   @GetMapping("/simplecalculation")
   public ResponseEntity<Object> simpleCalculation (@RequestParam (value = "resultNumber", defaultValue = "0")String resultNumber,
                                  @RequestParam (value = "firstOption", defaultValue = "0") String firstOption,
                                  @RequestParam (value = "secondOption", defaultValue = "0")String secondOption,
                                  @RequestParam (value = "thirdOption", defaultValue = "0") String thirdOption,
                                  @RequestParam (value = "fourthOption", defaultValue = "0") String fourthOption) throws CustomException
   {
       if (InputValidation.isInt(resultNumber)) {
           int result = Integer.parseInt(resultNumber);
       } else {
           throw new CustomException("BAD REQUEST ERROR 400: incorrect input");
       }

       InputValidation.optionsValidation(firstOption, secondOption, thirdOption, fourthOption);
       var calculation = new Calculation(new CalculationParametres(Integer.parseInt(resultNumber), Integer.parseInt(firstOption),
               Integer.parseInt(secondOption), Integer.parseInt(thirdOption), Integer.parseInt(fourthOption)));

       requestCounter.increment();
       calculation.calculateRoot();

       return new ResponseEntity<>(calculation.getRoot(), HttpStatus.OK);
   }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(CalculationCache.getStaticStringCache(), HttpStatus.OK);
   }


}
