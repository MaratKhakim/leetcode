package string;

/**
 * Date 27.04.2020.
 *
 * 242. Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * You may assume the string contains only lowercase alphabets.
 *
 * https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        for (char c : s.toCharArray())
            letters[c-'a']++;

        for (char c : t.toCharArray())
            letters[c-'a']--;

        for (int i = 0; i < letters.length; i++)
            if (letters[i] != 0)
                return false;

        return true;
    }
}
