package org.girardsimon.problem8;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class StringToInteger {
    private StringToInteger() {
    }
    /**
     * Converts a string representation of an integer to an actual integer value.
     * <p>
     * Rules:<br>
     * • Leading whitespace should be ignored<br>
     * • The next character could be (if not already at the end of the string) '-' or '+' and determines
     *   if the final result is negative or positive respectively. If no sign, the result is positive.<br>
     * • Only characters until the next non-digit character or the end of the input are considered.
     * Other are ignored.<br>
     * • Considered characters are converted to an integer. If no characters here, result should be 0.<br>
     * • Overflow is possible. integers less than -2³¹ are clamped to -2³¹,
     *   and integers greater than 2³¹ - 1 are clamped to 2³¹ - 1<br>
     *  <p>
     * Constraints:<br>
     * • 0 ≤ input.length ≤ 200<br>
     * • input consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.<br>
     *
     * @param input the input string to be converted
     * @return the converted integer value
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
