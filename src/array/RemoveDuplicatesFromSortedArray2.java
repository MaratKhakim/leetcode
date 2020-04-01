package array;

/**
 * Date 01.04.2020.
 *
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int idx = 1;
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                if (counter++ < 2) {
                    nums[idx++] = nums[i];
                }
            } else {
                counter = 1;
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
