package com.example.labwork1.controller;

import com.example.labwork1.counter.RequestCounter;
import com.example.labwork1.cache.CalculationCache;
import com.example.labwork1.entities.CalculationParametres;
import com.example.labwork1.validation.InputValidation;
import com.example.labwork1.entities.Calculation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.labwork1.entities.CalculationAdditionalLogic;

import com.example.labwork1.exception.CustomException;

import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@RestController

public class CalculationController {

   // RequestCounterController calls = new RequestCounterController();
    RequestCounter requestCounter = new RequestCounter();
   InputValidation validation = new InputValidation();
   private static final Logger logger = LogManager.getLogger(CalculationController.class);
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

    @PostMapping(value = "/calculation",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sum(@RequestBody String[] arr) {

       logger.info("post mappping is successful");
       CalculationAdditionalLogic calculationAdditionalLogic = new CalculationAdditionalLogic() ;
       return new ResponseEntity<>("Sum: " + calculationAdditionalLogic.calculateSumOfResult(arr) + "\nSum of parametres: " +
               calculationAdditionalLogic.SumOfParametres(arr), HttpStatus.OK);
    }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(CalculationCache.getStaticStringCache(), HttpStatus.OK);
   }


}
