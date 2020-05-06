package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date 06.05.2020.
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *  - The same word in the dictionary may be reused multiple times in the segmentation.
 *  - You may assume the dictionary does not contain duplicate words.
 *
 *  https://leetcode.com/problems/word-break/
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wordBreak(s, 0, dict, new HashSet<>());
    }

    public boolean wordBreak(String s, int idx, Set<String> dict, Set<Integer> set) {
        if (idx == s.length())
            return true;

        if (set.contains(idx))
            return false;

        for (int i = idx; i < s.length(); i++) {
            if (dict.contains(s.substring(idx, i+1)) && wordBreak(s, i+1, dict, set)) {
                return true;
            }
        }

        set.add(idx);

        return false;
    }
}
