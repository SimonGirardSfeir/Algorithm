package org.girardsimon.problem9;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class PalindromeResolver {
    private PalindromeResolver() {
    }
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
