package twopointers;

/**
 * Date 23.05.2020.
 *
 * 125. Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * https://leetcode.com/problems/valid-palindrome/
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        int i = 0, j = s.length()-1;

        while(i < j) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }

            if (left != right)
                return false;

            i++;
            j--;
        }

        return true;
    }
}
