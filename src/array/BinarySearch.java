package array;

/**
 * Date 19.06.2020.
 *
 * 704. Binary Search
 *
 * Given a sorted (in ascending order) integer array nums of n elements
 * and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 *
 * https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}
