package intervals;

import java.util.Arrays;

/**
 * Date 02.04.2020.
 *
 *  646. Maximum Length of Pair Chain
 *
 *  You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;

        int res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int end = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (end < pair[0]) {
                end = pair[1];
                res++;
            }
        }

        return res;
    }
}
