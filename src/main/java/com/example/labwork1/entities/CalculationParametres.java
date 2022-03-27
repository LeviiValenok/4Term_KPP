package com.example.labwork1.entities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CalculationParametres {

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        CalculationParametres params = (CalculationParametres) obj;

        return  Objects.equals(resultValue, params.resultValue) &&
                Objects.equals(firstValue,  params.firstValue)  &&
                Objects.equals(secondValue, params.secondValue) &&
                Objects.equals(thirdValue,  params.thirdValue)  &&
                Objects.equals(forthValue, params.forthValue);
    }


    @Override
    public int hashCode() {
        return Objects.hash(resultValue, firstValue, secondValue, thirdValue, forthValue);
    }

    private @Nullable Integer resultValue;

    private @Nullable Integer firstValue;

    private @Nullable Integer secondValue;

    private @Nullable Integer thirdValue;

    private @Nullable Integer forthValue;

    public CalculationParametres(
            @Nullable Integer resultValue,
            @Nullable Integer firstValue,
            @Nullable Integer secondValue,
            @Nullable Integer thirdValue,
            @Nullable Integer forthValue
    ) {
        if (firstValue == null && secondValue == null && thirdValue == null && forthValue == null) {
            firstValue = 0;
            secondValue = 0;
            thirdValue = 0;
            forthValue = 0;
        }

        if (firstValue == null)
            firstValue = 0;

        if (secondValue == null)
            secondValue = 0;

        if (thirdValue == null)
            thirdValue = 0;

        if (forthValue == null)
            forthValue = 0;

        this.resultValue = resultValue;
        this.firstValue  = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.forthValue = forthValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getResultValue() {
        assert resultValue != null;
        return resultValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getFirstValue() {
        assert firstValue != null;
        return firstValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getSecondValue() {
        assert secondValue != null;
        return secondValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getThirdValue() {
        assert thirdValue != null;
        return thirdValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getForthValue() {
        assert forthValue != null;
        return forthValue;
    }

    public void setResultValue(@NotNull Integer firstValue) {
        this.firstValue = firstValue;
    }

    public void setFirstValue(@NotNull Integer firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(@NotNull Integer secondValue) {
        this.secondValue = secondValue;
    }

    public void setThirdValue(@NotNull Integer thirdValue) {
        this.thirdValue = thirdValue;
    }

    public void setForthValue(@NotNull Integer forthValue) {
        this.forthValue = forthValue;
    }
}