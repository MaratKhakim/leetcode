package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 15.12.2020.
 *
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partition(String s, int idx, List<String> list, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx+1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                partition(s, i, list, res);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;

        while(i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }

        return true;
    }
}
