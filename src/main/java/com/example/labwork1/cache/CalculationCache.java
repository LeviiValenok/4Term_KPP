package com.example.labwork1.cache;

import com.example.labwork1.entities.CalculationParametres;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.example.labwork1.logger.MyLogger;

import java.util.HashMap;
import java.util.Map;

public class CalculationCache {

    private static final Map<CalculationParametres, Integer> solutions = new HashMap<>();

    public void add(@NotNull CalculationParametres params, @NotNull Integer root) {
        if (!solutions.containsKey(params)) {
            solutions.put(params, root);
            MyLogger.log(Level.INFO, "Value " + params + "@" + root + " added to cache!");
        }
    }

    public @Nullable Integer find(@NotNull CalculationParametres params) {
        if (solutions.containsKey(params))
            return solutions.get(params);

        MyLogger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

    @Contract(pure = true)
    public @NotNull String getStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public static @NotNull String getStaticStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public Map<CalculationParametres, Integer> getSolutions() {
        return solutions;
    }
}