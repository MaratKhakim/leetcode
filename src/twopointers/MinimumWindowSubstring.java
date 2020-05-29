package twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 29.05.2020.
 *
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS < lenT)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        int count = map.size();
        int st = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;

        while(end < s.length()) {
            char curr = s.charAt(end++);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)-1);
                if (map.get(curr) == 0)
                    count--;
            }

            while(count == 0) {
                char beg = s.charAt(st);

                if (map.containsKey(beg)) {
                    map.put(beg, map.get(beg)+1);
                    if (map.get(beg) > 0)
                        count++;
                }

                if (end-st < min) {
                    min = end-st;
                    index = st;
                }
                st++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(index, index+min);
    }
}
