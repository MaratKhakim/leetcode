package array;

/**
 * Date 12.05.2020.
 *
 * 540. Single Element in a Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length-1;

        while(left < right) {
            int mid = left + (right - left)/2;

            if (mid == 0 || mid == nums.length-1)
                return nums[mid];

            if (mid%2 == 0) {
                if (nums[mid] == nums[mid-1]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return nums[left];
    }
}
