package twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 18.05.2020.
 *
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * https://leetcode.com/problems/permutation-in-string/
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        int counter = map.size();
        int st = 0, end = 0;

        while(end < s2.length()) {
            char curr = s2.charAt(end++);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)-1);
                if (map.get(curr) == 0)
                    counter--;
            }

            while(counter == 0) {
                char stChar = s2.charAt(st);

                if (map.containsKey(stChar)) {
                    if (map.get(stChar) == 0)
                        counter++;
                    map.put(stChar, map.get(stChar)+1);
                }

                if (end - st == s1.length())
                    return true;

                st++;
            }
        }

        return false;
    }
}
