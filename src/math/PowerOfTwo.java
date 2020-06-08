package math;

/**
 * Date 08.06.2020.
 *
 * 231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * https://leetcode.com/problems/power-of-two/
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while(n%2 == 0)
            n /= 2;

        return n == 1;
    }
}
