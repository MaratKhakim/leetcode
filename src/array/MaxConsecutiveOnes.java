package array;

/**
 * Date 28.06.2020.
 *
 * 485. Max Consecutive Ones
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * https://leetcode.com/problems/max-consecutive-ones/
 */

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
