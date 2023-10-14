package org.girardsimon.problem7;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class Reverser {
    private Reverser() {
    }
    /**
     * Reverses the digits of an integer number.
     * <p>
     * Constraints:<br>
     * • -2³¹ ≤ x ≤ 2³¹ - 1<br>
     *
     * @param x the number to be reversed
     * @return the reversed number
     *         If the operation overflows, it returns 0.
     */
    public static int reverse(int x) {
        int output = 0;
        while(x != 0) {
            int carry = x % DECIMAL;
            x/=DECIMAL;
            try {
                output = Math.addExact(Math.multiplyExact(DECIMAL,output),carry);
            } catch(ArithmeticException e) {
                return 0;
            }
        }
        return output;
    }
}
