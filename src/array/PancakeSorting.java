package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 16.05.2020.
 *
 * 969. Pancake Sorting
 *
 * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length,
 * then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips
 * (doing them one after another in succession) to sort the array A.
 *
 * Return the k-values corresponding to a sequence of pancake flips that sort A.
 * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 *
 * https://leetcode.com/problems/pancake-sorting/
 */

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int k = A.length;

        while(k != 1) {
            int idx = 0;

            while(A[idx] != k)
                idx++;

            result.add(idx+1);
            flip(A, idx+1);

            result.add(k);
            flip(A, k--);
        }

        return result;
    }

    public void flip(int[] arr, int k) {
        int i = 0, j = k-1;

        while(i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
