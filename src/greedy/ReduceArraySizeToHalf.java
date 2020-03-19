package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Date 19.03.2020.
 *
 *  1338. Reduce Array Size to The Half
 *
 *  Given an array arr.  You can choose a set of integers and
 *  remove all the occurrences of these integers in the array.
 *
 * Return the minimum size of the set so that at least
 * half of the integers of the array are removed.
 *
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());

        pq.addAll(map.entrySet());

        int res = 0;
        int len = arr.length/2;

        while(len > 0) {
            Map.Entry<Integer, Integer> entry = pq.remove();
            int value = entry.getValue();

            len -= value;
            res++;
        }

        return res;
    }
}
