package org.girardsimon.problem8;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class StringToInteger {
    private StringToInteger() {
    }
    /*
    0 <= input.length <= 200
    input consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
     */
    public static int myAtoi(String input) {
        if(input.isBlank() || isNeitherDigitNorSign(input.trim().charAt(0))) {
            return 0;
        }
        int multiplier;
        String trimmedInput = input.trim();

        char firstLetter = trimmedInput.charAt(0);
        int i = 0;

        if(firstLetter == '-') {
            multiplier = -1;
            i++;
        } else if (firstLetter == '+'){
            multiplier = 1;
            i++;
        } else {
            multiplier = 1;
        }

        int output = 0;
        while(i < trimmedInput.length() && isDigit(trimmedInput.charAt(i))) {
            try {
                output = Math.addExact(Math.multiplyExact(output, DECIMAL), trimmedInput.charAt(i) - '0');
                i++;
            } catch (ArithmeticException e) {
                if(multiplier == -1) {
                    output =  Integer.MIN_VALUE;
                } else {
                    output = Integer.MAX_VALUE;
                }
                break;
            }
        }

        return output*multiplier;
    }
    private static boolean isNeitherDigitNorSign(char c) {
        return !isDigit(c) && c != '-' && c != '+';
    }
    private static boolean isDigit(char c) {
        return  c >= '0' && c <= '9';
    }
}
