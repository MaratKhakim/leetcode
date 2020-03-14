package string;

/**
 *  1347. Minimum Number of Steps to Make Two Strings Anagram
 *
 *  Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */


public class MinStepsTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];

        int res = 0;

        for (int i = 0; i < t.length(); i++) {
            sArray[s.charAt(i)-'a']++;
            tArray[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < sArray.length; i++) {
            res += Math.abs(sArray[i]-tArray[i]);
        }

        return res/2;
    }
}
