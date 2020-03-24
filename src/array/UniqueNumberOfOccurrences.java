package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date 24.03.2020.
 *
 *  1207. Unique Number of Occurrences
 *
 *  Given an array of integers arr, write a function that returns true if and only if
 *  the number of occurrences of each value in the array is unique.
 *
 *  https://leetcode.com/problems/unique-number-of-occurrences/
 */

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0)+1);

        for (int num : map.values())
            if (!set.add(num))
                return false;

        return true;
    }
}
