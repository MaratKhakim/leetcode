package heap;

import java.util.*;

/**
 * Date 08.04.2020.
 *
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * https://leetcode.com/problems/top-k-frequent-words/
 */

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> res = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b ) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey().compareTo(a.getKey()));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if (pq.size() > k)
                pq.poll();
        }

        while(!pq.isEmpty()) {
            res.addFirst(pq.poll().getKey());
        }

        return res;
    }
}
