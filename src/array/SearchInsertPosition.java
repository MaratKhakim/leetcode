package array;

/**
 * Date 10.06.2020.
 *
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1;

        while(i <= j) {
            int mid = i + (j-i)/2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;
        }

        return i;
    }
}
