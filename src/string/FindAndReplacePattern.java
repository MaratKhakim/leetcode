package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. Find and Replace Pattern
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 * https://leetcode.com/problems/find-and-replace-pattern/
 */

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);

                if (map.containsKey(p)) {
                    if (w != map.get(p))
                        break;
                } else {
                    if (map.containsValue(w))
                        break;

                    map.put(p, w);
                }

                if (i == word.length()-1)
                    res.add(word);
            }
        }

        return res;
    }
}
