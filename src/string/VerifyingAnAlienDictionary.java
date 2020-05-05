package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 05.05.2020.
 *
 * 953. Verifying an Alien Dictionary
 *
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);

        for (int k = 1; k < words.length; k++) {
            String first = words[k-1];
            String sec = words[k];

            if (!isSorted(first, sec, map))
                return false;
        }

        return true;
    }

    private boolean isSorted(String first, String sec, Map<Character, Integer> map) {
        int i = 0;

        while(i < first.length() && i < sec.length()) {
            if (first.charAt(i) != sec.charAt(i))
                return map.get(first.charAt(i)) <= map.get(sec.charAt(i));
            i++;
        }

        return sec.length() > first.length();
    }
}
