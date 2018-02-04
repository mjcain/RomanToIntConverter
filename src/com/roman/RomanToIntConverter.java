package com.roman;

import java.util.*;
import static java.util.Map.entry;

public class RomanToIntConverter {
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "Input provided is not valid. Please try again.";
    private static final int MAX_ROMAN_INTEGER = 3999;
    private static final Map<Character, Integer> numeralTable = Map.ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000));

    public static int convert(String input) {
        if(input == null || input.length() == 0)
        {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        String romanUpper = input.toUpperCase();

        int result = 0;
        int previouslyConvertedInt = -1;
        for(int i = romanUpper.length()-1; i>=0 ; i--)
        {
            Integer convertedInt = convertRomanCharToInt(romanUpper.charAt(i));
            if(convertedInt == null)
            {
                throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
            }
            if(convertedInt < previouslyConvertedInt) {
                result -= convertedInt;
            }
            else {
                result += convertedInt;
            }
            previouslyConvertedInt = convertedInt;
        }
        if(result > MAX_ROMAN_INTEGER) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        return result;
    }

    private static Integer convertRomanCharToInt(char input){
        return numeralTable.get(input);
    }
}
