package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 18.01.2021.
 *
 * 1679. Max Number of K-Sum Pairs
 *
 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 *
 * Constraints:
 *      # 1 <= nums.length <= 105
 *      # 1 <= nums[i] <= 109
 *      # 1 <= k <= 109
 *
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num < k)
                map.put(k-num, map.getOrDefault(k-num, 0)+1);
        }

        int count = 0;

        for (int num : nums) {
            if (num >= k)
                continue;

            if (map.containsKey(num)) {
                if (num == k-num) {
                    count += map.get(num)/2;
                    map.remove(num);
                } else {
                    count += Math.min(map.get(num), map.get(k-num));
                    map.remove(num);
                    map.remove(k-num);
                }
            }
        }

        return count;
    }
}
