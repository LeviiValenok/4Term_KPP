package com.example.labwork1.entities;


import com.example.labwork1.SpringConfig;
import com.example.labwork1.cache.CalculationCache;
import com.example.labwork1.logger.Logger;
import org.apache.logging.log4j.Level;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Calculation {

    private final CalculationCache cache;

    private final CalculationParametres inputParams;

    private Integer root;

    public Calculation(CalculationParametres params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", CalculationCache.class);
        context.close();

        this.inputParams = params;
    }

    public void calculateRoot() {

        var temp = cache.find(inputParams);
        if (temp != null) {
            Logger.log(Level.INFO, "Value found in cache!");
            setRoot(temp);

            return;
        }

        temp = inputParams.getResultValue() + inputParams.getFirstValue() +
                inputParams.getSecondValue()  + inputParams.getThirdValue() + inputParams.getForthValue();

        setRoot(temp);

        cache.add(inputParams, root);
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot( Integer root) {
        this.root = root;
    }

}
