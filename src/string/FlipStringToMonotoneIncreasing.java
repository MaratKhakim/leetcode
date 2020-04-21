package string;

/**
 * Date 21.04.2020.
 *
 * 926. Flip String to Monotone Increasing
 *
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0),
 * followed by some number of '1's (also possibly 0.)
 *
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 *
 * Return the minimum number of flips to make S monotone increasing.
 *
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int ones = 0;
        int zeros = 0;

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '1') {
                ones++;
            } else if (ones > 0) {
                zeros++;

                if (zeros > ones) {
                    res += ones;
                    ones = 0;
                    zeros = 0;
                }
            }
        }

        res += Math.min(ones, zeros);

        return res;
    }
}
