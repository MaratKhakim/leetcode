package twopointers;

/**
 * Date 09.06.2020.
 *
 * 392. Is Subsequence
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * https://leetcode.com/problems/is-subsequence/
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && s.charAt(j) == t.charAt(i))
                j++;
        }

        return j == s.length();
    }
}
