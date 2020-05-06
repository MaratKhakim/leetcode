package array;

/**
 * Date 06.05.2020.
 *
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};

        if (nums == null || nums.length == 0)
            return range;

        int len = nums.length;
        int i = 0, j = len-1;
        int mid = 0;

        while(i <= j) {
            mid = i + (j-i)/2;

            if (nums[mid] == target)
                break;

            if (nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;
        }

        if (i > j)
            return range;

        range[0] = range[1] = mid;

        int lo = 0, hi = mid;

        while(lo <= hi) {
            int middle = lo + (hi-lo)/2;

            if (nums[middle] == target) {
                range[0] = middle;
            }

            if (nums[middle] < target)
                lo = middle+1;
            else
                hi = middle-1;
        }

        lo = mid+1;
        hi = len-1;

        while(lo <= hi) {
            int middle = lo + (hi-lo)/2;

            if (nums[middle] == target) {
                range[1] = middle;
            }

            if (nums[middle] <= target)
                lo = middle+1;
            else
                hi = middle-1;
        }

        return range;
    }
}
