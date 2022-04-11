package com.example.labwork1.counter;


import com.example.labwork1.controller.RequestCounterController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestCounter {
    Logger logger = LogManager.getLogger(RequestCounter.class);
    private static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static Integer getCounter() {
        return counter;
    }
}