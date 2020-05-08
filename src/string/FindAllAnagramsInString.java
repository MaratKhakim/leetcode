package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 08.05.2020.
 *
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        List<Integer> indices = new ArrayList<>();

        if (lenP > lenS)
            return indices;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        int counter = map.size();
        int st = 0, end = 0;

        while(end < lenS) {
            char curr = s.charAt(end++);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)-1);

                if (map.get(curr) == 0)
                    counter--;
            }

            while(counter == 0) {
                char temp = s.charAt(st);

                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp)+1);
                    if (map.get(temp) > 0)
                        counter++;
                }

                if (end-st == lenP)
                    indices.add(st);

                st++;
            }
        }

        return indices;
    }
}
