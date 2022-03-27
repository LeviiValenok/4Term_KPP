package com.example.labwork1;

import com.example.labwork1.cache.CalculationCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean("cache")
    @Scope(value = "singleton")
    CalculationCache cache() {
        return new CalculationCache();
    }

}