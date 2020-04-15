package array;

/**
 * Date 15.04.2020.
 *
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        int[] left = new int[len];
        res[0] = left[len-1] = 1;

        for (int i = 1; i < len; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        for (int i = len-2; i >= 0; i--) {
            left[i] = left[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++)
            res[i] = res[i] * left[i];

        return res;
    }
}
