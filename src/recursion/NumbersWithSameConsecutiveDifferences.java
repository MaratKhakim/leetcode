package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 18.08.2020.
 *
 * 967. Numbers With Same Consecutive Differences
 *
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> res = new HashSet<>();

        if (n == 1)
            res.add(0);

        for (int i = 1; i <= 9; i++) {
            consec(String.valueOf(i), n, k, res);
        }

        int[] nums = new int[res.size()];
        int idx = 0;

        for (int num : res)
            nums[idx++] = num;

        return nums;
    }

    private void consec(String num, int n, int k, Set<Integer> res) {
        if (num.length() == n) {
            res.add(Integer.parseInt(num));
            return;
        }

        int curr = num.charAt(num.length()-1) - '0';

        if (curr+k >= 0 && curr+k <= 9) {
            consec(num+(curr+k), n, k, res);
        }

        if (curr-k >= 0 && curr-k <= 9) {
            consec(num+(curr-k), n, k, res);
        }
    }
}
