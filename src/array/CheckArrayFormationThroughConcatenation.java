package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 01.01.2021.
 *
 * 1640. Check Array Formation Through Concatenation
 *
 * You are given an array of distinct integers arr and an array of integer arrays pieces,
 * where the integers in pieces are distinct.
 * Your goal is to form arr by concatenating the arrays in pieces in any order. However,
 * you are not allowed to reorder the integers in each array pieces[i].
 *
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 *
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 */

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        int len = arr.length;
        int idx = 0;

        while(idx < len) {
            int curr = arr[idx];

            if (!map.containsKey(curr))
                return false;

            int[] piece = pieces[map.get(curr)];

            for (int i = 0; i < piece.length; i++) {
                if (piece[i] != arr[idx++])
                    return false;
            }
        }

        return true;
    }
}
