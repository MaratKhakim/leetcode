package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 04.02.2021.
 *
 * 594. Longest Harmonious Subsequence
 *
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int max = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key+1)) {
                max = Math.max(max, map.get(key)+map.get(key+1));
            }
        }

        return max;
    }
}
