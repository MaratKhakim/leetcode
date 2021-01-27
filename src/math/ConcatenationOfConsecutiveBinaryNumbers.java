package math;

/**
 * Date 27.01.2021.
 *
 * 1680. Concatenation of Consecutive Binary Numbers
 *
 * Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.
 *
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            int pow = (int) log2(i) + 1;

            res = ((int) Math.pow(2, pow)) * res%mod + i%mod;
        }

        return (int) res;
    }

    private double log2(int num) {
        return Math.log(num)/Math.log(2);
    }
}
