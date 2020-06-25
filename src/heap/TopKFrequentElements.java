package heap;

import java.util.*;

/**
 * Date 25.06.2020.
 *
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Integer num = nums[i];

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));

        for (int key : map.keySet()) {
            pq.add(key);

            if (pq.size() > k)
                pq.remove();
        }

        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }

        return res;
    }
}
