package array;

/**
 * Date 22.03.2020.
 *
 *  565. Array Nesting
 *
 *  A zero-indexed array A of length N contains all integers from 0 to N-1.
 *  Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 *
 * Suppose the first element in S starts with the selection of element A[i] of index = i,
 * the next element in S should be A[A[i]], and then A[A[A[i]]]…
 * By that analogy, we stop adding right before a duplicate element occurs in S.
 *
 * https://leetcode.com/problems/array-nesting/
 */

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;

            int idx = i;
            int size = 0;

            while(nums[idx] != -1) {
                size++;
                int temp = nums[idx];
                nums[idx] = -1;
                idx = temp;
            }

            res = Math.max(res, size);
        }

        return res;
    }
}
