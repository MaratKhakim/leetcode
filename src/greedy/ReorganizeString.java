package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Date 05.05.2020.
 *
 * 767. Reorganize String
 *
 * Given a string S, check if the letters can be rearranged so that two characters
 * that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * https://leetcode.com/problems/reorganize-string/
 */

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        pq.addAll(map.keySet());

        char first = pq.peek();
        if (map.get(first) > Math.ceil(s.length()/2.0))
            return "";

        char[] arr = new char[s.length()];
        int idx = 0;

        char maxChar = pq.poll();
        int maxCharFreq = map.get(maxChar);

        while(maxCharFreq-- != 0) {
            arr[idx] = maxChar;
            idx += 2;
        }

        while(!pq.isEmpty()) {
            char curr = pq.poll();
            int freq = map.get(curr);

            while(freq-- != 0) {
                if (idx >= arr.length)
                    idx = 1;
                arr[idx] = curr;
                idx += 2;
            }
        }


        return new String(arr);
    }
}
