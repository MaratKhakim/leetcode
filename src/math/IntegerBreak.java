package math;

/**
 * Date 25.03.2020.
 *
 * 343. Integer Break
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and
 * maximize the product of those integers. Return the maximum product you can get.
 *
 * https://leetcode.com/problems/integer-break/
 */

public class IntegerBreak {
    public int integerBreak(int n) {
        double res = 0;

        if (n < 4)
            return n-1;

        int dividend = n/3;
        int rem = n%3;

        if (rem == 1)
            res = Math.pow(3, dividend-1) * 4;
        else if (rem == 2)
            res = Math.pow(3, dividend) * 2;
        else
            res = Math.pow(3, dividend);

        return (int) res;
    }
}
