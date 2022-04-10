package com.example.labwork1.logger;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class MyLogger {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MyLogger.class);

    public static void log(Level level, Object message) {
        logger.log(level, message);
    }

}