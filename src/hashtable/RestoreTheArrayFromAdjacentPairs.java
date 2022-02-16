package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date 16.02.2022.
 *
 * 1743. Restore the Array From Adjacent Pairs
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */

public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] pairs) {
        int n = pairs.length+1;
        Map<Integer, Set<Integer>> map = getMap(pairs);
        int curr = 0;

        for (int key : map.keySet()) {
            Set<Integer> set = map.get(key);

            if (set.size() == 1) {
                curr = key;
                break;
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = curr;
            Set<Integer> set = map.get(curr);

            if (!set.isEmpty()) {
                int next = set.iterator().next();
                map.get(next).remove(curr);
                curr = next;
            }
        }

        return res;
    }

    private Map<Integer, Set<Integer>> getMap(int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] pair : pairs) {
            int first = pair[0], sec = pair[1];
            map.putIfAbsent(first, new HashSet<>());
            map.putIfAbsent(sec, new HashSet<>());

            map.get(first).add(sec);
            map.get(sec).add(first);
        }

        return map;
    }
}
