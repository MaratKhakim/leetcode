package array;

/**
 * Date 04.05.2020.
 *
 * 1122. Relative Sort Array
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * https://leetcode.com/problems/relative-sort-array/
 */

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];

        int len1 = arr1.length;
        int len2 = arr2.length;

        for (int i = 0; i < len1; i++) {
            temp[arr1[i]]++;
        }

        int j = 0;
        int[] res = new int[len1];

        for (int i = 0; i < len2; i++) {
            int num = arr2[i];
            int times = temp[num];

            while (temp[num] != 0) {
                res[j++] = num;
                temp[num]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (temp[i]-- != 0) {
                res[j++] = i;
            }
        }

        return res;
    }
}
