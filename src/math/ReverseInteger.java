package math;

/**
 * Date 27.05.2020.
 *
 * 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);

        int num = 0;

        while(x > 0) {
            if (Integer.MAX_VALUE/10 < num)
                return 0;

            num = 10*num + x%10;
            x /= 10;
        }

        return isNegative? -num : num;
    }
}
