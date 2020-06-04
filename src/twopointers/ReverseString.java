package twopointers;

/**
 * Date 04.06.2020.
 *
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * https://leetcode.com/problems/reverse-string/
 */

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;

        while(i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
