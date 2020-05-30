package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 30.05.2020.
 *
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *  - Each of the array element will not exceed 100.
 *  - The array size will not exceed 200.
 *
 *  https://leetcode.com/problems/partition-equal-subset-sum/
 */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums)
            total += num;

        if (total%2 == 1)
            return false;

        return canPartition(nums, 0, 0, total, new HashMap<>());
    }

    public boolean canPartition(int[] nums, int idx, int sum, int total, Map<String, Boolean> map) {

        String encoded = idx+"*"+sum;

        if (map.containsKey(encoded))
            return map.get(encoded);

        if (2*sum == total)
            return true;

        if (sum > total/2 || idx >= nums.length)
            return false;

        boolean found = canPartition(nums, idx+1, sum, total, map) || canPartition(nums, idx+1, sum+nums[idx], total, map);

        map.put(encoded, found);

        return found;
    }
}
