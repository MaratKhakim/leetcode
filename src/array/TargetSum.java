package array;

/**
 * Date 08.04.2020.
 *
 * 494. Target Sum
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * https://leetcode.com/problems/target-sum/
 */

public class TargetSum {
    int res = 0;

    public int findTargetSumWays(int[] nums, int s) {
        findSum(nums, 0, s);
        return res;
    }

    private void findSum(int[] nums, int idx, int s) {

        if (idx == nums.length) {
            if (s == 0)
                res++;
            return;
        }

        int curr = nums[idx];
        findSum(nums, idx+1, s+curr);
        findSum(nums, idx+1, s-curr);
    }
}
