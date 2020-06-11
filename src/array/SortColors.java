package array;

/**
 * Date 11.06.2020.
 *
 * 75. Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * https://leetcode.com/problems/sort-colors/
 */

public class SortColors {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];

        for (int num : nums)
            arr[num]++;

        int idx = 0;

        for (int i = 0; i < 3; i++) {
            int freq = arr[i];

            while(freq-- > 0) {
                nums[idx++] = i;
            }
        }
    }
}
