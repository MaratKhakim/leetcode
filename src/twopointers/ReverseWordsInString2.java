package twopointers;

/**
 * Date 08.07.2021.
 *
 * 186. Reverse Words in a String II
 *
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */

public class ReverseWordsInString2 {
    public void reverseWords(char[] s) {
        int len = s.length;
        int left = 0;


        while (left < len) {
            int right = left+1;

            while (right < len && s[right] != ' ') {
                right++;
            }

            swap(s, left, right-1);
            left = right+1;
        }

        swap(s, 0, len-1);
    }

    private void swap(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
