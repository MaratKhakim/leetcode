package recursion;

/**
 * Date 24.06.2020.
 *
 * 397. Integer Replacement
 *
 * Given a positive integer n and you can do operations as follow:
 *  - If n is even, replace n with n/2.
 *  - If n is odd, you can replace n with either n + 1 or n - 1.
 *
 * What is the minimum number of replacements needed for n to become 1?
 *
 * https://leetcode.com/problems/integer-replacement/
 */

public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == 1)
            return 0;

        if (n == Integer.MAX_VALUE)
            return integerReplacement(n-1);

        if (n%2 == 0)
            return 1 + integerReplacement(n/2);

        return 1 + Math.min(integerReplacement(n-1), integerReplacement(n+1));
    }
}
