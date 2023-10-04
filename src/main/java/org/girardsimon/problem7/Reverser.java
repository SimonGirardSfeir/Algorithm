package org.girardsimon.problem7;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class Reverser {
    private Reverser() {
    }
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
