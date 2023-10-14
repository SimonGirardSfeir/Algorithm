package org.girardsimon.problem9;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class PalindromeResolver {
    private PalindromeResolver() {
    }
    /**
     * Checks if a given number is a palindrome.
     * <p>
     * Constraints:<br>
     * • -2³¹ ≤ x ≤ 2³¹ - 1<br>
     *
     * @param x the number to check for palindrome
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int x){
        if(x < 0 || (x > 0 && x % DECIMAL == 0))
            return false;
        else {
            int current = x;
            int right = x % DECIMAL;

            while(current > right) {
                current /= DECIMAL;
                right = right * DECIMAL + lastDigit(current);
            }
            return (current == right) ||(current == right/DECIMAL);
        }
    }
    private static int lastDigit(int n) {
        return n % DECIMAL;
    }
}
