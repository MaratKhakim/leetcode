package string;

/**
 * Date 07.05.2020.
 *
 * 680. Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * https://leetcode.com/problems/valid-palindrome-ii/
 */

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;

        return validPalindrome(s, 0, s.length()-1, 1);
    }

    private boolean validPalindrome(String s, int st, int end, int k) {
        if (k < 0)
            return false;

        while(st < end && s.charAt(st) == s.charAt(end)) {
            st++;
            end--;
        }

        if (st >= end)
            return true;

        return validPalindrome(s, st+1, end, k-1) || validPalindrome(s, st, end-1, k-1);
    }
}
