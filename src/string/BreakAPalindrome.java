package string;

/**
 * Date 27.11.2020.
 *
 * 1328. Break a Palindrome
 *
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that
 * the string becomes the lexicographically smallest possible string that isn't a palindrome.
 *
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 *
 * https://leetcode.com/problems/break-a-palindrome/
 */

public class BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1)
            return "";

        char[] arr = palindrome.toCharArray();
        int i = 0;

        while(i < len/2) {
            if (arr[i] != 'a')
                break;
            i++;
        }

        if (i != len/2)
            arr[i] = 'a';
        else
            arr[len-1] = 'b';

        return new String(arr);
    }
}
