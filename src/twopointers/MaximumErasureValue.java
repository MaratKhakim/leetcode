package twopointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 28.05.2021.
 *
 * 1695. Maximum Erasure Value
 *
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 * https://leetcode.com/problems/maximum-erasure-value/
 */

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int res = 0, sum = 0;
        int st = 0;
        Set<Integer> set = new HashSet<>();

        for (int end = 0; end < len; end++) {
            if (set.contains(nums[end])) {

                res = Math.max(res, sum);

                do {
                    sum -= nums[st];
                    set.remove(nums[st]);
                } while (nums[st++] != nums[end]);
            }

            sum += nums[end];
            set.add(nums[end]);
        }

        return Math.max(res, sum);
    }
}
