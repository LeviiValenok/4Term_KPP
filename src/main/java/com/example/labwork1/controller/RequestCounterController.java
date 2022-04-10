package com.example.labwork1.controller;

import com.example.labwork1.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestCounterController {
        static int calls = 0;

    synchronized public void increasingCalls() {
        calls++;
        MyLogger.log(Level.INFO, "Counter has been increased.");
    }

    @GetMapping("/callsCounter")
    synchronized public String showCalls() {
        MyLogger.log(Level.INFO, "Calls have been done");
        return RequestCounterController.calls + "   calls have been done";
    }
}

