package com.example.labwork1.validation;

import com.example.labwork1.exception.CustomException;

public class InputValidation {
    public static boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;

        }
        catch (NumberFormatException e) {
            return false;
        }

    }
   public static int optionsValidation(String firstOption, String secondOption, String thirdOption, String fourthOption) {
        int sum = 0;
        if ( (isInt(firstOption)) && ((Integer.parseInt(firstOption) == -1 ) || (Integer.parseInt(firstOption) == 0 ))) {
            sum  += Integer.parseInt(firstOption);
        } else {
            throw new CustomException("BAD REQUEST ERROR 400: first option is invalid");
        }
        if ( (isInt(secondOption)) && ((Integer.parseInt(secondOption) == -10 )|| (Integer.parseInt(secondOption) == 0 ))) {
            sum  += Integer.parseInt(secondOption);
        } else {
            throw new CustomException("BAD REQUEST ERROR 400: second option is invalid");
        }
        if ( (isInt(thirdOption)) && ((Integer.parseInt(thirdOption) == 1 ) || (Integer.parseInt(thirdOption) == 0 ))) {
            sum += Integer.parseInt(thirdOption);
        } else {
            throw new CustomException("BAD REQUEST ERROR 400: third option is invalid");
        }
        if ( (isInt(fourthOption)) && ((Integer.parseInt(fourthOption) == 10 ) || (Integer.parseInt(fourthOption) == 0 ))) {
            sum += Integer.parseInt(fourthOption);
        } else {
            throw new CustomException("BAD REQUEST ERROR 400: forth option is invalid");
        }
        return sum;
    }


}
